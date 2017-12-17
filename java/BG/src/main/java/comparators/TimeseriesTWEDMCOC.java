package comparators;

import general.*;
import pl.ls.comparators.ComparatorEnums;
import pl.ls.comparators.base.monolithic.AbstractMonolithicCOComparator;
import pl.ls.exceptions.ComparatorException;
import pl.ls.objects.compound.base.monolithic.IMonolithicReferenceObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TimeseriesTWEDMCOC extends AbstractMonolithicCOComparator<VarstarFeatureSet> {


    public TimeseriesTWEDMCOC(String name) throws ComparatorException {
        super(name);
    }

    @Override
    public Integer getUniqueId() {
        return Constants.TimeseriesTWED;
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
            if (!(((VarstarsRef) ref).getReferenceName().equals("NPer"))) {
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
            List<Map.Entry<Double, Double>> pointsi = new ArrayList<Map.Entry<Double, Double>>(inputValue.entrySet());
            List<Map.Entry<Double, Double>> pointsr = new ArrayList<Map.Entry<Double, Double>>(referenceValue.entrySet());
            pointsi = Utils.listNormalize(pointsi);
            pointsr = Utils.listNormalize(pointsr);
            Twed twed = new Twed(1, pointsi, pointsr, 0.2, 0.05, 2, 10.0*(pointsi.size()+pointsr.size()));
            Double dist = twed.getDistance();
            Double sim = Math.exp(dist/twed.getSigma());
            System.out.println("TWED: dist-"+dist+" sim-"+sim);
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

    private class Twed {
        private int dim; //left here just in case if I want to modify the program to use multidimensional values for the observations
        private Double[] tsa;
        private Double[] tsb;
        private Double[] ta;
        private Double[] tb;
        private Double nu;
        private Double lambda;
        private Integer degree;
        private Double[][] D;
        private Double sigma;

        public Twed(Integer dim, List<Map.Entry<Double, Double>> pointsA, List<Map.Entry<Double, Double>> pointsB, Double nu, Double lambda, Integer degree, Double sigma) {
            this.dim = dim;
            this.nu = nu;
            this.lambda = lambda;
            this.degree = degree;
            this.D = null;
            this.ta = new Double[pointsA.size()];
            this.tsa = new Double[pointsA.size()];
            this.tb = new Double[pointsB.size()];
            this.tsb = new Double[pointsB.size()];
            this.sigma = sigma;
            for (int i = 0; i < pointsA.size(); i++) {
                ta[i] = pointsA.get(i).getValue();
                tsa[i] = pointsA.get(i).getKey();

            }
            for (int i = 0; i < pointsB.size(); i++) {
                tb[i] = pointsB.get(i).getValue();
                tsb[i] = pointsB.get(i).getKey();

            }
        }

        private void calculateDistance() {
            this.D = new Double[ta.length + 1][tb.length + 1];
            Integer r = ta.length;
            Integer c = tb.length;
            Double dist, disti1, distj1;
            Double[] Di1 = new Double[r + 1];
            Double[] Dj1 = new Double[c + 1];
            for (int j = 1; j <= c; j++) {
                distj1 = 0.0;
                if (j > 1) {
                    distj1 += Math.pow(Math.abs(tb[j - 2] - tb[j - 1]), degree);
                } else
                    distj1 += Math.pow(Math.abs(tb[j - 1]), degree);
                Dj1[j] = (distj1);
            }
            for (int i = 1; i <= r; i++) {
                disti1 = 0.0;
                if (i > 1) {
                    disti1 += Math.pow(Math.abs(ta[i - 2] - ta[i - 1]), degree);
                } else
                    disti1 += Math.pow(Math.abs(ta[i - 1]), degree);
                Di1[i] = (disti1);
                for (int j = 1; j <= c; j++) {
                    dist = 0.0;
                    dist += Math.pow(Math.abs(ta[i - 1] - tb[j - 1]), degree);
                    if (i > 1 && j > 1)
                        dist += Math.pow(Math.abs(ta[i - 2] - tb[j - 2]), degree);
                    D[i][j] = Math.pow(dist, 1.0 / degree);
                }
            }
            D[0][0] = 0.0;
            for (int i = 1; i <= r; i++)
                D[i][0] = D[i - 1][0] + Di1[i];
            for (int j = 1; j <= c; j++)
                D[0][j] = D[0][j - 1] + Dj1[j];
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    Double htrans = Math.abs((tsa[i - 1] - tsb[j - 1]));
                    if (j > 1 && i > 1)
                        htrans += Math.abs((tsa[i - 2] - tsb[j - 2]));
                    Double dist0 = D[i - 1][j - 1] + nu * htrans + D[i][j];
                    Double dmin = dist0;
                    if (i > 1)
                        htrans = ((tsa[i - 1] - tsa[i - 2]));
                    else htrans = tsa[i - 1];
                    dist = Di1[i] + D[i - 1][j] + lambda + nu * htrans;
                    if (dmin > dist) {
                        dmin = dist;
                    }
                    if (j > 1)
                        htrans = ((tsb[j - 1] - tsb[j - 2]));
                    else htrans = tsb[j - 1];
                    dist = Dj1[j] + D[i][j - 1] + lambda + nu * htrans;
                    if (dmin > dist) {
                        dmin = dist;
                    }
                    D[i][j] = dmin;
                }
            }

        }

        public Double getDistance() {
            if (this.D == null) {
                calculateDistance();
            }
            return D[this.ta.length][this.tb.length];
        }

        public Double getSigma() {
            return this.sigma;
        }
    }
}
