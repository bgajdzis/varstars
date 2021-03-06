#!/usr/bin/env python3
# coding: utf-8

from multiprocessing import Process, Queue, Pool, Manager
import argparse
import os, sys
import json
import numpy as np
import pandas as pd
import multiprocessing
import dask as ds
import dask.bag as db
from functools import partial
from scipy import stats
from dask.delayed import delayed
from dask.threaded import get
from dask.optimize import cull, inline, inline_functions, fuse
from dask.diagnostics import ProgressBar
import warnings

from cesium.features.cadence_features import (cad_prob, delta_t_hist, double_to_single_step,
                               normalize_hist, find_sorted_peaks, peak_bin,
                               peak_ratio)
from cesium.features.common_functions import (maximum, median, max_slope,
                               median_absolute_deviation, minimum,
                               percent_beyond_1_std, percent_close_to_median,
                               skew, std, weighted_average)
from cesium.features.amplitude import (amplitude, percent_amplitude, flux_percentile_ratio,
                        percent_difference_flux_percentile)
from cesium.features.qso_model import (qso_fit, get_qso_log_chi2_qsonu,
                        get_qso_log_chi2nuNULL_chi2nu)
from cesium.features.stetson import (stetson_j, stetson_k, stetson_mean)
from cesium.features.lomb_scargle_fast import lomb_scargle_fast_period
from cesium.features.lomb_scargle import (lomb_scargle_model, get_lomb_frequency,
                           get_lomb_amplitude, get_lomb_rel_phase,
                           get_lomb_amplitude_ratio, get_lomb_frequency_ratio,
                           get_lomb_signif_ratio, get_lomb_lambda,
                           get_lomb_signif, get_lomb_varrat, get_lomb_trend,
                           get_lomb_y_offset)
from cesium.features.num_alias import num_alias
from cesium.features.periodic_model import (periodic_model, get_max_delta_mags,
                             get_min_delta_mags, get_model_phi1_phi2)
from cesium.features.period_folding import (period_folding, get_fold2P_slope_percentile,
                             get_medperc90_2p_p, p2p_model,
                             get_p2p_scatter_2praw, get_p2p_scatter_over_mad,
                             get_p2p_scatter_pfold_over_mad,
                             get_p2p_ssqr_diff_over_var)
from cesium.features.scatter_res_raw import scatter_res_raw

def load(filename):
    try:
        with open(filename,"r") as f:
            df = pd.read_table(f,delim_whitespace = True,names=['time','intensity','error'],dtype={'time':np.float64,'intensity':np.float64,'error':np.float64}) # Import data from TSV file
        return df
    except FileNotFoundError as e:
        raise e
                
def get_name(filename, is_ref):
    if is_ref:
        assert (filename.endswith('.dat') and len(filename.split('/')[-1].split('-')) == 4), 'Filename in wrong format for reference object (see README): ' + filename
    return filename.split('/')[-1][:-4].upper().replace('_I_','.')        

def get_type(filename):
    assert (filename.endswith('.dat') and len(filename.split('/')[-1].split('-')) == 4), 'Filename in wrong format for reference object (see README): ' + filename
    return filename.split('/')[-1].split('-')[2]

def transform(df,filename):
    obs_n = df.shape[0]
    assert (obs_n >= 50), 'Not enough observatons: ' + filename
    df[(np.abs(stats.zscore(df)) < 4).all(axis=1)] 
    assert (df.shape[0] > 0.9 * obs_n), 'Too many outliers: ' + filename
    return df

def get_t(df):
    t = df['time'].as_matrix()
    t = t - t[0]
    return t

def get_m(df):
    return df['intensity'].as_matrix()

def get_e(df):
    return df['error'].as_matrix()

def ts_format_json(t,i):
    t = t.tolist()
    i = i.tolist()
    return json.dumps(dict(zip(t,i)))

def formatter(*args):
    query = """%(values)s"""%{'values':'\t'.join(str(x) for x in args[0])}
    return query     
    
def generate_dask_graph(filename, features):
    full_graph = {'filename':filename, 'features':features}
    full_graph.update(dask_feature_graph)
    return full_graph

def stasher(q,outfile,append):
    mode = 'a' if append else 'w'
    with open(outfile, mode) as out:
        while True:
            val = q.get()
            if val is None: break
            out.write(val + '\n')

__all__ = ['CADENCE_FEATS', 'GENERAL_FEATS', 'LOMB_SCARGLE_FEATS',
           'generate_dask_graph', 'feature_categories', 'dask_feature_graph']

feature_categories = {
    'Cadence/Error': [
        'n_epochs','avg_err','med_err','std_err',
        'total_time','avgt','cads_std','mean',
        'cads_avg','cads_med','cad_probs_1',
        'cad_probs_10','cad_probs_20','cad_probs_30',
        'cad_probs_40','cad_probs_50','cad_probs_100',
        'cad_probs_500','cad_probs_1000','cad_probs_5000',
        'cad_probs_10000','cad_probs_50000','cad_probs_100000',
        'cad_probs_500000','cad_probs_1000000','cad_probs_5000000',
        'cad_probs_10000000','med_double_to_single_step',
        'avg_double_to_single_step','std_double_to_single_step',
        'all_times_nhist_numpeaks','all_times_nhist_peak_val',
        'all_times_nhist_peak_1_to_2','all_times_nhist_peak_1_to_3',
        'all_times_nhist_peak_2_to_3','all_times_nhist_peak_1_to_4',
        'all_times_nhist_peak_2_to_4','all_times_nhist_peak_3_to_4',
        'all_times_nhist_peak1_bin','all_times_nhist_peak2_bin',
        'all_times_nhist_peak3_bin','all_times_nhist_peak4_bin'
        ],

    'General': [
        'amplitude', 'flux_percentile_ratio_mid20',
        'flux_percentile_ratio_mid35', 'flux_percentile_ratio_mid50',
        'flux_percentile_ratio_mid65', 'flux_percentile_ratio_mid80',
        'max_slope', 'maximum', 'median', 'median_absolute_deviation',
        'minimum', 'percent_amplitude', 'percent_beyond_1_std',
        'percent_close_to_median',
        'percent_difference_flux_percentile', 'period_fast',
        'qso_log_chi2_qsonu', 'qso_log_chi2nuNULL_chi2nu', 'skew',
        'std', 'stetson_j', 'stetson_k', 'stetson_mean', 'weighted_average'
        ],

    'Lomb-Scargle (Periodic)': [
        'fold2P_slope_10percentile', 'fold2P_slope_90percentile',
        'freq1_amplitude1', 'freq1_amplitude2', 'freq1_amplitude3',
        'freq1_amplitude4', 'freq1_freq', 'freq1_lambda',
        'freq1_rel_phase2', 'freq1_rel_phase3', 'freq1_rel_phase4',
        'freq1_signif', 'freq2_amplitude1', 'freq2_amplitude2',
        'freq2_amplitude3', 'freq2_amplitude4', 'freq2_freq',
        'freq2_rel_phase2', 'freq2_rel_phase3', 'freq2_rel_phase4',
        'freq3_amplitude1', 'freq3_amplitude2', 'freq3_amplitude3',
        'freq3_amplitude4', 'freq3_freq', 'freq3_rel_phase2',
        'freq3_rel_phase3', 'freq3_rel_phase4',
        'freq_amplitude_ratio_21', 'freq_amplitude_ratio_31',
        'freq_frequency_ratio_21', 'freq_frequency_ratio_31',
        'freq_model_max_delta_mags', 'freq_model_min_delta_mags',
        'freq_model_phi1_phi2', 'freq_n_alias',
        'freq_signif_ratio_21', 'freq_signif_ratio_31', 'freq_varrat',
        'freq_y_offset', 'linear_trend', 'medperc90_2p_p',
        'p2p_scatter_2praw', 'p2p_scatter_over_mad',
        'p2p_scatter_pfold_over_mad', 'p2p_ssqr_diff_over_var',
        'scatter_res_raw'
    ]
}

CESIUM_CADENCE_FEATS = feature_categories['Cadence/Error']
CESIUM_GENERAL_FEATS = feature_categories['General']
CESIUM_LOMB_SCARGLE_FEATS = feature_categories['Lomb-Scargle (Periodic)']
VARTOOLS_FEATS =[]
ADDITIONAL_FEATS = []

dask_feature_graph = {
    'loaded': (load,'filename'),
    'name': (get_name,'filename','is_ref'),
    'type': (get_type,'filename'),
    'transformed': (transform,'loaded','filename'),
    't': (get_t,'transformed'),
    'e': (get_e,'transformed'),
    'm': (get_m,'transformed'),
    'n_epochs': (len, 't'),
    'avg_err': (np.mean, 'e'),
    'med_err': (np.median, 'e'),
    'std_err': (np.std, 'e'),
    'total_time': (lambda x: np.max(x) - np.min(x), 't'),
    'avgt': (np.mean, 't'),
    'cads': (np.diff, 't'),
    'cads_std': (np.std, 'cads'),
    'mean': (np.mean, 'm'),
    'cads_avg': (np.mean, 'cads'),
    'cads_med': (np.median, 'cads'),
    'cad_probs_1': (cad_prob, 'cads', 1),
    'cad_probs_10': (cad_prob, 'cads', 10),
    'cad_probs_20': (cad_prob, 'cads', 20),
    'cad_probs_30': (cad_prob, 'cads', 30),
    'cad_probs_40': (cad_prob, 'cads', 40),
    'cad_probs_50': (cad_prob, 'cads', 50),
    'cad_probs_100': (cad_prob, 'cads', 100),
    'cad_probs_500': (cad_prob, 'cads', 500),
    'cad_probs_1000': (cad_prob, 'cads', 1000),
    'cad_probs_5000': (cad_prob, 'cads', 5000),
    'cad_probs_10000': (cad_prob, 'cads', 10000),
    'cad_probs_50000': (cad_prob, 'cads', 50000),
    'cad_probs_100000': (cad_prob, 'cads', 100000),
    'cad_probs_500000': (cad_prob, 'cads', 500000),
    'cad_probs_1000000': (cad_prob, 'cads', 1000000),
    'cad_probs_5000000': (cad_prob, 'cads', 5000000),
    'cad_probs_10000000': (cad_prob, 'cads', 10000000),
    'double_to_single_step': (double_to_single_step, 'cads'),
    'avg_double_to_single_step': (np.mean, 'double_to_single_step'),
    'med_double_to_single_step': (np.median, 'double_to_single_step'),
    'std_double_to_single_step': (np.std, 'double_to_single_step'),
    'delta_t_hist': (delta_t_hist, 't'),
    'delta_t_nhist': (normalize_hist, 'delta_t_hist', 'total_time'),
    'nhist_peaks': (find_sorted_peaks, 'delta_t_nhist'),
    'all_times_nhist_numpeaks': (len, 'nhist_peaks'),
    'all_times_nhist_peak_val': (np.max, 'delta_t_nhist'),
    'all_times_nhist_peak_1_to_2': (peak_ratio, 'nhist_peaks', 1, 2),
    'all_times_nhist_peak_1_to_3': (peak_ratio, 'nhist_peaks', 1, 3),
    'all_times_nhist_peak_2_to_3': (peak_ratio, 'nhist_peaks', 2, 3),
    'all_times_nhist_peak_1_to_4': (peak_ratio, 'nhist_peaks', 1, 4),
    'all_times_nhist_peak_2_to_4': (peak_ratio, 'nhist_peaks', 2, 4),
    'all_times_nhist_peak_3_to_4': (peak_ratio, 'nhist_peaks', 3, 4),
    'all_times_nhist_peak1_bin': (peak_bin, 'nhist_peaks', 1),
    'all_times_nhist_peak2_bin': (peak_bin, 'nhist_peaks', 2),
    'all_times_nhist_peak3_bin': (peak_bin, 'nhist_peaks', 3),
    'all_times_nhist_peak4_bin': (peak_bin, 'nhist_peaks', 4),
    'amplitude': (amplitude, 'm'),
    'flux_percentile_ratio_mid20': (flux_percentile_ratio, 'm', 20),
    'flux_percentile_ratio_mid35': (flux_percentile_ratio, 'm', 35),
    'flux_percentile_ratio_mid50': (flux_percentile_ratio, 'm', 50),
    'flux_percentile_ratio_mid65': (flux_percentile_ratio, 'm', 65),
    'flux_percentile_ratio_mid80': (flux_percentile_ratio, 'm', 80),
    'maximum': (maximum, 'm'),
    'max_slope': (max_slope, 't', 'm'),
    'median': (median, 'm'),
    'median_absolute_deviation': (median_absolute_deviation, 'm'),
    'minimum': (minimum, 'm'),
    'percent_amplitude': (percent_amplitude, 'm'),
    'percent_beyond_1_std': (percent_beyond_1_std, 'm', 'e'),
    'percent_close_to_median': (percent_close_to_median, 'm'),
    'percent_difference_flux_percentile': (percent_difference_flux_percentile, 'm'),
    'skew': (skew, 'm'),
    'std': (std, 'm'),
    'stetson_j': (stetson_j, 'm'),
    'stetson_k': (stetson_k, 'm'),
    'stetson_mean': (stetson_mean, 'm'),
    'weighted_average': (weighted_average, 'm', 'e'),
    'qso_model': (qso_fit, 't', 'm', 'e'),
    'qso_log_chi2_qsonu': (get_qso_log_chi2_qsonu, 'qso_model'),
    'qso_log_chi2nuNULL_chi2nu': (get_qso_log_chi2nuNULL_chi2nu, 'qso_model'),
    'period_fast': (lomb_scargle_fast_period, 't', 'm', 'e'),
    '_lomb_model': (lomb_scargle_model, 't', 'm', 'e'),
    'freq1_freq': (get_lomb_frequency, '_lomb_model', 1),
    'freq2_freq': (get_lomb_frequency, '_lomb_model', 2),
    'freq3_freq': (get_lomb_frequency, '_lomb_model', 3),
    'freq1_amplitude1': (get_lomb_amplitude, '_lomb_model', 1, 1),
    'freq1_amplitude2': (get_lomb_amplitude, '_lomb_model', 1, 2),
    'freq1_amplitude3': (get_lomb_amplitude, '_lomb_model', 1, 3),
    'freq1_amplitude4': (get_lomb_amplitude, '_lomb_model', 1, 4),
    'freq2_amplitude1': (get_lomb_amplitude, '_lomb_model', 2, 1),
    'freq2_amplitude2': (get_lomb_amplitude, '_lomb_model', 2, 2),
    'freq2_amplitude3': (get_lomb_amplitude, '_lomb_model', 2, 3),
    'freq2_amplitude4': (get_lomb_amplitude, '_lomb_model', 2, 4),
    'freq3_amplitude1': (get_lomb_amplitude, '_lomb_model', 3, 1),
    'freq3_amplitude2': (get_lomb_amplitude, '_lomb_model', 3, 2),
    'freq3_amplitude3': (get_lomb_amplitude, '_lomb_model', 3, 3),
    'freq3_amplitude4': (get_lomb_amplitude, '_lomb_model', 3, 4),
    'freq1_rel_phase1': (get_lomb_rel_phase, 'lomb_model', 1, 1),
    'freq1_rel_phase2': (get_lomb_rel_phase, '_lomb_model', 1, 2),
    'freq1_rel_phase3': (get_lomb_rel_phase, '_lomb_model', 1, 3),
    'freq1_rel_phase4': (get_lomb_rel_phase, '_lomb_model', 1, 4),
    'freq2_rel_phase1': (get_lomb_rel_phase, 'lomb_model', 2, 1),
    'freq2_rel_phase2': (get_lomb_rel_phase, '_lomb_model', 2, 2),
    'freq2_rel_phase3': (get_lomb_rel_phase, '_lomb_model', 2, 3),
    'freq2_rel_phase4': (get_lomb_rel_phase, '_lomb_model', 2, 4),
    'freq3_rel_phase1': (get_lomb_rel_phase, 'lomb_model', 3, 1),
    'freq3_rel_phase2': (get_lomb_rel_phase, '_lomb_model', 3, 2),
    'freq3_rel_phase3': (get_lomb_rel_phase, '_lomb_model', 3, 3),
    'freq3_rel_phase4': (get_lomb_rel_phase, '_lomb_model', 3, 4),
    'freq_amplitude_ratio_21': (get_lomb_amplitude_ratio, '_lomb_model', 2),
    'freq_amplitude_ratio_31': (get_lomb_amplitude_ratio, '_lomb_model', 3),
    'freq_frequency_ratio_21': (get_lomb_frequency_ratio, '_lomb_model', 2),
    'freq_frequency_ratio_31': (get_lomb_frequency_ratio, '_lomb_model', 3),
    'freq_signif_ratio_21': (get_lomb_signif_ratio, '_lomb_model', 2),
    'freq_signif_ratio_31': (get_lomb_signif_ratio, '_lomb_model', 3),
    'freq1_lambda': (get_lomb_lambda, '_lomb_model'),
    'freq1_signif': (get_lomb_signif, '_lomb_model'),
    'freq_varrat': (get_lomb_varrat, '_lomb_model'),
    'linear_trend': (get_lomb_trend, '_lomb_model'),
    'freq_y_offset': (get_lomb_y_offset, '_lomb_model'),
    'freq_n_alias': (num_alias, '_lomb_model'),
    'scatter_res_raw': (scatter_res_raw, 't', 'm', 'e', '_lomb_model'),
    '_periodic_model': (periodic_model, '_lomb_model'),
    '_period_folded_model': (period_folding, 't', 'm', 'e', '_lomb_model'),
    'freq_model_max_delta_mags': (get_max_delta_mags, '_periodic_model'),
    'freq_model_min_delta_mags': (get_min_delta_mags, '_periodic_model'),
    'freq_model_phi1_phi2': (get_model_phi1_phi2, '_periodic_model'),
    'fold2P_slope_10percentile': (get_fold2P_slope_percentile, '_period_folded_model', 10),
    'fold2P_slope_90percentile': (get_fold2P_slope_percentile, '_period_folded_model', 90),
    'medperc90_2p_p': (get_medperc90_2p_p, '_period_folded_model'),
    '_p2p_model': (p2p_model, 't', 'm', 'freq1_freq'),
    'p2p_scatter_2praw': (get_p2p_scatter_2praw, '_p2p_model'),
    'p2p_scatter_over_mad': (get_p2p_scatter_over_mad, '_p2p_model'),
    'p2p_scatter_pfold_over_mad': (get_p2p_scatter_pfold_over_mad, '_p2p_model'),
    'p2p_ssqr_diff_over_var': (get_p2p_ssqr_diff_over_var, '_p2p_model'),
    'timeseries': (ts_format_json, 't', 'm'),
    'formatted': (formatter, 'features')
}

def stash(q,line):
    try:
        assert (q is not None), 'Missing sink for stashing'
        assert (line is not None), 'Missing data to be stashed'
        q.put(line)
        return True
    except AssertionError as e:
        print(e)
        return False

def generate_and_get(file, features, keys, finalize, stash, drain, is_ref, warns):
    dsk = generate_dask_graph(file,features)
    dsk['is_ref'] = is_ref
    dsk['drain'] = drain
    dsk['stashed'] = (stash,'drain','formatted')
    dsk1, deps = cull(dsk, keys)
    dsk2 = inline(dsk1, dependencies=deps)
    dsk3 = inline_functions(dsk2, keys, [len, str.split], dependencies=deps)
    dsk4, deps = fuse(dsk3)
    with warnings.catch_warnings():
        warnings.simplefilter(warns,RuntimeWarning)
        try:
            return get(dsk4,finalize)
        except RuntimeWarning as w:
            print('Warning raised in file',file,'\n',w)
            return None
        except AssertionError as e:
            print('Problem in file',file,'\n',e)
            return None

def featurize(inputfiles,outfile,is_ref=True,pg_header=False,tsv_header=False,append=False,warns='always'):

    features = ['name', 'type', 'timeseries'] + CESIUM_CADENCE_FEATS + CESIUM_GENERAL_FEATS + CESIUM_LOMB_SCARGLE_FEATS + ADDITIONAL_FEATS
    if not is_ref: features.remove('type')
    keys = ['stashed']
    procno = multiprocessing.cpu_count()
    m = Manager()
    drain = m.Queue()
    p = Process(target=stasher, args=(drain,outfile,append,))
    p.daemon = True
    p.start()
    table_name = 'reference_timeseries' if is_ref else 'input_timeseries'
    if pg_header: drain.put("""COPY %(table_name)s (%(keys)s) FROM stdin;\n"""%{'table_name' : table_name, 'keys' : ','.join(features)})
    if tsv_header: drain.put("""%(keys)s\n"""%{'keys' : '\t'.join(features)})
    get_from_filename = partial(generate_and_get, keys = keys, features = features, finalize = 'stashed', stash = stash, drain = drain, is_ref = is_ref, warns = warns)

    with Pool(processes=procno) as pool:
        results = pool.map(get_from_filename,inputfiles)
    drain.put(None)
    p.join()

if __name__=="__main__":
    parser = argparse.ArgumentParser(description='Load and featurize given lightcurves.')
    group_in = parser.add_mutually_exclusive_group(required=True)
    group_in.add_argument('-f',type=str,help='a file containing file names for input listed on separate lines')
    group_in.add_argument('-l',nargs='+',type=str,help='a list of file names for input')
    header = parser.add_mutually_exclusive_group(required=False)
    header.add_argument('--postgres-header',action='store_true',help='include postgres copy-statement as header')
    header.add_argument('--tsv-header',action='store_true',help='include tsv header')
    header.add_argument('--append',action='store_true',help='append to output file, no header')
    parser.add_argument('-o',nargs='?',type=str,help='a file name for output. By default "outfile.dat"',default='outfile.dat')    
    parser.add_argument('-S',action='store_false',help='load data as signal granules instead of reference set')
    parser.add_argument('-w',nargs='?',type=str,default='always',help='rule for handling runtime warnings. "ignore", "error". By default "always"')
    args = parser.parse_args()
    if args.w not in ['always','ignore','error']: args.w='always'
    if args.l is not None:
        try:    
            featurize(args.l,args.o,args.S,args.postgres_header,args.tsv_header,args.append,args.w)
        except:
            print('Something went wrong.')
            raise
    elif args.f is not None:
        flist = []
        try:
            with open(args.f,'r') as infiles:
                for line in infiles.readlines():
                    flist.append(line[:-1])
            featurize(flist,args.o,args.S,args.postgres_header,args.tsv_header,args.append,args.w)
        except:
            print('Something went wrong.')
            raise 
    else:
        print('Missing arugment')
