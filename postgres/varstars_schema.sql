--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 9.6.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: first_predictions; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE first_predictions (
    name text,
    actual text
);


--
-- Name: input_timeseries; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE input_timeseries (
    object_id character varying(32),
    timeseries jsonb,
    n_epochs double precision,
    avg_err double precision,
    med_err double precision,
    std_err double precision,
    total_time double precision,
    avgt double precision,
    cads_std double precision,
    mean double precision,
    cads_avg double precision,
    cads_med double precision,
    cad_probs_1 double precision,
    cad_probs_10 double precision,
    cad_probs_20 double precision,
    cad_probs_30 double precision,
    cad_probs_40 double precision,
    cad_probs_50 double precision,
    cad_probs_100 double precision,
    cad_probs_500 double precision,
    cad_probs_1000 double precision,
    cad_probs_5000 double precision,
    cad_probs_10000 double precision,
    cad_probs_50000 double precision,
    cad_probs_100000 double precision,
    cad_probs_500000 double precision,
    cad_probs_1000000 double precision,
    cad_probs_5000000 double precision,
    cad_probs_10000000 double precision,
    med_double_to_single_step double precision,
    avg_double_to_single_step double precision,
    std_double_to_single_step double precision,
    all_times_nhist_numpeaks double precision,
    all_times_nhist_peak_val double precision,
    all_times_nhist_peak_1_to_2 double precision,
    all_times_nhist_peak_1_to_3 double precision,
    all_times_nhist_peak_2_to_3 double precision,
    all_times_nhist_peak_1_to_4 double precision,
    all_times_nhist_peak_2_to_4 double precision,
    all_times_nhist_peak_3_to_4 double precision,
    all_times_nhist_peak1_bin double precision,
    all_times_nhist_peak2_bin double precision,
    all_times_nhist_peak3_bin double precision,
    all_times_nhist_peak4_bin double precision,
    amplitude double precision,
    flux_percentile_ratio_mid20 double precision,
    flux_percentile_ratio_mid35 double precision,
    flux_percentile_ratio_mid50 double precision,
    flux_percentile_ratio_mid65 double precision,
    flux_percentile_ratio_mid80 double precision,
    max_slope double precision,
    maximum double precision,
    median double precision,
    median_absolute_deviation double precision,
    minimum double precision,
    percent_amplitude double precision,
    percent_beyond_1_std double precision,
    percent_close_to_median double precision,
    percent_difference_flux_percentile double precision,
    period_fast double precision,
    qso_log_chi2_qsonu double precision,
    qso_log_chi2nunull_chi2nu double precision,
    skew double precision,
    std double precision,
    stetson_j double precision,
    stetson_k double precision,
    stetson_mean double precision,
    weighted_average double precision,
    fold2p_slope_10percentile double precision,
    fold2p_slope_90percentile double precision,
    freq1_amplitude1 double precision,
    freq1_amplitude2 double precision,
    freq1_amplitude3 double precision,
    freq1_amplitude4 double precision,
    freq1_freq double precision,
    freq1_lambda double precision,
    freq1_rel_phase2 double precision,
    freq1_rel_phase3 double precision,
    freq1_rel_phase4 double precision,
    freq1_signif double precision,
    freq2_amplitude1 double precision,
    freq2_amplitude2 double precision,
    freq2_amplitude3 double precision,
    freq2_amplitude4 double precision,
    freq2_freq double precision,
    freq2_rel_phase2 double precision,
    freq2_rel_phase3 double precision,
    freq2_rel_phase4 double precision,
    freq3_amplitude1 double precision,
    freq3_amplitude2 double precision,
    freq3_amplitude3 double precision,
    freq3_amplitude4 double precision,
    freq3_freq double precision,
    freq3_rel_phase2 double precision,
    freq3_rel_phase3 double precision,
    freq3_rel_phase4 double precision,
    freq_amplitude_ratio_21 double precision,
    freq_amplitude_ratio_31 double precision,
    freq_frequency_ratio_21 double precision,
    freq_frequency_ratio_31 double precision,
    freq_model_max_delta_mags double precision,
    freq_model_min_delta_mags double precision,
    freq_model_phi1_phi2 double precision,
    freq_n_alias double precision,
    freq_signif_ratio_21 double precision,
    freq_signif_ratio_31 double precision,
    freq_varrat double precision,
    freq_y_offset double precision,
    linear_trend double precision,
    medperc90_2p_p double precision,
    p2p_scatter_2praw double precision,
    p2p_scatter_over_mad double precision,
    p2p_scatter_pfold_over_mad double precision,
    p2p_ssqr_diff_over_var double precision,
    scatter_res_raw double precision,
    bls_period_1 double precision,
    bls_tc_1 double precision,
    signal_to_noise_1 double precision,
    signal_residue_1 double precision,
    signal_detection_eff_1 double precision,
    bls_depth_1 double precision,
    bls_qtran_1 double precision,
    bls_i1_1 double precision,
    bls_i2_1 double precision,
    bls_delta_chi2_1 double precision,
    bls_fraconenight_1 double precision,
    bls_npointsintransit_1 double precision,
    bls_ntransits_1 double precision,
    bls_npointsbeforetransit_1 double precision,
    bls_npointsaftertransit_1 double precision,
    red_noise_1 double precision,
    white_noise_1 double precision,
    signal_to_pink_noise_1 double precision,
    bls_period_2 double precision,
    bls_tc_2 double precision,
    signal_to_noise_2 double precision,
    signal_residue_2 double precision,
    signal_detection_eff_2 double precision,
    bls_depth_2 double precision,
    bls_qtran_2 double precision,
    bls_i1_2 double precision,
    bls_i2_2 double precision,
    bls_delta_chi2_2 double precision,
    bls_fraconenight_2 double precision,
    bls_npointsintransit_2 double precision,
    bls_ntransits_2 double precision,
    bls_npointsbeforetransit_2 double precision,
    bls_npointsaftertransit_2 double precision,
    red_noise_2 double precision,
    white_noise_2 double precision,
    signal_to_pink_noise_2 double precision,
    period_inverse_transit double precision,
    delta_chi2_inverse_transit double precision,
    bls_meanmag double precision,
    alarm double precision,
    chi2_2_dof double precision,
    weighted_mean_mag double precision
);


--
-- Name: load; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE load (
    load_id bigint NOT NULL,
    date timestamp without time zone,
    note text
);


--
-- Name: load_load_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE load_load_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: load_load_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE load_load_id_seq OWNED BY load.load_id;


--
-- Name: predicted_types; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types (
    name text,
    type text,
    confidence double precision,
    run_id uuid
);


--
-- Name: predicted_types50; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types50 (
    name text,
    type text
);


--
-- Name: predicted_types_1; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_1 (
    name text,
    type text
);


--
-- Name: predicted_types_100; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_100 (
    name text,
    type text
);


--
-- Name: predicted_types_17; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_17 (
    name text,
    type text
);


--
-- Name: predicted_types_19; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_19 (
    name text,
    type text
);


--
-- Name: predicted_types_2; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_2 (
    name text,
    type text
);


--
-- Name: predicted_types_20; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_20 (
    name text,
    type text
);


--
-- Name: predicted_types_200; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_200 (
    name text,
    type text
);


--
-- Name: predicted_types_21; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_21 (
    name text,
    type text
);


--
-- Name: predicted_types_22; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_22 (
    name text,
    type text
);


--
-- Name: predicted_types_23; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_23 (
    name text,
    type text
);


--
-- Name: predicted_types_3; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_3 (
    name text,
    type text
);


--
-- Name: predicted_types_300; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_300 (
    name text,
    type text
);


--
-- Name: predicted_types_37; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_37 (
    name text,
    type text
);


--
-- Name: predicted_types_39; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_39 (
    name text,
    type text
);


--
-- Name: predicted_types_4; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_4 (
    name text,
    type text
);


--
-- Name: predicted_types_40; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_40 (
    name text,
    type text
);


--
-- Name: predicted_types_400; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_400 (
    name text,
    type text
);


--
-- Name: predicted_types_5; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_5 (
    name text,
    type text
);


--
-- Name: predicted_types_500; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_500 (
    name text,
    type text,
    confidence double precision,
    run_id uuid
);


--
-- Name: predicted_types_6; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE predicted_types_6 (
    name text,
    type text
);


--
-- Name: typeindex; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE typeindex (
    periodic_catalog_id character varying(32),
    obj_id character varying(32),
    type character varying(32),
    subtype character varying(32)
);


--
-- Name: prediction_check; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW prediction_check AS
 SELECT predicted_types.name,
    predicted_types.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual,
    predicted_types.run_id
   FROM (predicted_types
     LEFT JOIN typeindex ON ((predicted_types.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), predicted_types.type;


--
-- Name: prediction_check_2; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW prediction_check_2 AS
 SELECT predicted_types_2.name,
    predicted_types_2.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual
   FROM (predicted_types_2
     LEFT JOIN typeindex ON ((predicted_types_2.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), predicted_types_2.type;


--
-- Name: reference_timeseries; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_timeseries (
    periodic_catalog_id character varying(32),
    type character varying(32),
    subtype character varying(32),
    timeseries jsonb,
    n_epochs double precision,
    avg_err double precision,
    med_err double precision,
    std_err double precision,
    total_time double precision,
    avgt double precision,
    cads_std double precision,
    mean double precision,
    cads_avg double precision,
    cads_med double precision,
    cad_probs_1 double precision,
    cad_probs_10 double precision,
    cad_probs_20 double precision,
    cad_probs_30 double precision,
    cad_probs_40 double precision,
    cad_probs_50 double precision,
    cad_probs_100 double precision,
    cad_probs_500 double precision,
    cad_probs_1000 double precision,
    cad_probs_5000 double precision,
    cad_probs_10000 double precision,
    cad_probs_50000 double precision,
    cad_probs_100000 double precision,
    cad_probs_500000 double precision,
    cad_probs_1000000 double precision,
    cad_probs_5000000 double precision,
    cad_probs_10000000 double precision,
    med_double_to_single_step double precision,
    avg_double_to_single_step double precision,
    std_double_to_single_step double precision,
    all_times_nhist_numpeaks double precision,
    all_times_nhist_peak_val double precision,
    all_times_nhist_peak_1_to_2 double precision,
    all_times_nhist_peak_1_to_3 double precision,
    all_times_nhist_peak_2_to_3 double precision,
    all_times_nhist_peak_1_to_4 double precision,
    all_times_nhist_peak_2_to_4 double precision,
    all_times_nhist_peak_3_to_4 double precision,
    all_times_nhist_peak1_bin double precision,
    all_times_nhist_peak2_bin double precision,
    all_times_nhist_peak3_bin double precision,
    all_times_nhist_peak4_bin double precision,
    amplitude double precision,
    flux_percentile_ratio_mid20 double precision,
    flux_percentile_ratio_mid35 double precision,
    flux_percentile_ratio_mid50 double precision,
    flux_percentile_ratio_mid65 double precision,
    flux_percentile_ratio_mid80 double precision,
    max_slope double precision,
    maximum double precision,
    median double precision,
    median_absolute_deviation double precision,
    minimum double precision,
    percent_amplitude double precision,
    percent_beyond_1_std double precision,
    percent_close_to_median double precision,
    percent_difference_flux_percentile double precision,
    period_fast double precision,
    qso_log_chi2_qsonu double precision,
    qso_log_chi2nunull_chi2nu double precision,
    skew double precision,
    std double precision,
    stetson_j double precision,
    stetson_k double precision,
    stetson_mean double precision,
    weighted_average double precision,
    fold2p_slope_10percentile double precision,
    fold2p_slope_90percentile double precision,
    freq1_amplitude1 double precision,
    freq1_amplitude2 double precision,
    freq1_amplitude3 double precision,
    freq1_amplitude4 double precision,
    freq1_freq double precision,
    freq1_lambda double precision,
    freq1_rel_phase2 double precision,
    freq1_rel_phase3 double precision,
    freq1_rel_phase4 double precision,
    freq1_signif double precision,
    freq2_amplitude1 double precision,
    freq2_amplitude2 double precision,
    freq2_amplitude3 double precision,
    freq2_amplitude4 double precision,
    freq2_freq double precision,
    freq2_rel_phase2 double precision,
    freq2_rel_phase3 double precision,
    freq2_rel_phase4 double precision,
    freq3_amplitude1 double precision,
    freq3_amplitude2 double precision,
    freq3_amplitude3 double precision,
    freq3_amplitude4 double precision,
    freq3_freq double precision,
    freq3_rel_phase2 double precision,
    freq3_rel_phase3 double precision,
    freq3_rel_phase4 double precision,
    freq_amplitude_ratio_21 double precision,
    freq_amplitude_ratio_31 double precision,
    freq_frequency_ratio_21 double precision,
    freq_frequency_ratio_31 double precision,
    freq_model_max_delta_mags double precision,
    freq_model_min_delta_mags double precision,
    freq_model_phi1_phi2 double precision,
    freq_n_alias double precision,
    freq_signif_ratio_21 double precision,
    freq_signif_ratio_31 double precision,
    freq_varrat double precision,
    freq_y_offset double precision,
    linear_trend double precision,
    medperc90_2p_p double precision,
    p2p_scatter_2praw double precision,
    p2p_scatter_over_mad double precision,
    p2p_scatter_pfold_over_mad double precision,
    p2p_ssqr_diff_over_var double precision,
    scatter_res_raw double precision,
    bls_period_1 double precision,
    bls_tc_1 double precision,
    signal_to_noise_1 double precision,
    signal_residue_1 double precision,
    signal_detection_eff_1 double precision,
    bls_depth_1 double precision,
    bls_qtran_1 double precision,
    bls_i1_1 double precision,
    bls_i2_1 double precision,
    bls_delta_chi2_1 double precision,
    bls_fraconenight_1 double precision,
    bls_npointsintransit_1 double precision,
    bls_ntransits_1 double precision,
    bls_npointsbeforetransit_1 double precision,
    bls_npointsaftertransit_1 double precision,
    red_noise_1 double precision,
    white_noise_1 double precision,
    signal_to_pink_noise_1 double precision,
    bls_period_2 double precision,
    bls_tc_2 double precision,
    signal_to_noise_2 double precision,
    signal_residue_2 double precision,
    signal_detection_eff_2 double precision,
    bls_depth_2 double precision,
    bls_qtran_2 double precision,
    bls_i1_2 double precision,
    bls_i2_2 double precision,
    bls_delta_chi2_2 double precision,
    bls_fraconenight_2 double precision,
    bls_npointsintransit_2 double precision,
    bls_ntransits_2 double precision,
    bls_npointsbeforetransit_2 double precision,
    bls_npointsaftertransit_2 double precision,
    red_noise_2 double precision,
    white_noise_2 double precision,
    signal_to_pink_noise_2 double precision,
    period_inverse_transit double precision,
    delta_chi2_inverse_transit double precision,
    bls_meanmag double precision,
    alarm double precision,
    chi2_2_dof double precision,
    weighted_mean_mag double precision
);


--
-- Name: second_predictions; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE second_predictions (
    name text,
    type text
);


--
-- Name: result_analysis; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW result_analysis AS
 SELECT second_predictions.name,
    second_predictions.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual
   FROM (second_predictions
     LEFT JOIN typeindex ON ((second_predictions.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), second_predictions.type;


--
-- Name: result_analysis_1; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW result_analysis_1 AS
 SELECT predicted_types.name,
    predicted_types.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual
   FROM (predicted_types
     LEFT JOIN typeindex ON ((predicted_types.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), predicted_types.type;


--
-- Name: result_analysis_2; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW result_analysis_2 AS
 SELECT predicted_types_1.name,
    predicted_types_1.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual
   FROM (predicted_types_1
     LEFT JOIN typeindex ON ((predicted_types_1.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), predicted_types_1.type;


--
-- Name: result_analysis_3; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW result_analysis_3 AS
 SELECT predicted_types_3.name,
    predicted_types_3.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual
   FROM (predicted_types_3
     LEFT JOIN typeindex ON ((predicted_types_3.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), predicted_types_3.type;


--
-- Name: result_analysis_4; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW result_analysis_4 AS
 SELECT predicted_types_4.name,
    predicted_types_4.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual
   FROM (predicted_types_4
     LEFT JOIN typeindex ON ((predicted_types_4.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), predicted_types_4.type;


--
-- Name: result_analysis_5; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW result_analysis_5 AS
 SELECT predicted_types_5.name,
    predicted_types_5.type AS predicted,
    COALESCE(typeindex.type, 'NPer'::character varying) AS actual
   FROM (predicted_types_5
     LEFT JOIN typeindex ON ((predicted_types_5.name = (typeindex.obj_id)::text)))
  ORDER BY COALESCE(typeindex.type, 'NPer'::character varying), predicted_types_5.type;


--
-- Name: scores; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW scores AS
 WITH true_positives AS (
         SELECT prediction_check.run_id,
            count(*) AS count
           FROM prediction_check
          WHERE (((prediction_check.actual)::text ~~* prediction_check.predicted) AND ((prediction_check.actual)::text <> 'NPer'::text))
          GROUP BY prediction_check.run_id
        ), false_positives AS (
         SELECT prediction_check.run_id,
            count(*) AS count
           FROM prediction_check
          WHERE (((prediction_check.actual)::text !~~* prediction_check.predicted) AND ((prediction_check.actual)::text = 'NPer'::text))
          GROUP BY prediction_check.run_id
        ), false_negatives AS (
         SELECT prediction_check.run_id,
            count(*) AS count
           FROM prediction_check
          WHERE (((prediction_check.actual)::text !~~* prediction_check.predicted) AND (prediction_check.predicted = 'NPer'::text))
          GROUP BY prediction_check.run_id
        )
 SELECT true_positives.run_id,
    ((2.0 * (true_positives.count)::numeric) / (((2.0 * (true_positives.count)::numeric) + (false_negatives.count)::numeric) + (false_positives.count)::numeric)) AS f1_score,
    true_positives.count AS tp,
    false_positives.count AS fp,
    false_negatives.count AS fn
   FROM ((true_positives
     JOIN false_negatives USING (run_id))
     JOIN false_positives USING (run_id));


--
-- Name: load load_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY load ALTER COLUMN load_id SET DEFAULT nextval('load_load_id_seq'::regclass);


--
-- Name: load_load_id_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX load_load_id_idx ON load USING btree (load_id);


--
-- Name: reference_timeseries_periodic_catalog_id_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX reference_timeseries_periodic_catalog_id_idx ON reference_timeseries USING btree (periodic_catalog_id);


--
-- Name: typeindex_obj_id_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX typeindex_obj_id_idx ON typeindex USING btree (obj_id);


--
-- Name: typeindex_periodic_catalog_id_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX typeindex_periodic_catalog_id_idx ON typeindex USING btree (periodic_catalog_id);


--
-- Name: typeindex_subtype_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX typeindex_subtype_idx ON typeindex USING btree (subtype);


--
-- Name: typeindex_type_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX typeindex_type_idx ON typeindex USING btree (type);


--
-- PostgreSQL database dump complete
--

