package layers;

import general.VarstarFeatureSet;
import pl.ls.comparators.ComparatorEnums;
import pl.ls.networks.layers.AbstractMonolithicInputLayer;
import pl.ls.objects.compound.base.IReferenceObject;
import pl.ls.objects.rules.base.AbstractExceptionRule;

import java.util.Map;
import java.util.Set;

public class VarstarsInputLayer extends AbstractMonolithicInputLayer<VarstarFeatureSet> {


    public VarstarsInputLayer(
            String name,
            Set<IReferenceObject> referencesSet,
            Map<IReferenceObject, Set<AbstractExceptionRule>> mapFamilyExceptions) {
        super(name, referencesSet, mapFamilyExceptions);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ComparatorEnums.ConsensusType getAggregationType() {
        return ComparatorEnums.ConsensusType.ARITHMETIC_MEAN;
    }

    @Override
    protected String getIndexedReferenceSetKey() {
        return null;
    }


}
