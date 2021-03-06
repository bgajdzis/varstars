package layers;

import general.VarstarFeatureSet;
import pl.ls.comparators.ComparatorEnums;
import pl.ls.networks.layers.AbstractMonolithicIntermediateLayer;
import pl.ls.objects.compound.base.IReferenceObject;
import pl.ls.objects.rules.base.AbstractExceptionRule;

import java.util.Map;
import java.util.Set;

public class VarstarsMidLayer extends AbstractMonolithicIntermediateLayer<VarstarFeatureSet> {


    public VarstarsMidLayer(String name, Set<IReferenceObject> referencesSet, Map<IReferenceObject, Set<AbstractExceptionRule>> mapFamilyExceptions) {
        super(name, referencesSet, mapFamilyExceptions);
    }

    @Override
    protected ComparatorEnums.ConsensusType getAggregationType() {
        return ComparatorEnums.ConsensusType.ARITHMETIC_MEAN;
    }
}

