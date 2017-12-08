package comparators;

import general.Constants;
import general.VarstarFeatureSet;
import general.VarstarsCO;
import general.VarstarsRef;
import pl.ls.comparators.ComparatorEnums;
import pl.ls.comparators.base.monolithic.AbstractMonolithicCOComparator;
import pl.ls.exceptions.ComparatorException;
import pl.ls.objects.compound.base.monolithic.IMonolithicReferenceObject;

public class FluxPercentilePercentDifferenceMCOC extends AbstractMonolithicCOComparator<VarstarFeatureSet> {


    public FluxPercentilePercentDifferenceMCOC(String name) throws ComparatorException {
        super(name);
    }

    @Override
    public Integer getUniqueId() {
        return Constants.FluxPercentilePercentDifference;
    }

    @Override
    public ComparatorEnums.ComparatorUnitCost getUnitCost() {
        return ComparatorEnums.ComparatorUnitCost.MEDIUM;
    }

    @Override
    protected void setP() {
        this.p = Constants.compP;
    }

    @Override
    protected double getMembershipValue(IMonolithicReferenceObject ref) throws ComparatorException {
        Double inputValue;
        Double referenceValue;
        try {
            inputValue = ((VarstarsCO) getInputObject()).getFluxPercentilePercentDifference();
            referenceValue = ((VarstarsRef) ref).getFluxPercentilePercentDifference();
            Double sim = 1 - (Math.abs((inputValue - referenceValue) / (referenceValue > inputValue ? referenceValue : inputValue)));
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
