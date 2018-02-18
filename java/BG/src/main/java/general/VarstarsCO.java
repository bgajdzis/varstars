/**
 * Created by gajdzis on 6/7/17.
 */
package general;

import pl.ls.objects.compound.base.monolithic.AbstractMonolithicObject;

import java.util.Map;

public class VarstarsCO extends AbstractMonolithicObject<VarstarFeatureSet> {

    public VarstarsCO(VarstarFeatureSet object) {
        super(object);
    }

    public Double getAmplitude() {
        return origObject.getAmplitude();
    }

    public Double getPercentageAmplitude() {
        return origObject.getPercentAmplitude();
    }

    public Double getFluxPercentilePercentDifference() {
        return origObject.getPercentDifferenceFluxPercentile();
    }

    public Double getFluxPercentileRatio20() {
        return origObject.getFluxPercentileRatioMid20();
    }

    public Double getFluxPercentileRatio35() {
        return origObject.getFluxPercentileRatioMid35();
    }

    public Double getFluxPercentileRatio50() {
        return origObject.getFluxPercentileRatioMid50();
    }

    public Double getFluxPercentileRatio65() {
        return origObject.getFluxPercentileRatioMid65();
    }

    public Double getFluxPercentileRatio80() {
        return origObject.getFluxPercentileRatioMid80();
    }

    public Double getMedianDoubleToSingleStep() {
        return origObject.getMedDoubleToSingleStep();
    }

    public Double getMeanDoubleToSingleStep() {
        return origObject.getAvgDoubleToSingleStep();
    }

    public Double getStdDoubleToSingleStep() {
        return origObject.getStdDoubleToSingleStep();
    }

    public Double getCadsStd() {
        return origObject.getCadsStd();
    }

    public Double getCadsMean() {
        return origObject.getCadsAvg();
    }

    public Double getCadsMedian() {
        return origObject.getCadsMed();
    }

    public Double getErrMean() {
        return origObject.getAvgErr();
    }

    public Double getErrMedian() {
        return origObject.getMedErr();
    }

    public Double getErrStd() {
        return origObject.getStdErr();
    }

    public Double getMaxAbsSlope() {
        return origObject.getMaxSlope();
    }

    public Double getMedianAbsStd() {
        return origObject.getMedianAbsoluteDeviation();
    }

    public Double getMaxObs() {
        return origObject.getMaximum();
    }

    public Double getMinObs() {
        return origObject.getMinimum();
    }

    public Double getPercentCloseToMed() {
        return origObject.getPercentCloseToMedian();
    }

    public Double getObsSkew() {
        return origObject.getSkew();
    }

    //    public Double getObsKurt(){
//    }
    public Double getObsStd() {
        return origObject.getStd();
    }

    public Double getObsMedian() {
        return origObject.getMedian();
    }

    public Double getPercentBeyond1Sigma() {
        return origObject.getPercentBeyond1Std();
    }

    //    public Double getPercentNSigmaAboveMu(Integer N){
//    }
    public Double getErrWeightedAvg() {
        return origObject.getWeightedAverage();
    }

    //    public Double getErrWeightedStd(){
//    }
    public Double getStetsonM() {
        return origObject.getStetsonMean();
    }

    public Double getStetsonJ() {
        return origObject.getStetsonJ();
    }

    public Double getStetsonK() {
        return origObject.getStetsonK();
    }

    public Double getTotalTime() {
        return origObject.getTotalTime();
    }

    public Double getAvgT() {
        return origObject.getAvgt();
    }

    public Double getMean() {
        return origObject.getMean();
    }

    public Double getCadProbs1() {
        return origObject.getCadProbs1();
    }

    public Double getCadProbs10() {
        return origObject.getCadProbs10();
    }

    public Double getCadProbs20() {
        return origObject.getCadProbs20();
    }

    public Double getCadProbs30() {
        return origObject.getCadProbs30();
    }

    public Double getCadProbs40() {
        return origObject.getCadProbs40();
    }

    public Double getCadProbs50() {
        return origObject.getCadProbs50();
    }

    public Double getCadProbs100() {
        return origObject.getCadProbs100();
    }

    public Double getCadProbs500() {
        return origObject.getCadProbs500();
    }

    public Double getCadProbs1000() {
        return origObject.getCadProbs1000();
    }

    public Double getCadProbs5000() {
        return origObject.getCadProbs5000();
    }

    public Double getCadProbs10000() {
        return origObject.getCadProbs10000();
    }

    public Double getCadProbs50000() {
        return origObject.getCadProbs50000();
    }

    public Double getCadProbs100000() {
        return origObject.getCadProbs100000();
    }

    public Double getCadProbs500000() {
        return origObject.getCadProbs500000();
    }

    public Double getCadProbs1000000() {
        return origObject.getCadProbs1000000();
    }

    public Double getCadProbs5000000() {
        return origObject.getCadProbs5000000();
    }

    public Double getCadProbs10000000() {
        return origObject.getCadProbs10000000();
    }

    public Double getAllTimesNHistNumpeaks() {
        return origObject.getAllTimesNhistNumpeaks();
    }

    public Double getAllTimesNHistPeakVal() {
        return origObject.getAllTimesNhistPeakVal();
    }

    public Double getAllTimesNHistPeak1To2() {
        return origObject.getAllTimesNhistPeak1To2();
    }

    public Double getAllTimesNHistPeak1To3() {
        return origObject.getAllTimesNhistPeak1To3();
    }

    public Double getAllTimesNHistPeak2To3() {
        return origObject.getAllTimesNhistPeak2To3();
    }

    public Double getAllTimesNHistPeak1To4() {
        return origObject.getAllTimesNhistPeak1To4();
    }

    public Double getAllTimesNHistPeak2To4() {
        return origObject.getAllTimesNhistPeak2To4();
    }

    public Double getAllTimesNHistPeak3To4() {
        return origObject.getAllTimesNhistPeak3To4();
    }

    public Double getAllTimesNHistPeak1Bin() {
        return origObject.getAllTimesNhistPeak1Bin();
    }

    public Double getAllTimesNHistPeak2Bin() {
        return origObject.getAllTimesNhistPeak2Bin();
    }

    public Double getAllTimesNHistPeak3Bin() {
        return origObject.getAllTimesNhistPeak3Bin();
    }

    public Double getAllTimesNHistPeak4Bin() {
        return origObject.getAllTimesNhistPeak4Bin();
    }

    public Double getPeriodFast() {
        return origObject.getPeriodFast();
    }

    public Double getQsoLogChi2QsoNu() {
        return origObject.getQsoLogChi2Qsonu();
    }

    public Double getQsoLogChi2NuNullChi2Nu() {
        return origObject.getQsoLogChi2nunullChi2nu();
    }

    public Double getFold2pSlope10percentile() {
        return origObject.getFold2pSlope10percentile();
    }

    public Double getFold2pSlope90percentile() {
        return origObject.getFold2pSlope90percentile();
    }

    public Double getFreq1Amplitude1() {
        return origObject.getFreq1Amplitude1();
    }

    public Double getFreq1Amplitude2() {
        return origObject.getFreq1Amplitude2();
    }

    public Double getFreq1Amplitude3() {
        return origObject.getFreq1Amplitude3();
    }

    public Double getFreq1Amplitude4() {
        return origObject.getFreq1Amplitude4();
    }

    public Double getFreq1Freq() {
        return origObject.getFreq1Freq();
    }

    public Double getFreq1Lambda() {
        return origObject.getFreq1Lambda();
    }

    public Double getFreq1RelPhase2() {
        return origObject.getFreq1RelPhase2();
    }

    public Double getFreq1RelPhase3() {
        return origObject.getFreq1RelPhase3();
    }

    public Double getFreq1RelPhase4() {
        return origObject.getFreq1RelPhase4();
    }

    public Double getFreq1Signif() {
        return origObject.getFreq1Signif();
    }

    public Double getFreq2Amplitude1() {
        return origObject.getFreq2Amplitude1();
    }

    public Double getFreq2Amplitude2() {
        return origObject.getFreq2Amplitude2();
    }

    public Double getFreq2Amplitude3() {
        return origObject.getFreq2Amplitude3();
    }

    public Double getFreq2Amplitude4() {
        return origObject.getFreq2Amplitude4();
    }

    public Double getFreq2Freq() {
        return origObject.getFreq2Freq();
    }

    public Double getFreq2RelPhase2() {
        return origObject.getFreq2RelPhase2();
    }

    public Double getFreq2RelPhase3() {
        return origObject.getFreq2RelPhase3();
    }

    public Double getFreq2RelPhase4() {
        return origObject.getFreq2RelPhase4();
    }

    public Double getFreq3Amplitude1() {
        return origObject.getFreq3Amplitude1();
    }

    public Double getFreq3Amplitude2() {
        return origObject.getFreq3Amplitude2();
    }

    public Double getFreq3Amplitude3() {
        return origObject.getFreq3Amplitude3();
    }

    public Double getFreq3Amplitude4() {
        return origObject.getFreq3Amplitude4();
    }

    public Double getFreq3Freq() {
        return origObject.getFreq3Freq();
    }

    public Double getFreq3RelPhase2() {
        return origObject.getFreq3RelPhase2();
    }

    public Double getFreq3RelPhase3() {
        return origObject.getFreq3RelPhase3();
    }

    public Double getFreq3RelPhase4() {
        return origObject.getFreq3RelPhase4();
    }

    public Double getFreqAmplitudeRatio21() {
        return origObject.getFreqAmplitudeRatio21();
    }

    public Double getFreqAmplitudeRatio31() {
        return origObject.getFreqAmplitudeRatio31();
    }

    public Double getFreqFrequencyRatio21() {
        return origObject.getFreqFrequencyRatio21();
    }

    public Double getFreqFrequencyRatio31() {
        return origObject.getFreqFrequencyRatio31();
    }

    public Double getFreqModelMaxDeltaMags() {
        return origObject.getFreqModelMaxDeltaMags();
    }

    public Double getFreqModelMinDeltaMags() {
        return origObject.getFreqModelMinDeltaMags();
    }

    public Double getFreqModelPhi1Phi2() {
        return origObject.getFreqModelPhi1Phi2();
    }

    public Double getFreqNAlias() {
        return origObject.getFreqNAlias();
    }

    public Double getFreqSignifRatio21() {
        return origObject.getFreqSignifRatio21();
    }

    public Double getFreqSignifRatio31() {
        return origObject.getFreqSignifRatio31();
    }

    public Double getFreqVarrat() {
        return origObject.getFreqVarrat();
    }

    public Double getFreqYOffset() {
        return origObject.getFreqYOffset();
    }

    public Double getLinearTrend() {
        return origObject.getLinearTrend();
    }

    public Double getMedperc902pP() {
        return origObject.getMedperc902pP();
    }

    public Double getP2pScatter2praw() {
        return origObject.getP2pScatter2praw();
    }

    public Double getP2pScatterOverMad() {
        return origObject.getP2pScatterOverMad();
    }

    public Double getP2pScatterPfoldOverMad() {
        return origObject.getP2pScatterPfoldOverMad();
    }

    public Double getP2pSsqrDiffOverVar() {
        return origObject.getP2pSsqrDiffOverVar();
    }

    public Double getScatterResRaw() {
        return origObject.getScatterResRaw();
    }

    public Double getBlsPeriod1() {
        return origObject.getBlsPeriod1();
    }

    public Double getBlsTc1() {
        return origObject.getBlsTc1();
    }

    public Double getBlsSignalToNoise1() {
        return origObject.getBlsSignalToNoise1();
    }

    public Double getBlsSignalResidue1() {
        return origObject.getBlsSignalResidue1();
    }

    public Double getBlsSignalDetectionEfficiency1() {
        return origObject.getBlsSignalDetectionEfficiency1();
    }

    public Double getBlsDepth1() {
        return origObject.getBlsDepth1();
    }

    public Double getBlsQTransit1() {
        return origObject.getBlsQTransit1();
    }

    public Double getBlsI11() {
        return origObject.getBlsI11();
    }

    public Double getBlsI21() {
        return origObject.getBlsI21();
    }

    public Double getBlsDeltaChi21() {
        return origObject.getBlsDeltaChi21();
    }

    public Double getBlsFracOneNight1() {
        return origObject.getBlsFracOneNight1();
    }

    public Double getBlsNPointsInTransit1() {
        return origObject.getBlsNPointsInTransit1();
    }

    public Double getBlsNTransits1() {
        return origObject.getBlsNTransits1();
    }

    public Double getBlsNPointsBeforeTransit1() {
        return origObject.getBlsNPointsBeforeTransit1();
    }

    public Double getBlsNPointsAfterTransit1() {
        return origObject.getBlsNPointsAfterTransit1();
    }

    public Double getBlsRedNoise1() {
        return origObject.getBlsRedNoise1();
    }

    public Double getBlsWhiteNoise1() {
        return origObject.getBlsWhiteNoise1();
    }

    public Double getBlsSignalToPinkNoise1() {
        return origObject.getBlsSignalToPinkNoise1();
    }

    public Double getBlsPeriod2() {
        return origObject.getBlsPeriod2();
    }

    public Double getBlsTc2() {
        return origObject.getBlsTc2();
    }

    public Double getBlsSignalToNoise2() {
        return origObject.getBlsSignalToNoise2();
    }

    public Double getBlsSignalResidue2() {
        return origObject.getBlsSignalResidue2();
    }

    public Double getBlsSignalDetectionEfficiency2() {
        return origObject.getBlsSignalDetectionEfficiency2();
    }

    public Double getBlsDepth2() {
        return origObject.getBlsDepth2();
    }

    public Double getBlsQTransit2() {
        return origObject.getBlsQTransit2();
    }

    public Double getBlsI12() {
        return origObject.getBlsI12();
    }

    public Double getBlsI22() {
        return origObject.getBlsI22();
    }

    public Double getBlsDeltaChi22() {
        return origObject.getBlsDeltaChi22();
    }

    public Double getBlsFracOneNight2() {
        return origObject.getBlsFracOneNight2();
    }

    public Double getBlsNPointsInTransit2() {
        return origObject.getBlsNPointsInTransit2();
    }

    public Double getBlsNTransits2() {
        return origObject.getBlsNTransits2();
    }

    public Double getBlsNPointsBeforeTransit2() {
        return origObject.getBlsNPointsBeforeTransit2();
    }

    public Double getBlsNPointsAfterTransit2() {
        return origObject.getBlsNPointsAfterTransit2();
    }

    public Double getBlsRedNoise2() {
        return origObject.getBlsRedNoise2();
    }

    public Double getBlsWhiteNoise2() {
        return origObject.getBlsWhiteNoise2();
    }

    public Double getBlsSignalToPinkNoise2() {
        return origObject.getBlsSignalToPinkNoise2();
    }

    public Double getPeriodInverseTransit() {
        return origObject.getPeriodInverseTransit();
    }

    public Double getDeltaChi2InverseTransit() {
        return origObject.getDeltaChi2InverseTransit();
    }

    public Double getBlsMeanMag() {
        return origObject.getBlsMeanMag();
    }

    public Double getAlarm() {
        return origObject.getAlarm();
    }

    public Double getChi22Dof() {
        return origObject.getChi22Dof();
    }

    public Double getWeightedMeanMag() {
        return origObject.getWeightedMeanMag();
    }

    public Double getNEpochs() {
        return origObject.getNEpochs();
    }

    public Double getFc2Freq() { return origObject.getFc2Freq();}

    public Double getFc2Detrend() { return origObject.getFc2Detrend();}

    public Double getFc2Min() { return origObject.getFc2Min();}

    public Double getFc2Sin1() { return origObject.getFc2Sin1();}

    public Double getFc2Sin2() { return origObject.getFc2Sin2();}

    public Double getCkpIp() { return origObject.getCkpIp();}

    public Double getCkpCkp1() { return origObject.getCkpCkp1();}

    public Double getCkpCkp2() { return origObject.getCkpCkp2();}

    public Double getCkpPeriod1() { return origObject.getCkpPeriod1();}

    public Double getCkpPeriod2() { return origObject.getCkpPeriod2();}

    public Map<Double, Double> getTimeseries() {
        return origObject.getTimeseriesObs();
    }
}
