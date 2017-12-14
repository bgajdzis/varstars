package general;

import comparators.*;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Constants {

    public static final Double nonPerP = 0.1;
    public static final Double perP = 0.855555;
    public static final Integer Amplitude = 1;
    public static final Integer PercentageAmplitude = 2;
    public static final Integer FluxPercentilePercentDifference = 3;
    public static final Integer FluxPercentileRatio20 = 4;
    public static final Integer FluxPercentileRatio35 = 5;
    public static final Integer FluxPercentileRatio50 = 6;
    public static final Integer FluxPercentileRatio65 = 7;
    public static final Integer FluxPercentileRatio80 = 8;
    public static final Integer MedianDoubleToSingleStep = 41;
    public static final Integer MeanDoubleToSingleStep = 42;
    public static final Integer StdDoubleToSingleStep = 9;
    public static final Integer CadsMedian = 10;
    public static final Integer CadsMean = 11;
    public static final Integer CadsStd = 12;
    public static final Integer ErrMedian = 13;
    public static final Integer ErrMean = 14;
    public static final Integer ErrStd = 15;
    public static final Integer MaxAbsSlope = 21;
    public static final Integer MedianAbsStd = 22;
    public static final Integer MaxObs = 23;
    public static final Integer MinObs = 24;
    public static final Integer PercentCloseToMed = 25;
    public static final Integer ObsSkew = 26;
    public static final Integer ObsStd = 28;
    public static final Integer ObsMedian = 29;
    public static final Integer PercentBeyond1Sigma = 30;
    public static final Integer ErrWeightedAvg = 36;
    public static final Integer StetsonM = 38;
    public static final Integer StetsonK = 39;
    public static final Integer StetsonJ = 40;
    public static final Integer TotalTime = 42;
    public static final Integer AvgT = 43;
    public static final Integer Mean = 44;
    public static final Integer CadProbs1 = 45;
    public static final Integer CadProbs10 = 46;
    public static final Integer CadProbs20 = 47;
    public static final Integer CadProbs30 = 48;
    public static final Integer CadProbs40 = 49;
    public static final Integer CadProbs50 = 50;
    public static final Integer CadProbs100 = 51;
    public static final Integer CadProbs500 = 52;
    public static final Integer CadProbs1000 = 53;
    public static final Integer CadProbs5000 = 54;
    public static final Integer CadProbs10000 = 55;
    public static final Integer CadProbs50000 = 56;
    public static final Integer CadProbs100000 = 57;
    public static final Integer CadProbs500000 = 58;
    public static final Integer CadProbs1000000 = 59;
    public static final Integer CadProbs5000000 = 60;
    public static final Integer CadProbs10000000 = 61;
    public static final Integer AllTimesNHistNumpeaks = 62;
    public static final Integer AllTimesNHistPeakVal = 63;
    public static final Integer AllTimesNHistPeak1To2 = 64;
    public static final Integer AllTimesNHistPeak1To3 = 65;
    public static final Integer AllTimesNHistPeak2To3 = 66;
    public static final Integer AllTimesNHistPeak1To4 = 67;
    public static final Integer AllTimesNHistPeak2To4 = 68;
    public static final Integer AllTimesNHistPeak3To4 = 69;
    public static final Integer AllTimesNHistPeak1Bin = 70;
    public static final Integer AllTimesNHistPeak2Bin = 71;
    public static final Integer AllTimesNHistPeak3Bin = 72;
    public static final Integer AllTimesNHistPeak4Bin = 73;
    public static final Integer PeriodFast = 74;
    public static final Integer QsoLogChi2QsoNu = 75;
    public static final Integer QsoLogChi2NuNullChi2Nu = 76;
    public static final Integer Fold2pSlope10percentile = 77;
    public static final Integer Fold2pSlope90percentile = 78;
    public static final Integer Freq1Amplitude1 = 79;
    public static final Integer Freq1Amplitude2 = 80;
    public static final Integer Freq1Amplitude3 = 81;
    public static final Integer Freq1Amplitude4 = 82;
    public static final Integer Freq1Freq = 83;
    public static final Integer Freq1Lambda = 84;
    public static final Integer Freq1RelPhase2 = 85;
    public static final Integer Freq1RelPhase3 = 86;
    public static final Integer Freq1RelPhase4 = 87;
    public static final Integer Freq1Signif = 88;
    public static final Integer Freq2Amplitude1 = 89;
    public static final Integer Freq2Amplitude2 = 90;
    public static final Integer Freq2Amplitude3 = 91;
    public static final Integer Freq2Amplitude4 = 92;
    public static final Integer Freq2Freq = 93;
    public static final Integer Freq2RelPhase2 = 94;
    public static final Integer Freq2RelPhase3 = 95;
    public static final Integer Freq2RelPhase4 = 96;
    public static final Integer Freq3Amplitude1 = 97;
    public static final Integer Freq3Amplitude2 = 98;
    public static final Integer Freq3Amplitude3 = 99;
    public static final Integer Freq3Amplitude4 = 100;
    public static final Integer Freq3Freq = 101;
    public static final Integer Freq3RelPhase2 = 102;
    public static final Integer Freq3RelPhase3 = 103;
    public static final Integer Freq3RelPhase4 = 104;
    public static final Integer FreqAmplitudeRatio21 = 105;
    public static final Integer FreqAmplitudeRatio31 = 106;
    public static final Integer FreqFrequencyRatio21 = 107;
    public static final Integer FreqFrequencyRatio31 = 108;
    public static final Integer FreqModelMaxDeltaMags = 109;
    public static final Integer FreqModelMinDeltaMags = 110;
    public static final Integer FreqModelPhi1Phi2 = 111;
    public static final Integer FreqNAlias = 112;
    public static final Integer FreqSignifRatio21 = 113;
    public static final Integer FreqSignifRatio31 = 114;
    public static final Integer FreqVarrat = 115;
    public static final Integer FreqYOffset = 116;
    public static final Integer LinearTrend = 117;
    public static final Integer Medperc902pP = 118;
    public static final Integer P2pScatter2praw = 119;
    public static final Integer P2pScatterOverMad = 120;
    public static final Integer P2pScatterPfoldOverMad = 121;
    public static final Integer P2pSsqrDiffOverVar = 122;
    public static final Integer ScatterResRaw = 123;
    public static final Integer TimeseriesDTW = 124;
    public static final Integer BlsPeriod1 = 125;
    public static final Integer BlsTc1 = 126;
    public static final Integer BlsSignalToNoise1 = 127;
    public static final Integer BlsSignalResidue1 = 128;
    public static final Integer BlsSignalDetectionEfficiency1 = 129;
    public static final Integer BlsDepth1 = 130;
    public static final Integer BlsQTransit1 = 131;
    public static final Integer BlsI11 = 132;
    public static final Integer BlsI21 = 133;
    public static final Integer BlsDeltaChi21 = 134;
    public static final Integer BlsFracOneNight1 = 135;
    public static final Integer BlsNPointsInTransit1 = 136;
    public static final Integer BlsNTransits1 = 137;
    public static final Integer BlsNPointsBeforeTransit1 = 138;
    public static final Integer BlsNPointsAfterTransit1 = 139;
    public static final Integer BlsRedNoise1 = 140;
    public static final Integer BlsWhiteNoise1 = 141;
    public static final Integer BlsSignalToPinkNoise1 = 142;
    public static final Integer BlsPeriod2 = 143;
    public static final Integer BlsTc2 = 144;
    public static final Integer BlsSignalToNoise2 = 145;
    public static final Integer BlsSignalResidue2 = 146;
    public static final Integer BlsSignalDetectionEfficiency2 = 147;
    public static final Integer BlsDepth2 = 148;
    public static final Integer BlsQTransit2 = 149;
    public static final Integer BlsI12 = 150;
    public static final Integer BlsI22 = 151;
    public static final Integer BlsDeltaChi22 = 152;
    public static final Integer BlsFracOneNight2 = 153;
    public static final Integer BlsNPointsInTransit2 = 154;
    public static final Integer BlsNTransits2 = 155;
    public static final Integer BlsNPointsBeforeTransit2 = 156;
    public static final Integer BlsNPointsAfterTransit2 = 157;
    public static final Integer BlsRedNoise2 = 158;
    public static final Integer BlsWhiteNoise2 = 159;
    public static final Integer BlsSignalToPinkNoise2 = 160;
    public static final Integer PeriodInverseTransit = 161;
    public static final Integer DeltaChi2InverseTransit = 162;
    public static final Integer BlsMeanMag = 163;
    public static final Integer Alarm = 164;
    public static final Integer Chi22Dof = 165;
    public static final Integer WeightedMeanMag = 166;
    public static final Integer NEpochs = 167;

    public static final String SQLresultInsertHeader = "INSERT INTO predicted_types (name,type,confidence,run_id) VALUES";
    public static final String SQLreferenceSelect = "SELECT * FROM reference_timeseries";
    public static final String SQLinputGranuleSelect = "SELECT * FROM input_timeseries";
    public static final String SQLf1Getter = "SELECT * FROM scores WHERE run_id = ";

    public static final Map<Class,Integer> allDblComparators = Stream.of(
            new SimpleEntry<Class,Integer>(AmplitudeMCOC.class,0),
            new SimpleEntry<Class,Integer>(PercentageAmplitudeMCOC.class,2),
            new SimpleEntry<Class,Integer>(FluxPercentilePercentDifferenceMCOC.class,2),
            new SimpleEntry<Class,Integer>(FluxPercentileRatio20MCOC.class,1),
            new SimpleEntry<Class,Integer>(FluxPercentileRatio35MCOC.class,1),
            new SimpleEntry<Class,Integer>(FluxPercentileRatio50MCOC.class,2),
            new SimpleEntry<Class,Integer>(FluxPercentileRatio65MCOC.class,1),
            new SimpleEntry<Class,Integer>(FluxPercentileRatio80MCOC.class,1),
            new SimpleEntry<Class,Integer>(MedianDoubleToSingleStepMCOC.class,0),
            new SimpleEntry<Class,Integer>(MeanDoubleToSingleStepMCOC.class,0),
            new SimpleEntry<Class,Integer>(StdDoubleToSingleStepMCOC.class,0),
            new SimpleEntry<Class,Integer>(CadsMedianMCOC.class,0),
            new SimpleEntry<Class,Integer>(CadsMeanMCOC.class,0),
            new SimpleEntry<Class,Integer>(CadsStdMCOC.class,0),
            new SimpleEntry<Class,Integer>(ErrMedianMCOC.class,1),
            new SimpleEntry<Class,Integer>(ErrMeanMCOC.class,1),
            new SimpleEntry<Class,Integer>(ErrStdMCOC.class,1),
            new SimpleEntry<Class,Integer>(MaxAbsSlopeMCOC.class,1),
            new SimpleEntry<Class,Integer>(MedianAbsStdMCOC.class,1),
            new SimpleEntry<Class,Integer>(MaxObsMCOC.class,1),
            new SimpleEntry<Class,Integer>(MinObsMCOC.class,1),
            new SimpleEntry<Class,Integer>(PercentCloseToMedMCOC.class,2),
            new SimpleEntry<Class,Integer>(ObsSkewMCOC.class,2),
            new SimpleEntry<Class,Integer>(ObsStdMCOC.class,1),
            new SimpleEntry<Class,Integer>(ObsMedianMCOC.class,1),
            new SimpleEntry<Class,Integer>(PercentBeyond1SigmaMCOC.class,2),
            new SimpleEntry<Class,Integer>(ErrWeightedAvgMCOC.class,1),
            new SimpleEntry<Class,Integer>(StetsonMMCOC.class,1),
            new SimpleEntry<Class,Integer>(StetsonKMCOC.class,2),
            new SimpleEntry<Class,Integer>(StetsonJMCOC.class,2),
            new SimpleEntry<Class,Integer>(TotalTimeMCOC.class,0),
            new SimpleEntry<Class,Integer>(AvgTMCOC.class,0),
            new SimpleEntry<Class,Integer>(MeanMCOC.class,1),
            new SimpleEntry<Class,Integer>(CadProbs1MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs10MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs20MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs30MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs40MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs50MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs100MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs500MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs1000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs5000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs10000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs50000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs100000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs500000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs1000000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs5000000MCOC.class,0),
            new SimpleEntry<Class,Integer>(CadProbs10000000MCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistNumpeaksMCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeakValMCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak1To2MCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak1To3MCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak2To3MCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak1To4MCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak2To4MCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak3To4MCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak1BinMCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak2BinMCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak3BinMCOC.class,0),
            new SimpleEntry<Class,Integer>(AllTimesNHistPeak4BinMCOC.class,0),
            new SimpleEntry<Class,Integer>(PeriodFastMCOC.class,2),
            new SimpleEntry<Class,Integer>(QsoLogChi2QsoNuMCOC.class,2),
            new SimpleEntry<Class,Integer>(QsoLogChi2NuNullChi2NuMCOC.class,1),
            new SimpleEntry<Class,Integer>(Fold2pSlope10percentileMCOC.class,1),
            new SimpleEntry<Class,Integer>(Fold2pSlope90percentileMCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1Amplitude1MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1Amplitude2MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1Amplitude3MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1Amplitude4MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1FreqMCOC.class,2),
            new SimpleEntry<Class,Integer>(Freq1LambdaMCOC.class,2),
            new SimpleEntry<Class,Integer>(Freq1RelPhase2MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1RelPhase3MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1RelPhase4MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq1SignifMCOC.class,2),
            new SimpleEntry<Class,Integer>(Freq2Amplitude1MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq2Amplitude2MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq2Amplitude3MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq2Amplitude4MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq2FreqMCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq2RelPhase2MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq2RelPhase3MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq2RelPhase4MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3Amplitude1MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3Amplitude2MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3Amplitude3MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3Amplitude4MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3FreqMCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3RelPhase2MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3RelPhase3MCOC.class,1),
            new SimpleEntry<Class,Integer>(Freq3RelPhase4MCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqAmplitudeRatio21MCOC.class,2),
            new SimpleEntry<Class,Integer>(FreqAmplitudeRatio31MCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqFrequencyRatio21MCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqFrequencyRatio31MCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqModelMaxDeltaMagsMCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqModelMinDeltaMagsMCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqModelPhi1Phi2MCOC.class,2),
            new SimpleEntry<Class,Integer>(FreqNAliasMCOC.class,2),
            new SimpleEntry<Class,Integer>(FreqSignifRatio21MCOC.class,2),
            new SimpleEntry<Class,Integer>(FreqSignifRatio31MCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqVarratMCOC.class,1),
            new SimpleEntry<Class,Integer>(FreqYOffsetMCOC.class,1),
            new SimpleEntry<Class,Integer>(LinearTrendMCOC.class,2),
            new SimpleEntry<Class,Integer>(Medperc902pPMCOC.class,2),
            new SimpleEntry<Class,Integer>(P2pScatter2prawMCOC.class,1),
            new SimpleEntry<Class,Integer>(P2pScatterOverMadMCOC.class,1),
            new SimpleEntry<Class,Integer>(P2pScatterPfoldOverMadMCOC.class,1),
            new SimpleEntry<Class,Integer>(P2pSsqrDiffOverVarMCOC.class,1),
            new SimpleEntry<Class,Integer>(ScatterResRawMCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsPeriod1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsTc1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsSignalToNoise1MCOC.class,2),
            new SimpleEntry<Class,Integer>(BlsSignalResidue1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsSignalDetectionEfficiency1MCOC.class,2),
            new SimpleEntry<Class,Integer>(BlsDepth1MCOC.class,2),
            new SimpleEntry<Class,Integer>(BlsQTransit1MCOC.class,2),
            new SimpleEntry<Class,Integer>(BlsI11MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsI21MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsDeltaChi21MCOC.class,2),
            new SimpleEntry<Class,Integer>(BlsFracOneNight1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNPointsInTransit1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNTransits1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNPointsBeforeTransit1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNPointsAfterTransit1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsRedNoise1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsWhiteNoise1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsSignalToPinkNoise1MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsPeriod2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsTc2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsSignalToNoise2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsSignalResidue2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsSignalDetectionEfficiency2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsDepth2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsQTransit2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsI12MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsI22MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsDeltaChi22MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsFracOneNight2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNPointsInTransit2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNTransits2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNPointsBeforeTransit2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsNPointsAfterTransit2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsRedNoise2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsWhiteNoise2MCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsSignalToPinkNoise2MCOC.class,1),
            new SimpleEntry<Class,Integer>(PeriodInverseTransitMCOC.class,2),
            new SimpleEntry<Class,Integer>(DeltaChi2InverseTransitMCOC.class,1),
            new SimpleEntry<Class,Integer>(BlsMeanMagMCOC.class,1),
            new SimpleEntry<Class,Integer>(AlarmMCOC.class,2),
            new SimpleEntry<Class,Integer>(Chi22DofMCOC.class,2),
            new SimpleEntry<Class,Integer>(WeightedMeanMagMCOC.class,1),
            new SimpleEntry<Class,Integer>(NEpochsMCOC.class,0))
            .collect(Collectors.toMap(SimpleEntry::getKey,SimpleEntry::getValue));
}
