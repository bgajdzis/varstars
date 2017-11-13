/**
 * Created by gajdzis on 6/7/17.
 */
package general;
import java.util.LinkedHashMap;
import java.util.HashMap;
import general.VarstarsCO;
import general.VarstarFeatureSet;

import pl.ls.objects.compound.base.IReferenceObject;
import pl.ls.objects.compound.base.monolithic.IMonolithicReferenceObject;

public class VarstarsRef extends VarstarsCO implements IMonolithicReferenceObject{

    protected String type = null;

    @Override
    public String getReferenceName() {
        return this.type;
    }

    public VarstarsRef(VarstarFeatureSet object, String type) {
        super(object);
        this.type = type;
        // TODO Auto-generated constructor stub
    }


}
