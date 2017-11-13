package general;
import pl.ls.networks.AbstractMonolithicNetwork;
import general.VarstarFeatureSet;
import pl.ls.objects.compound.base.IReferenceObject;

import java.util.Set;

public class VarstarsNetwork extends AbstractMonolithicNetwork<VarstarFeatureSet>{
    @Override
    public boolean isDebugMode() {
        return false;
    }

    public VarstarsNetwork(String name) {
        super(name);
    }

}
