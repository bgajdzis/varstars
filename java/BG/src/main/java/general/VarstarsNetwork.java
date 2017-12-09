package general;

import pl.ls.networks.AbstractMonolithicNetwork;

public class VarstarsNetwork extends AbstractMonolithicNetwork<VarstarFeatureSet> {
    public VarstarsNetwork(String name) {
        super(name);
    }

    @Override
    public boolean isDebugMode() {
        return false;
    }

}
