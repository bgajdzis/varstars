/**
 * Created by gajdzis on 6/7/17.
 */
package general;

import pl.ls.objects.compound.base.monolithic.IMonolithicReferenceObject;

public class VarstarsRef extends VarstarsCO implements IMonolithicReferenceObject {

    protected String type = null;

    public VarstarsRef(VarstarFeatureSet object, String type) {
        super(object);
        this.type = type;
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getReferenceName() {
        return this.type;
    }


}
