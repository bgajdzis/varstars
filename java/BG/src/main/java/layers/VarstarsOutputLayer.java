package layers;
import pl.ls.comparators.COParameter;
import pl.ls.comparators.ComparatorEnums;
import pl.ls.comparators.base.monolithic.IMonolithicCOComparator;
import pl.ls.exceptions.ComparatorException;
import pl.ls.exceptions.NetworkException;
import pl.ls.exceptions.NoCAggregationException;
import pl.ls.networks.layers.AbstractMonolithicOutputLayer;
import pl.ls.objects.compound.base.IReferenceObject;
import pl.ls.objects.compound.base.monolithic.IMonolithicInputGranule;
import general.VarstarFeatureSet;

import java.util.Set;

public class VarstarsOutputLayer extends AbstractMonolithicOutputLayer<VarstarFeatureSet> {
    public VarstarsOutputLayer(String name) {
        super(name);
    }

    /*
    @Override
    public Set<IReferenceObject> getReferencesSet() throws NetworkException {
        return null;
    }

    @Override
    public void setReferencesSet(Set<IReferenceObject> set) {

    }
    */

}
