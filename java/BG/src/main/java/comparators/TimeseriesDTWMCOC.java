package comparators;

import com.fastdtw.dtw.FastDTW;
import com.fastdtw.dtw.TimeWarpInfo;
import com.fastdtw.timeseries.TimeSeries;
import com.fastdtw.timeseries.TimeSeriesBase;
import com.fastdtw.util.Distances;
import general.*;
import pl.ls.comparators.ComparatorEnums;
import pl.ls.comparators.base.monolithic.AbstractMonolithicCOComparator;
import pl.ls.exceptions.ComparatorException;
import pl.ls.objects.compound.base.monolithic.IMonolithicReferenceObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.min;

public class TimeseriesDTWMCOC extends AbstractMonolithicCOComparator<VarstarFeatureSet> {


    public TimeseriesDTWMCOC(String name) throws ComparatorException {
        super(name);
    }

    @Override
    public Integer getUniqueId() {
        return Constants.TimeseriesDTW;
    }

    @Override
    public ComparatorEnums.ComparatorUnitCost getUnitCost() {
        return ComparatorEnums.ComparatorUnitCost.MEDIUM;
    }

    @Override
    protected void setP() {
        this.p = 0.8;
    }

    @Override
    protected double getMembershipValue(IMonolithicReferenceObject ref) throws ComparatorException {
        Map<Double, Double> inputValue;
        Map<Double, Double> referenceValue;
        try {
            if (((VarstarsRef) ref).getReferenceName() != "NPer") {
                this.p = Constants.perP;
            }
        } catch (Exception e) {
            //log.error(e, e);
            return 0;
        }
        try {
            inputValue = ((VarstarsCO) getInputObject()).getTimeseries();
            Double peri = ((VarstarsCO) getInputObject()).getPeriodFast();
            referenceValue = ((VarstarsRef) ref).getTimeseries();
            Double perr = ((VarstarsRef) ref).getPeriodFast();
            int len = min(referenceValue.size(), inputValue.size());
            TimeSeriesBase.Builder tsb1 = TimeSeriesBase.builder();
            TimeSeriesBase.Builder tsb2 = TimeSeriesBase.builder();
            List<Map.Entry<Double, Double>> pointsi = new ArrayList<Map.Entry<Double, Double>>(inputValue.entrySet());
            List<Map.Entry<Double, Double>> pointsr = new ArrayList<Map.Entry<Double, Double>>(referenceValue.entrySet());
            pointsi = Utils.listSample(pointsi, len);
            pointsr = Utils.listSample(pointsr, len);
            pointsi = Utils.listNormalize(pointsi);
            pointsr = Utils.listNormalize(pointsr);
            for (Map.Entry<Double, Double> entry : pointsi) {
                tsb1.add(entry.getKey() % peri, entry.getValue());
            }
            TimeSeries ts1 = tsb1.build();
            for (Map.Entry<Double, Double> entry : pointsr) {
                tsb2.add(entry.getKey() % perr, entry.getValue());
            }
            TimeSeries ts2 = tsb2.build();
            TimeWarpInfo tw = FastDTW.compare(ts1, ts2, 10, Distances.EUCLIDEAN_DISTANCE);
            Double dist = tw.getDistance();
            Double sim = 1 - dist / len;
            //System.out.println(len);
            //System.out.println(tw.toString());
            if (sim > 1 || sim < 0) {
                System.out.println("źle");
            }
            return sim;
        } catch (Exception e) {
            //log.error(e,e);
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    protected boolean isExceptionSatisfied(IMonolithicReferenceObject ref) {
        return false;
    }
}
