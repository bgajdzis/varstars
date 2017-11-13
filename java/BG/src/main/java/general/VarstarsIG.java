/**
 * Created by gajdzis on 6/7/17.
 */
package general;
import pl.ls.comparators.base.monolithic.IMonolithicCOComparator;
import pl.ls.networks.layers.base.AbstractLayer;
import pl.ls.objects.compound.base.IReferenceObject;
import pl.ls.objects.compound.base.monolithic.IMonolithicInputGranule;

public class VarstarsIG extends VarstarsCO implements IMonolithicInputGranule<VarstarFeatureSet> {

    protected String name = null;

    public VarstarsIG(VarstarFeatureSet object, String name) {
        super(object);
        this.name = name;
    }


    @Override
    public VarstarFeatureSet getInput() {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }


	@Override
	public void addResembledObject(
			IMonolithicCOComparator<VarstarFeatureSet> cmp,
			IReferenceObject ref, double sim) {
		// TODO Auto-generated method stub
		igHelper.addResembledObject(cmp, ref, sim);
	}


	@Override
	public void addAggregatedObject(
			AbstractLayer<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject> layer,
			IReferenceObject ref, double sim) {
		// TODO Auto-generated method stub
		igHelper.addAggregatedObject(layer, ref, sim);
	}




	
}
