package comparators;

import general.Constants;
import general.VarstarFeatureSet;
import general.VarstarsCO;
import general.VarstarsRef;
import pl.ls.comparators.ComparatorEnums;
import pl.ls.comparators.base.monolithic.AbstractMonolithicCOComparator;
import pl.ls.exceptions.ComparatorException;
import pl.ls.objects.compound.base.monolithic.IMonolithicReferenceObject;

public class Fc2DetrendMCOC extends AbstractMonolithicCOComparator<VarstarFeatureSet> {


    public Fc2DetrendMCOC(String name) throws ComparatorException {
        super(name);
    }

    @Override
    public Integer getUniqueId() {
        return Constants.Fc2Detrend;
    }

    @Override
    public ComparatorEnums.ComparatorUnitCost getUnitCost() {
        return
                ComparatorEnums.ComparatorUnitCost.MEDIUM;
    }

    @Override
    protected void setP() {
        this.p = Constants.nonPerP;
    }

    @Override
    protected double getMembershipValue(IMonolithicReferenceObject ref) throws
            ComparatorException {
        try {
            if (!(((VarstarsRef) ref).getReferenceName().equals("NPer"))) {
                this.p = Constants.perP;
            }
        } catch (Exception e) {
            //log.error(e, e);
            return 0;
        }
        Double inputValue;
        Double referenceValue;
        try {
            inputValue = ((VarstarsCO) getInputObject()).getFc2Detrend();
            referenceValue = ((VarstarsRef) ref).getFc2Detrend();
            Double sim = 1 - (Math.abs((inputValue - referenceValue) / (referenceValue > inputValue ? referenceValue
                    : inputValue)));
            //System.out.println(ref.getReferenceName());
            //System.out.println(sim);
            return sim;
        } catch (Exception e) {
            //log.error(e,e);
            return 0;
        }
    }

    @Override
    protected boolean isExceptionSatisfied(IMonolithicReferenceObject ref) {
        return false;
    }
}
