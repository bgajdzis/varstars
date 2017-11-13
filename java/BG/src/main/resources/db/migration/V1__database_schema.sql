CREATE TABLE input_timeseries (
    obj_id character varying(32),
    timeseries jsonb,
    amplitude double precision,
    percent_amplitude double precision,
    percent_difference_flux_percentile double precision,
    flux_percentile_ratio_mid20 double precision,
    flux_percentile_ratio_mid35 double precision,
    flux_percentile_ratio_mid50 double precision,
    flux_percentile_ratio_mid65 double precision,
    flux_percentile_ratio_mid80 double precision,
    med_double_to_single_step double precision,
    avg_double_to_single_step double precision,
    std_double_to_single_step double precision,
    cads_med double precision,
    cads_avg double precision,
    cads_std double precision,
    med_err double precision,
    avg_err double precision,
    std_err double precision,
    max_slope double precision,
    median_absolute_deviation double precision,
    maximum double precision,
    minimum double precision,
    percent_close_to_median double precision,
    skew double precision,
    std double precision,
    median double precision,
    percent_beyond_1_std double precision,
    weighted_average double precision,
    stetson_m double precision,
    stetson_j double precision,
    stetson_k double precision,
    load_id bigint
);

CREATE TABLE load (
    load_id bigint NOT NULL,
    date timestamp without time zone,
    note text
);

CREATE SEQUENCE load_load_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE load_load_id_seq OWNED BY load.load_id;

CREATE TABLE predicted_types (
    name text,
    type text
);

CREATE TABLE reference_timeseries (
    periodic_catalog_id character varying(32),
    type text,
    timeseries jsonb,
    amplitude double precision,
    percent_amplitude double precision,
    percent_difference_flux_percentile double precision,
    flux_percentile_ratio_mid20 double precision,
    flux_percentile_ratio_mid35 double precision,
    flux_percentile_ratio_mid50 double precision,
    flux_percentile_ratio_mid65 double precision,
    flux_percentile_ratio_mid80 double precision,
    med_double_to_single_step double precision,
    avg_double_to_single_step double precision,
    std_double_to_single_step double precision,
    cads_med double precision,
    cads_avg double precision,
    cads_std double precision,
    med_err double precision,
    avg_err double precision,
    std_err double precision,
    max_slope double precision,
    median_absolute_deviation double precision,
    maximum double precision,
    minimum double precision,
    percent_close_to_median double precision,
    skew double precision,
    std double precision,
    median double precision,
    percent_beyond_1_std double precision,
    weighted_average double precision,
    stetson_m double precision,
    stetson_j double precision,
    stetson_k double precision
);

CREATE TABLE typeindex (
    periodic_catalog_id character varying (32),
    obj_id character varying(32),
    type character varying(32),
    subtype character varying(32)
);

ALTER TABLE ONLY load ALTER COLUMN load_id SET DEFAULT nextval('load_load_id_seq'::regclass);

CREATE INDEX ON reference_timeseries (periodic_catalog_id);

CREATE INDEX ON input_timeseries (obj_id);

CREATE INDEX ON input_timeseries (load_id);

CREATE INDEX ON load (load_id)
