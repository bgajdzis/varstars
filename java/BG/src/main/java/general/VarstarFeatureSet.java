package general;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Map;

@Entity
public class VarstarFeatureSet {

    // Matching DB column names in annotation

    @Column(name = "timeseries")
    private Map<Double, Double> timeseriesObs;
    @Column(name = "all_times_nhist_numpeaks")
    private Double allTimesNhistNumpeaks;
    @Column(name = "all_times_nhist_peak1_bin")
    private Double allTimesNhistPeak1Bin;
    @Column(name = "all_times_nhist_peak_1_to_2")
    private Double allTimesNhistPeak1To2;
    @Column(name = "all_times_nhist_peak_1_to_3")
    private Double allTimesNhistPeak1To3;
    @Column(name = "all_times_nhist_peak_1_to_4")
    private Double allTimesNhistPeak1To4;
    @Column(name = "all_times_nhist_peak2_bin")
    private Double allTimesNhistPeak2Bin;
    @Column(name = "all_times_nhist_peak_2_to_3")
    private Double allTimesNhistPeak2To3;
    @Column(name = "all_times_nhist_peak_2_to_4")
    private Double allTimesNhistPeak2To4;
    @Column(name = "all_times_nhist_peak3_bin")
    private Double allTimesNhistPeak3Bin;
    @Column(name = "all_times_nhist_peak_3_to_4")
    private Double allTimesNhistPeak3To4;
    @Column(name = "all_times_nhist_peak4_bin")
    private Double allTimesNhistPeak4Bin;
    @Column(name = "all_times_nhist_peak_val")
    private Double allTimesNhistPeakVal;
    @Column(name = "amplitude")
    private Double amplitude;
    @Column(name = "avg_double_to_single_step")
    private Double avgDoubleToSingleStep;
    @Column(name = "avg_err")
    private Double avgErr;
    @Column(name = "avgt")
    private Double avgt;
    @Column(name = "cad_probs_1")
    private Double cadProbs1;
    @Column(name = "cad_probs_10")
    private Double cadProbs10;
    @Column(name = "cad_probs_100")
    private Double cadProbs100;
    @Column(name = "cad_probs_1000")
    private Double cadProbs1000;
    @Column(name = "cad_probs_10000")
    private Double cadProbs10000;
    @Column(name = "cad_probs_100000")
    private Double cadProbs100000;
    @Column(name = "cad_probs_1000000")
    private Double cadProbs1000000;
    @Column(name = "cad_probs_10000000")
    private Double cadProbs10000000;
    @Column(name = "cad_probs_20")
    private Double cadProbs20;
    @Column(name = "cad_probs_30")
    private Double cadProbs30;
    @Column(name = "cad_probs_40")
    private Double cadProbs40;
    @Column(name = "cad_probs_50")
    private Double cadProbs50;
    @Column(name = "cad_probs_500")
    private Double cadProbs500;
    @Column(name = "cad_probs_5000")
    private Double cadProbs5000;
    @Column(name = "cad_probs_50000")
    private Double cadProbs50000;
    @Column(name = "cad_probs_500000")
    private Double cadProbs500000;
    @Column(name = "cad_probs_5000000")
    private Double cadProbs5000000;
    @Column(name = "cads_avg")
    private Double cadsAvg;
    @Column(name = "cads_med")
    private Double cadsMed;
    @Column(name = "cads_std")
    private Double cadsStd;
    @Column(name = "flux_percentile_ratio_mid20")
    private Double fluxPercentileRatioMid20;
    @Column(name = "flux_percentile_ratio_mid35")
    private Double fluxPercentileRatioMid35;
    @Column(name = "flux_percentile_ratio_mid50")
    private Double fluxPercentileRatioMid50;
    @Column(name = "flux_percentile_ratio_mid65")
    private Double fluxPercentileRatioMid65;
    @Column(name = "flux_percentile_ratio_mid80")
    private Double fluxPercentileRatioMid80;
    @Column(name = "fold2p_slope_10percentile")
    private Double fold2pSlope10percentile;
    @Column(name = "fold2p_slope_90percentile")
    private Double fold2pSlope90percentile;
    @Column(name = "freq1_amplitude1")
    private Double freq1Amplitude1;
    @Column(name = "freq1_amplitude2")
    private Double freq1Amplitude2;
    @Column(name = "freq1_amplitude3")
    private Double freq1Amplitude3;
    @Column(name = "freq1_amplitude4")
    private Double freq1Amplitude4;
    @Column(name = "freq1_freq")
    private Double freq1Freq;
    @Column(name = "freq1_lambda")
    private Double freq1Lambda;
    @Column(name = "freq1_rel_phase2")
    private Double freq1RelPhase2;
    @Column(name = "freq1_rel_phase3")
    private Double freq1RelPhase3;
    @Column(name = "freq1_rel_phase4")
    private Double freq1RelPhase4;
    @Column(name = "freq1_signif")
    private Double freq1Signif;
    @Column(name = "freq2_amplitude1")
    private Double freq2Amplitude1;
    @Column(name = "freq2_amplitude2")
    private Double freq2Amplitude2;
    @Column(name = "freq2_amplitude3")
    private Double freq2Amplitude3;
    @Column(name = "freq2_amplitude4")
    private Double freq2Amplitude4;
    @Column(name = "freq2_freq")
    private Double freq2Freq;
    @Column(name = "freq2_rel_phase2")
    private Double freq2RelPhase2;
    @Column(name = "freq2_rel_phase3")
    private Double freq2RelPhase3;
    @Column(name = "freq2_rel_phase4")
    private Double freq2RelPhase4;
    @Column(name = "freq3_amplitude1")
    private Double freq3Amplitude1;
    @Column(name = "freq3_amplitude2")
    private Double freq3Amplitude2;
    @Column(name = "freq3_amplitude3")
    private Double freq3Amplitude3;
    @Column(name = "freq3_amplitude4")
    private Double freq3Amplitude4;
    @Column(name = "freq3_freq")
    private Double freq3Freq;
    @Column(name = "freq3_rel_phase2")
    private Double freq3RelPhase2;
    @Column(name = "freq3_rel_phase3")
    private Double freq3RelPhase3;
    @Column(name = "freq3_rel_phase4")
    private Double freq3RelPhase4;
    @Column(name = "freq_amplitude_ratio_21")
    private Double freqAmplitudeRatio21;
    @Column(name = "freq_amplitude_ratio_31")
    private Double freqAmplitudeRatio31;
    @Column(name = "freq_frequency_ratio_21")
    private Double freqFrequencyRatio21;
    @Column(name = "freq_frequency_ratio_31")
    private Double freqFrequencyRatio31;
    @Column(name = "freq_model_max_delta_mags")
    private Double freqModelMaxDeltaMags;
    @Column(name = "freq_model_min_delta_mags")
    private Double freqModelMinDeltaMags;
    @Column(name = "freq_model_phi1_phi2")
    private Double freqModelPhi1Phi2;
    @Column(name = "freq_n_alias")
    private Double freqNAlias;
    @Column(name = "freq_signif_ratio_21")
    private Double freqSignifRatio21;
    @Column(name = "freq_signif_ratio_31")
    private Double freqSignifRatio31;
    @Column(name = "freq_varrat")
    private Double freqVarrat;
    @Column(name = "freq_y_offset")
    private Double freqYOffset;
    @Column(name = "linear_trend")
    private Double linearTrend;
    @Column(name = "maximum")
    private Double maximum;
    @Column(name = "max_slope")
    private Double maxSlope;
    @Column(name = "mean")
    private Double mean;
    @Column(name = "med_double_to_single_step")
    private Double medDoubleToSingleStep;
    @Column(name = "med_err")
    private Double medErr;
    @Column(name = "median")
    private Double median;
    @Column(name = "median_absolute_deviation")
    private Double medianAbsoluteDeviation;
    @Column(name = "medperc90_2p_p")
    private Double medperc902pP;
    @Column(name = "minimum")
    private Double minimum;
    @Column(name = "n_epochs")
    private Double nEpochs;
    @Column(name = "p2p_scatter_2praw")
    private Double p2pScatter2praw;
    @Column(name = "p2p_scatter_over_mad")
    private Double p2pScatterOverMad;
    @Column(name = "p2p_scatter_pfold_over_mad")
    private Double p2pScatterPfoldOverMad;
    @Column(name = "p2p_ssqr_diff_over_var")
    private Double p2pSsqrDiffOverVar;
    @Column(name = "percent_amplitude")
    private Double percentAmplitude;
    @Column(name = "percent_beyond_1_std")
    private Double percentBeyond1Std;
    @Column(name = "percent_close_to_median")
    private Double percentCloseToMedian;
    @Column(name = "percent_difference_flux_percentile")
    private Double percentDifferenceFluxPercentile;
    @Column(name = "period_fast")
    private Double periodFast;
    @Column(name = "qso_log_chi2nunull_chi2nu")
    private Double qsoLogChi2nunullChi2nu;
    @Column(name = "qso_log_chi2_qsonu")
    private Double qsoLogChi2Qsonu;
    @Column(name = "scatter_res_raw")
    private Double scatterResRaw;
    @Column(name = "skew")
    private Double skew;
    @Column(name = "std")
    private Double std;
    @Column(name = "std_double_to_single_step")
    private Double stdDoubleToSingleStep;
    @Column(name = "std_err")
    private Double stdErr;
    @Column(name = "stetson_j")
    private Double stetsonJ;
    @Column(name = "stetson_k")
    private Double stetsonK;
    @Column(name = "stetson_mean")
    private Double stetsonMean;
    @Column(name = "total_time")
    private Double totalTime;
    @Column(name = "weighted_average")
    private Double weightedAverage;
    @Column(name = "bls_period_1")
    private Double blsPeriod1;
    @Column(name = "bls_tc_1")
    private Double blsTc1;
    @Column(name = "signal_to_noise_1")
    private Double blsSignalToNoise1;
    @Column(name = "signal_residue_1")
    private Double blsSignalResidue1;
    @Column(name = "signal_detection_eff_1")
    private Double blsSignalDetectionEfficiency1;
    @Column(name = "bls_depth_1")
    private Double blsDepth1;
    @Column(name = "bls_qtran_1")
    private Double blsQTransit1;
    @Column(name = "bls_i1_1")
    private Double blsI11;
    @Column(name = "bls_i2_1")
    private Double blsI21;
    @Column(name = "bls_delta_chi2_1")
    private Double blsDeltaChi21;
    @Column(name = "bls_fraconenight_1")
    private Double blsFracOneNight1;
    @Column(name = "bls_npointsintransit_1")
    private Double blsNPointsInTransit1;
    @Column(name = "bls_ntransits_1")
    private Double blsNTransits1;
    @Column(name = "bls_npointsbeforetransit_1")
    private Double blsNPointsBeforeTransit1;
    @Column(name = "bls_npointsaftertransit_1")
    private Double blsNPointsAfterTransit1;
    @Column(name = "red_noise_1")
    private Double blsRedNoise1;
    @Column(name = "white_noise_1")
    private Double blsWhiteNoise1;
    @Column(name = "signal_to_pink_noise_1")
    private Double blsSignalToPinkNoise1;
    @Column(name = "bls_period_2")
    private Double blsPeriod2;
    @Column(name = "bls_tc_2")
    private Double blsTc2;
    @Column(name = "signal_to_noise_2")
    private Double blsSignalToNoise2;
    @Column(name = "signal_residue_2")
    private Double blsSignalResidue2;
    @Column(name = "signal_detection_eff_2")
    private Double blsSignalDetectionEfficiency2;
    @Column(name = "bls_depth_2")
    private Double blsDepth2;
    @Column(name = "bls_qtran_2")
    private Double blsQTransit2;
    @Column(name = "bls_i1_2")
    private Double blsI12;
    @Column(name = "bls_i2_2")
    private Double blsI22;
    @Column(name = "bls_delta_chi2_2")
    private Double blsDeltaChi22;
    @Column(name = "bls_fraconenight_2")
    private Double blsFracOneNight2;
    @Column(name = "bls_npointsintransit_2")
    private Double blsNPointsInTransit2;
    @Column(name = "bls_ntransits_2")
    private Double blsNTransits2;
    @Column(name = "bls_npointsbeforetransit_2")
    private Double blsNPointsBeforeTransit2;
    @Column(name = "bls_npointsaftertransit_2")
    private Double blsNPointsAfterTransit2;
    @Column(name = "red_noise_2")
    private Double blsRedNoise2;
    @Column(name = "white_noise_2")
    private Double blsWhiteNoise2;
    @Column(name = "signal_to_pink_noise_2")
    private Double blsSignalToPinkNoise2;
    @Column(name = "period_inverse_transit")
    private Double periodInverseTransit;
    @Column(name = "delta_chi2_inverse_transit")
    private Double deltaChi2InverseTransit;
    @Column(name = "bls_meanmag")
    private Double blsMeanMag;
    @Column(name = "alarm")
    private Double alarm;
    @Column(name = "chi2_2_dof")
    private Double chi22Dof;
    @Column(name = "weighted_mean_mag")
    private Double weightedMeanMag;

    public VarstarFeatureSet() {
    }

    public Double getBlsPeriod1() {
        return blsPeriod1;
    }

    public void setBlsPeriod1(Double blsPeriod1) {
        this.blsPeriod1 = blsPeriod1;
    }

    public Double getBlsTc1() {
        return blsTc1;
    }

    public void setBlsTc1(Double blsTc1) {
        this.blsTc1 = blsTc1;
    }

    public Double getBlsSignalToNoise1() {
        return blsSignalToNoise1;
    }

    public void setBlsSignalToNoise1(Double blsSignalToNoise1) {
        this.blsSignalToNoise1 = blsSignalToNoise1;
    }

    public Double getBlsSignalResidue1() {
        return blsSignalResidue1;
    }

    public void setBlsSignalResidue1(Double blsSignalResidue1) {
        this.blsSignalResidue1 = blsSignalResidue1;
    }

    public Double getBlsSignalDetectionEfficiency1() {
        return blsSignalDetectionEfficiency1;
    }

    public void setBlsSignalDetectionEfficiency1(Double blsSignalDetectionEfficiency1) {
        this.blsSignalDetectionEfficiency1 = blsSignalDetectionEfficiency1;
    }

    public Double getBlsDepth1() {
        return blsDepth1;
    }

    public void setBlsDepth1(Double blsDepth1) {
        this.blsDepth1 = blsDepth1;
    }

    public Double getBlsQTransit1() {
        return blsQTransit1;
    }

    public void setBlsQTransit1(Double blsQTransit1) {
        this.blsQTransit1 = blsQTransit1;
    }

    public Double getBlsI11() {
        return blsI11;
    }

    public void setBlsI11(Double blsI11) {
        this.blsI11 = blsI11;
    }

    public Double getBlsI21() {
        return blsI21;
    }

    public void setBlsI21(Double blsI21) {
        this.blsI21 = blsI21;
    }

    public Double getBlsDeltaChi21() {
        return blsDeltaChi21;
    }

    public void setBlsDeltaChi21(Double blsDeltaChi21) {
        this.blsDeltaChi21 = blsDeltaChi21;
    }

    public Double getBlsFracOneNight1() {
        return blsFracOneNight1;
    }

    public void setBlsFracOneNight1(Double blsFracOneNight1) {
        this.blsFracOneNight1 = blsFracOneNight1;
    }

    public Double getBlsNPointsInTransit1() {
        return blsNPointsInTransit1;
    }

    public void setBlsNPointsInTransit1(Double blsNPointsInTransit1) {
        this.blsNPointsInTransit1 = blsNPointsInTransit1;
    }

    public Double getBlsNTransits1() {
        return blsNTransits1;
    }

    public void setBlsNTransits1(Double blsNTransits1) {
        this.blsNTransits1 = blsNTransits1;
    }

    public Double getBlsNPointsBeforeTransit1() {
        return blsNPointsBeforeTransit1;
    }

    public void setBlsNPointsBeforeTransit1(Double blsNPointsBeforeTransit1) {
        this.blsNPointsBeforeTransit1 = blsNPointsBeforeTransit1;
    }

    public Double getBlsNPointsAfterTransit1() {
        return blsNPointsAfterTransit1;
    }

    public void setBlsNPointsAfterTransit1(Double blsNPointsAfterTransit1) {
        this.blsNPointsAfterTransit1 = blsNPointsAfterTransit1;
    }

    public Double getBlsRedNoise1() {
        return blsRedNoise1;
    }

    public void setBlsRedNoise1(Double blsRedNoise1) {
        this.blsRedNoise1 = blsRedNoise1;
    }

    public Double getBlsWhiteNoise1() {
        return blsWhiteNoise1;
    }

    public void setBlsWhiteNoise1(Double blsWhiteNoise1) {
        this.blsWhiteNoise1 = blsWhiteNoise1;
    }

    public Double getBlsSignalToPinkNoise1() {
        return blsSignalToPinkNoise1;
    }

    public void setBlsSignalToPinkNoise1(Double blsSignalToPinkNoise1) {
        this.blsSignalToPinkNoise1 = blsSignalToPinkNoise1;
    }

    public Double getBlsPeriod2() {
        return blsPeriod2;
    }

    public void setBlsPeriod2(Double blsPeriod2) {
        this.blsPeriod2 = blsPeriod2;
    }

    public Double getBlsTc2() {
        return blsTc2;
    }

    public void setBlsTc2(Double blsTc2) {
        this.blsTc2 = blsTc2;
    }

    public Double getBlsSignalToNoise2() {
        return blsSignalToNoise2;
    }

    public void setBlsSignalToNoise2(Double blsSignalToNoise2) {
        this.blsSignalToNoise2 = blsSignalToNoise2;
    }

    public Double getBlsSignalResidue2() {
        return blsSignalResidue2;
    }

    public void setBlsSignalResidue2(Double blsSignalResidue2) {
        this.blsSignalResidue2 = blsSignalResidue2;
    }

    public Double getBlsSignalDetectionEfficiency2() {
        return blsSignalDetectionEfficiency2;
    }

    public void setBlsSignalDetectionEfficiency2(Double blsSignalDetectionEfficiency2) {
        this.blsSignalDetectionEfficiency2 = blsSignalDetectionEfficiency2;
    }

    public Double getBlsDepth2() {
        return blsDepth2;
    }

    public void setBlsDepth2(Double blsDepth2) {
        this.blsDepth2 = blsDepth2;
    }

    public Double getBlsQTransit2() {
        return blsQTransit2;
    }

    public void setBlsQTransit2(Double blsQTransit2) {
        this.blsQTransit2 = blsQTransit2;
    }

    public Double getBlsI12() {
        return blsI12;
    }

    public void setBlsI12(Double blsI12) {
        this.blsI12 = blsI12;
    }

    public Double getBlsI22() {
        return blsI22;
    }

    public void setBlsI22(Double blsI22) {
        this.blsI22 = blsI22;
    }

    public Double getBlsDeltaChi22() {
        return blsDeltaChi22;
    }

    public void setBlsDeltaChi22(Double blsDeltaChi22) {
        this.blsDeltaChi22 = blsDeltaChi22;
    }

    public Double getBlsFracOneNight2() {
        return blsFracOneNight2;
    }

    public void setBlsFracOneNight2(Double blsFracOneNight2) {
        this.blsFracOneNight2 = blsFracOneNight2;
    }

    public Double getBlsNPointsInTransit2() {
        return blsNPointsInTransit2;
    }

    public void setBlsNPointsInTransit2(Double blsNPointsInTransit2) {
        this.blsNPointsInTransit2 = blsNPointsInTransit2;
    }

    public Double getBlsNTransits2() {
        return blsNTransits2;
    }

    public void setBlsNTransits2(Double blsNTransits2) {
        this.blsNTransits2 = blsNTransits2;
    }

    public Double getBlsNPointsBeforeTransit2() {
        return blsNPointsBeforeTransit2;
    }

    public void setBlsNPointsBeforeTransit2(Double blsNPointsBeforeTransit2) {
        this.blsNPointsBeforeTransit2 = blsNPointsBeforeTransit2;
    }

    public Double getBlsNPointsAfterTransit2() {
        return blsNPointsAfterTransit2;
    }

    public void setBlsNPointsAfterTransit2(Double blsNPointsAfterTransit2) {
        this.blsNPointsAfterTransit2 = blsNPointsAfterTransit2;
    }

    public Double getBlsRedNoise2() {
        return blsRedNoise2;
    }

    public void setBlsRedNoise2(Double blsRedNoise2) {
        this.blsRedNoise2 = blsRedNoise2;
    }

    public Double getBlsWhiteNoise2() {
        return blsWhiteNoise2;
    }

    public void setBlsWhiteNoise2(Double blsWhiteNoise2) {
        this.blsWhiteNoise2 = blsWhiteNoise2;
    }

    public Double getBlsSignalToPinkNoise2() {
        return blsSignalToPinkNoise2;
    }

    public void setBlsSignalToPinkNoise2(Double blsSignalToPinkNoise2) {
        this.blsSignalToPinkNoise2 = blsSignalToPinkNoise2;
    }

    public Double getPeriodInverseTransit() {
        return periodInverseTransit;
    }

    public void setPeriodInverseTransit(Double periodInverseTransit) {
        this.periodInverseTransit = periodInverseTransit;
    }

    public Double getDeltaChi2InverseTransit() {
        return deltaChi2InverseTransit;
    }

    public void setDeltaChi2InverseTransit(Double deltaChi2InverseTransit) {
        this.deltaChi2InverseTransit = deltaChi2InverseTransit;
    }

    public Double getBlsMeanMag() {
        return blsMeanMag;
    }

    public void setBlsMeanMag(Double blsMeanMag) {
        this.blsMeanMag = blsMeanMag;
    }

    public Double getAlarm() {
        return alarm;
    }

    public void setAlarm(Double alarm) {
        this.alarm = alarm;
    }

    public Double getChi22Dof() {
        return chi22Dof;
    }

    public void setChi22Dof(Double chi22Dof) {
        this.chi22Dof = chi22Dof;
    }

    public Double getWeightedMeanMag() {
        return weightedMeanMag;
    }

    public void setWeightedMeanMag(Double weightedMeanMag) {
        this.weightedMeanMag = weightedMeanMag;
    }

    public Map<Double, Double> getTimeseriesObs() {
        return timeseriesObs;
    }

    public void setTimeseriesObs(Map<Double, Double> timeseriesObs) {
        this.timeseriesObs = timeseriesObs;
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }

    public Double getPercentAmplitude() {
        return percentAmplitude;
    }

    public void setPercentAmplitude(Double percentAmplitude) {
        this.percentAmplitude = percentAmplitude;
    }

    public Double getPercentDifferenceFluxPercentile() {
        return percentDifferenceFluxPercentile;
    }

    public void setPercentDifferenceFluxPercentile(Double percentDifferenceFluxPercentile) {
        this.percentDifferenceFluxPercentile = percentDifferenceFluxPercentile;
    }

    public Double getFluxPercentileRatioMid20() {
        return fluxPercentileRatioMid20;
    }

    public void setFluxPercentileRatioMid20(Double fluxPercentileRatioMid20) {
        this.fluxPercentileRatioMid20 = fluxPercentileRatioMid20;
    }

    public Double getFluxPercentileRatioMid35() {
        return fluxPercentileRatioMid35;
    }

    public void setFluxPercentileRatioMid35(Double fluxPercentileRatioMid35) {
        this.fluxPercentileRatioMid35 = fluxPercentileRatioMid35;
    }

    public Double getFluxPercentileRatioMid50() {
        return fluxPercentileRatioMid50;
    }

    public void setFluxPercentileRatioMid50(Double fluxPercentileRatioMid50) {
        this.fluxPercentileRatioMid50 = fluxPercentileRatioMid50;
    }

    public Double getFluxPercentileRatioMid65() {
        return fluxPercentileRatioMid65;
    }

    public void setFluxPercentileRatioMid65(Double fluxPercentileRatioMid65) {
        this.fluxPercentileRatioMid65 = fluxPercentileRatioMid65;
    }

    public Double getFluxPercentileRatioMid80() {
        return fluxPercentileRatioMid80;
    }

    public void setFluxPercentileRatioMid80(Double fluxPercentileRatioMid80) {
        this.fluxPercentileRatioMid80 = fluxPercentileRatioMid80;
    }

    public Double getMedDoubleToSingleStep() {
        return medDoubleToSingleStep;
    }

    public void setMedDoubleToSingleStep(Double medDoubleToSingleStep) {
        this.medDoubleToSingleStep = medDoubleToSingleStep;
    }

    public Double getAvgDoubleToSingleStep() {
        return avgDoubleToSingleStep;
    }

    public void setAvgDoubleToSingleStep(Double avgDoubleToSingleStep) {
        this.avgDoubleToSingleStep = avgDoubleToSingleStep;
    }

    public Double getStdDoubleToSingleStep() {
        return stdDoubleToSingleStep;
    }

    public void setStdDoubleToSingleStep(Double stdDoubleToSingleStep) {
        this.stdDoubleToSingleStep = stdDoubleToSingleStep;
    }

    public Double getCadsMed() {
        return cadsMed;
    }

    public void setCadsMed(Double cadsMed) {
        this.cadsMed = cadsMed;
    }

    public Double getCadsAvg() {
        return cadsAvg;
    }

    public void setCadsAvg(Double cadsAvg) {
        this.cadsAvg = cadsAvg;
    }

    public Double getCadsStd() {
        return cadsStd;
    }

    public void setCadsStd(Double cadsStd) {
        this.cadsStd = cadsStd;
    }

    public Double getMedErr() {
        return medErr;
    }

    public void setMedErr(Double medErr) {
        this.medErr = medErr;
    }

    public Double getAvgErr() {
        return avgErr;
    }

    public void setAvgErr(Double avgErr) {
        this.avgErr = avgErr;
    }

    public Double getStdErr() {
        return stdErr;
    }

    public void setStdErr(Double stdErr) {
        this.stdErr = stdErr;
    }

    public Double getMaxSlope() {
        return maxSlope;
    }

    public void setMaxSlope(Double maxSlope) {
        this.maxSlope = maxSlope;
    }

    public Double getMedianAbsoluteDeviation() {
        return medianAbsoluteDeviation;
    }

    public void setMedianAbsoluteDeviation(Double medianAbsoluteDeviation) {
        this.medianAbsoluteDeviation = medianAbsoluteDeviation;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getPercentCloseToMedian() {
        return percentCloseToMedian;
    }

    public void setPercentCloseToMedian(Double percentCloseToMedian) {
        this.percentCloseToMedian = percentCloseToMedian;
    }

    public Double getSkew() {
        return skew;
    }

    public void setSkew(Double skew) {
        this.skew = skew;
    }

    public Double getStd() {
        return std;
    }

    public void setStd(Double std) {
        this.std = std;
    }

    public Double getMedian() {
        return median;
    }

    public void setMedian(Double median) {
        this.median = median;
    }

    public Double getPercentBeyond1Std() {
        return percentBeyond1Std;
    }

    public void setPercentBeyond1Std(Double percentBeyond1Std) {
        this.percentBeyond1Std = percentBeyond1Std;
    }

    public Double getWeightedAverage() {
        return weightedAverage;
    }

    public void setWeightedAverage(Double weightedAverage) {
        this.weightedAverage = weightedAverage;
    }

    public Double getStetsonMean() {
        return stetsonMean;
    }

    public void setStetsonMean(Double stetsonMean) {
        this.stetsonMean = stetsonMean;
    }

    public Double getStetsonJ() {
        return stetsonJ;
    }

    public void setStetsonJ(Double stetsonJ) {
        this.stetsonJ = stetsonJ;
    }

    public Double getStetsonK() {
        return stetsonK;
    }

    public void setStetsonK(Double stetsonK) {
        this.stetsonK = stetsonK;
    }

    public Double getNEpochs() {
        return nEpochs;
    }

    public void setNEpochs(Double nEpochs) {
        this.nEpochs = nEpochs;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Double getAvgt() {
        return avgt;
    }

    public void setAvgt(Double avgt) {
        this.avgt = avgt;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Double getCadProbs1() {
        return cadProbs1;
    }

    public void setCadProbs1(Double cadProbs1) {
        this.cadProbs1 = cadProbs1;
    }

    public Double getCadProbs10() {
        return cadProbs10;
    }

    public void setCadProbs10(Double cadProbs10) {
        this.cadProbs10 = cadProbs10;
    }

    public Double getCadProbs20() {
        return cadProbs20;
    }

    public void setCadProbs20(Double cadProbs20) {
        this.cadProbs20 = cadProbs20;
    }

    public Double getCadProbs30() {
        return cadProbs30;
    }

    public void setCadProbs30(Double cadProbs30) {
        this.cadProbs30 = cadProbs30;
    }

    public Double getCadProbs40() {
        return cadProbs40;
    }

    public void setCadProbs40(Double cadProbs40) {
        this.cadProbs40 = cadProbs40;
    }

    public Double getCadProbs50() {
        return cadProbs50;
    }

    public void setCadProbs50(Double cadProbs50) {
        this.cadProbs50 = cadProbs50;
    }

    public Double getCadProbs100() {
        return cadProbs100;
    }

    public void setCadProbs100(Double cadProbs100) {
        this.cadProbs100 = cadProbs100;
    }

    public Double getCadProbs500() {
        return cadProbs500;
    }

    public void setCadProbs500(Double cadProbs500) {
        this.cadProbs500 = cadProbs500;
    }

    public Double getCadProbs1000() {
        return cadProbs1000;
    }

    public void setCadProbs1000(Double cadProbs1000) {
        this.cadProbs1000 = cadProbs1000;
    }

    public Double getCadProbs5000() {
        return cadProbs5000;
    }

    public void setCadProbs5000(Double cadProbs5000) {
        this.cadProbs5000 = cadProbs5000;
    }

    public Double getCadProbs10000() {
        return cadProbs10000;
    }

    public void setCadProbs10000(Double cadProbs10000) {
        this.cadProbs10000 = cadProbs10000;
    }

    public Double getCadProbs50000() {
        return cadProbs50000;
    }

    public void setCadProbs50000(Double cadProbs50000) {
        this.cadProbs50000 = cadProbs50000;
    }

    public Double getCadProbs100000() {
        return cadProbs100000;
    }

    public void setCadProbs100000(Double cadProbs100000) {
        this.cadProbs100000 = cadProbs100000;
    }

    public Double getCadProbs500000() {
        return cadProbs500000;
    }

    public void setCadProbs500000(Double cadProbs500000) {
        this.cadProbs500000 = cadProbs500000;
    }

    public Double getCadProbs1000000() {
        return cadProbs1000000;
    }

    public void setCadProbs1000000(Double cadProbs1000000) {
        this.cadProbs1000000 = cadProbs1000000;
    }

    public Double getCadProbs5000000() {
        return cadProbs5000000;
    }

    public void setCadProbs5000000(Double cadProbs5000000) {
        this.cadProbs5000000 = cadProbs5000000;
    }

    public Double getCadProbs10000000() {
        return cadProbs10000000;
    }

    public void setCadProbs10000000(Double cadProbs10000000) {
        this.cadProbs10000000 = cadProbs10000000;
    }

    public Double getAllTimesNhistNumpeaks() {
        return allTimesNhistNumpeaks;
    }

    public void setAllTimesNhistNumpeaks(Double allTimesNhistNumpeaks) {
        this.allTimesNhistNumpeaks = allTimesNhistNumpeaks;
    }

    public Double getAllTimesNhistPeakVal() {
        return allTimesNhistPeakVal;
    }

    public void setAllTimesNhistPeakVal(Double allTimesNhistPeakVal) {
        this.allTimesNhistPeakVal = allTimesNhistPeakVal;
    }

    public Double getAllTimesNhistPeak1To2() {
        return allTimesNhistPeak1To2;
    }

    public void setAllTimesNhistPeak1To2(Double allTimesNhistPeak1To2) {
        this.allTimesNhistPeak1To2 = allTimesNhistPeak1To2;
    }

    public Double getAllTimesNhistPeak1To3() {
        return allTimesNhistPeak1To3;
    }

    public void setAllTimesNhistPeak1To3(Double allTimesNhistPeak1To3) {
        this.allTimesNhistPeak1To3 = allTimesNhistPeak1To3;
    }

    public Double getAllTimesNhistPeak2To3() {
        return allTimesNhistPeak2To3;
    }

    public void setAllTimesNhistPeak2To3(Double allTimesNhistPeak2To3) {
        this.allTimesNhistPeak2To3 = allTimesNhistPeak2To3;
    }

    public Double getAllTimesNhistPeak1To4() {
        return allTimesNhistPeak1To4;
    }

    public void setAllTimesNhistPeak1To4(Double allTimesNhistPeak1To4) {
        this.allTimesNhistPeak1To4 = allTimesNhistPeak1To4;
    }

    public Double getAllTimesNhistPeak2To4() {
        return allTimesNhistPeak2To4;
    }

    public void setAllTimesNhistPeak2To4(Double allTimesNhistPeak2To4) {
        this.allTimesNhistPeak2To4 = allTimesNhistPeak2To4;
    }

    public Double getAllTimesNhistPeak3To4() {
        return allTimesNhistPeak3To4;
    }

    public void setAllTimesNhistPeak3To4(Double allTimesNhistPeak3To4) {
        this.allTimesNhistPeak3To4 = allTimesNhistPeak3To4;
    }

    public Double getAllTimesNhistPeak1Bin() {
        return allTimesNhistPeak1Bin;
    }

    public void setAllTimesNhistPeak1Bin(Double allTimesNhistPeak1Bin) {
        this.allTimesNhistPeak1Bin = allTimesNhistPeak1Bin;
    }

    public Double getAllTimesNhistPeak2Bin() {
        return allTimesNhistPeak2Bin;
    }

    public void setAllTimesNhistPeak2Bin(Double allTimesNhistPeak2Bin) {
        this.allTimesNhistPeak2Bin = allTimesNhistPeak2Bin;
    }

    public Double getAllTimesNhistPeak3Bin() {
        return allTimesNhistPeak3Bin;
    }

    public void setAllTimesNhistPeak3Bin(Double allTimesNhistPeak3Bin) {
        this.allTimesNhistPeak3Bin = allTimesNhistPeak3Bin;
    }

    public Double getAllTimesNhistPeak4Bin() {
        return allTimesNhistPeak4Bin;
    }

    public void setAllTimesNhistPeak4Bin(Double allTimesNhistPeak4Bin) {
        this.allTimesNhistPeak4Bin = allTimesNhistPeak4Bin;
    }

    public Double getPeriodFast() {
        return periodFast;
    }

    public void setPeriodFast(Double periodFast) {
        this.periodFast = periodFast;
    }

    public Double getQsoLogChi2Qsonu() {
        return qsoLogChi2Qsonu;
    }

    public void setQsoLogChi2Qsonu(Double qsoLogChi2Qsonu) {
        this.qsoLogChi2Qsonu = qsoLogChi2Qsonu;
    }

    public Double getQsoLogChi2nunullChi2nu() {
        return qsoLogChi2nunullChi2nu;
    }

    public void setQsoLogChi2nunullChi2nu(Double qsoLogChi2nunullChi2nu) {
        this.qsoLogChi2nunullChi2nu = qsoLogChi2nunullChi2nu;
    }

    public Double getFold2pSlope10percentile() {
        return fold2pSlope10percentile;
    }

    public void setFold2pSlope10percentile(Double fold2pSlope10percentile) {
        this.fold2pSlope10percentile = fold2pSlope10percentile;
    }

    public Double getFold2pSlope90percentile() {
        return fold2pSlope90percentile;
    }

    public void setFold2pSlope90percentile(Double fold2pSlope90percentile) {
        this.fold2pSlope90percentile = fold2pSlope90percentile;
    }

    public Double getFreq1Amplitude1() {
        return freq1Amplitude1;
    }

    public void setFreq1Amplitude1(Double freq1Amplitude1) {
        this.freq1Amplitude1 = freq1Amplitude1;
    }

    public Double getFreq1Amplitude2() {
        return freq1Amplitude2;
    }

    public void setFreq1Amplitude2(Double freq1Amplitude2) {
        this.freq1Amplitude2 = freq1Amplitude2;
    }

    public Double getFreq1Amplitude3() {
        return freq1Amplitude3;
    }

    public void setFreq1Amplitude3(Double freq1Amplitude3) {
        this.freq1Amplitude3 = freq1Amplitude3;
    }

    public Double getFreq1Amplitude4() {
        return freq1Amplitude4;
    }

    public void setFreq1Amplitude4(Double freq1Amplitude4) {
        this.freq1Amplitude4 = freq1Amplitude4;
    }

    public Double getFreq1Freq() {
        return freq1Freq;
    }

    public void setFreq1Freq(Double freq1Freq) {
        this.freq1Freq = freq1Freq;
    }

    public Double getFreq1Lambda() {
        return freq1Lambda;
    }

    public void setFreq1Lambda(Double freq1Lambda) {
        this.freq1Lambda = freq1Lambda;
    }

    public Double getFreq1RelPhase2() {
        return freq1RelPhase2;
    }

    public void setFreq1RelPhase2(Double freq1RelPhase2) {
        this.freq1RelPhase2 = freq1RelPhase2;
    }

    public Double getFreq1RelPhase3() {
        return freq1RelPhase3;
    }

    public void setFreq1RelPhase3(Double freq1RelPhase3) {
        this.freq1RelPhase3 = freq1RelPhase3;
    }

    public Double getFreq1RelPhase4() {
        return freq1RelPhase4;
    }

    public void setFreq1RelPhase4(Double freq1RelPhase4) {
        this.freq1RelPhase4 = freq1RelPhase4;
    }

    public Double getFreq1Signif() {
        return freq1Signif;
    }

    public void setFreq1Signif(Double freq1Signif) {
        this.freq1Signif = freq1Signif;
    }

    public Double getFreq2Amplitude1() {
        return freq2Amplitude1;
    }

    public void setFreq2Amplitude1(Double freq2Amplitude1) {
        this.freq2Amplitude1 = freq2Amplitude1;
    }

    public Double getFreq2Amplitude2() {
        return freq2Amplitude2;
    }

    public void setFreq2Amplitude2(Double freq2Amplitude2) {
        this.freq2Amplitude2 = freq2Amplitude2;
    }

    public Double getFreq2Amplitude3() {
        return freq2Amplitude3;
    }

    public void setFreq2Amplitude3(Double freq2Amplitude3) {
        this.freq2Amplitude3 = freq2Amplitude3;
    }

    public Double getFreq2Amplitude4() {
        return freq2Amplitude4;
    }

    public void setFreq2Amplitude4(Double freq2Amplitude4) {
        this.freq2Amplitude4 = freq2Amplitude4;
    }

    public Double getFreq2Freq() {
        return freq2Freq;
    }

    public void setFreq2Freq(Double freq2Freq) {
        this.freq2Freq = freq2Freq;
    }

    public Double getFreq2RelPhase2() {
        return freq2RelPhase2;
    }

    public void setFreq2RelPhase2(Double freq2RelPhase2) {
        this.freq2RelPhase2 = freq2RelPhase2;
    }

    public Double getFreq2RelPhase3() {
        return freq2RelPhase3;
    }

    public void setFreq2RelPhase3(Double freq2RelPhase3) {
        this.freq2RelPhase3 = freq2RelPhase3;
    }

    public Double getFreq2RelPhase4() {
        return freq2RelPhase4;
    }

    public void setFreq2RelPhase4(Double freq2RelPhase4) {
        this.freq2RelPhase4 = freq2RelPhase4;
    }

    public Double getFreq3Amplitude1() {
        return freq3Amplitude1;
    }

    public void setFreq3Amplitude1(Double freq3Amplitude1) {
        this.freq3Amplitude1 = freq3Amplitude1;
    }

    public Double getFreq3Amplitude2() {
        return freq3Amplitude2;
    }

    public void setFreq3Amplitude2(Double freq3Amplitude2) {
        this.freq3Amplitude2 = freq3Amplitude2;
    }

    public Double getFreq3Amplitude3() {
        return freq3Amplitude3;
    }

    public void setFreq3Amplitude3(Double freq3Amplitude3) {
        this.freq3Amplitude3 = freq3Amplitude3;
    }

    public Double getFreq3Amplitude4() {
        return freq3Amplitude4;
    }

    public void setFreq3Amplitude4(Double freq3Amplitude4) {
        this.freq3Amplitude4 = freq3Amplitude4;
    }

    public Double getFreq3Freq() {
        return freq3Freq;
    }

    public void setFreq3Freq(Double freq3Freq) {
        this.freq3Freq = freq3Freq;
    }

    public Double getFreq3RelPhase2() {
        return freq3RelPhase2;
    }

    public void setFreq3RelPhase2(Double freq3RelPhase2) {
        this.freq3RelPhase2 = freq3RelPhase2;
    }

    public Double getFreq3RelPhase3() {
        return freq3RelPhase3;
    }

    public void setFreq3RelPhase3(Double freq3RelPhase3) {
        this.freq3RelPhase3 = freq3RelPhase3;
    }

    public Double getFreq3RelPhase4() {
        return freq3RelPhase4;
    }

    public void setFreq3RelPhase4(Double freq3RelPhase4) {
        this.freq3RelPhase4 = freq3RelPhase4;
    }

    public Double getFreqAmplitudeRatio21() {
        return freqAmplitudeRatio21;
    }

    public void setFreqAmplitudeRatio21(Double freqAmplitudeRatio21) {
        this.freqAmplitudeRatio21 = freqAmplitudeRatio21;
    }

    public Double getFreqAmplitudeRatio31() {
        return freqAmplitudeRatio31;
    }

    public void setFreqAmplitudeRatio31(Double freqAmplitudeRatio31) {
        this.freqAmplitudeRatio31 = freqAmplitudeRatio31;
    }

    public Double getFreqFrequencyRatio21() {
        return freqFrequencyRatio21;
    }

    public void setFreqFrequencyRatio21(Double freqFrequencyRatio21) {
        this.freqFrequencyRatio21 = freqFrequencyRatio21;
    }

    public Double getFreqFrequencyRatio31() {
        return freqFrequencyRatio31;
    }

    public void setFreqFrequencyRatio31(Double freqFrequencyRatio31) {
        this.freqFrequencyRatio31 = freqFrequencyRatio31;
    }

    public Double getFreqModelMaxDeltaMags() {
        return freqModelMaxDeltaMags;
    }

    public void setFreqModelMaxDeltaMags(Double freqModelMaxDeltaMags) {
        this.freqModelMaxDeltaMags = freqModelMaxDeltaMags;
    }

    public Double getFreqModelMinDeltaMags() {
        return freqModelMinDeltaMags;
    }

    public void setFreqModelMinDeltaMags(Double freqModelMinDeltaMags) {
        this.freqModelMinDeltaMags = freqModelMinDeltaMags;
    }

    public Double getFreqModelPhi1Phi2() {
        return freqModelPhi1Phi2;
    }

    public void setFreqModelPhi1Phi2(Double freqModelPhi1Phi2) {
        this.freqModelPhi1Phi2 = freqModelPhi1Phi2;
    }

    public Double getFreqNAlias() {
        return freqNAlias;
    }

    public void setFreqNAlias(Double freqNAlias) {
        this.freqNAlias = freqNAlias;
    }

    public Double getFreqSignifRatio21() {
        return freqSignifRatio21;
    }

    public void setFreqSignifRatio21(Double freqSignifRatio21) {
        this.freqSignifRatio21 = freqSignifRatio21;
    }

    public Double getFreqSignifRatio31() {
        return freqSignifRatio31;
    }

    public void setFreqSignifRatio31(Double freqSignifRatio31) {
        this.freqSignifRatio31 = freqSignifRatio31;
    }

    public Double getFreqVarrat() {
        return freqVarrat;
    }

    public void setFreqVarrat(Double freqVarrat) {
        this.freqVarrat = freqVarrat;
    }

    public Double getFreqYOffset() {
        return freqYOffset;
    }

    public void setFreqYOffset(Double freqYOffset) {
        this.freqYOffset = freqYOffset;
    }

    public Double getLinearTrend() {
        return linearTrend;
    }

    public void setLinearTrend(Double linearTrend) {
        this.linearTrend = linearTrend;
    }

    public Double getMedperc902pP() {
        return medperc902pP;
    }

    public void setMedperc902pP(Double medperc902pP) {
        this.medperc902pP = medperc902pP;
    }

    public Double getP2pScatter2praw() {
        return p2pScatter2praw;
    }

    public void setP2pScatter2praw(Double p2pScatter2praw) {
        this.p2pScatter2praw = p2pScatter2praw;
    }

    public Double getP2pScatterOverMad() {
        return p2pScatterOverMad;
    }

    public void setP2pScatterOverMad(Double p2pScatterOverMad) {
        this.p2pScatterOverMad = p2pScatterOverMad;
    }

    public Double getP2pScatterPfoldOverMad() {
        return p2pScatterPfoldOverMad;
    }

    public void setP2pScatterPfoldOverMad(Double p2pScatterPfoldOverMad) {
        this.p2pScatterPfoldOverMad = p2pScatterPfoldOverMad;
    }

    public Double getP2pSsqrDiffOverVar() {
        return p2pSsqrDiffOverVar;
    }

    public void setP2pSsqrDiffOverVar(Double p2pSsqrDiffOverVar) {
        this.p2pSsqrDiffOverVar = p2pSsqrDiffOverVar;
    }

    public Double getScatterResRaw() {
        return scatterResRaw;
    }

    public void setScatterResRaw(Double scatterResRaw) {
        this.scatterResRaw = scatterResRaw;
    }

}