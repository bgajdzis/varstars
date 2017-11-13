package general;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import comparators.TimeseriesDTWMCOC;
import layers.VarstarsInputLayer;
import layers.VarstarsMidLayer;
import layers.VarstarsOutputLayer;
import pl.ls.comparators.COParameter;
import pl.ls.comparators.ComparatorEnums.SharpenType;
import pl.ls.comparators.ComparatorEnums.FilterTranslationType;
import pl.ls.comparators.base.monolithic.AbstractMonolithicCOComparator;
import pl.ls.comparators.base.monolithic.IMonolithicCOComparator;
import pl.ls.exceptions.ComparatorException;
import pl.ls.exceptions.NetworkException;
import pl.ls.objects.compound.base.IReferenceObject;
import pl.ls.objects.compound.base.monolithic.IMonolithicInputGranule;
import pl.ls.objects.rules.base.AbstractExceptionRule;
import pl.ls.utils.Pair;
import com.rits.cloning.Cloner;

import comparators.AmplitudeMCOC;

public class NetworkFactory {

    /*
    public VarstarsNetwork getTestNetwork(Set<IReferenceObject> refSet) throws ComparatorException, NetworkException {
    
    	@SuppressWarnings("unused")
		Map<IReferenceObject, Set<AbstractExceptionRule>> mapFamilyExceptions = new HashMap<IReferenceObject, Set<AbstractExceptionRule>>();
        VarstarsNetwork testNetwork = new VarstarsNetwork("Siec Testowa");
        testNetwork.setNormalization4Comparators(new Pair<SharpenType, COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>>(SharpenType.SHARPEN_E_X, new COParameter<IMonolithicCOComparator<VarstarFeatureSet>,IMonolithicInputGranule<VarstarFeatureSet>,IReferenceObject>(2.0)));
        VarstarsInputLayer testInputLayer = new VarstarsInputLayer("testil", refSet, new HashMap<IReferenceObject, Set<AbstractExceptionRule>>());
        testInputLayer.addComparator(new AmplitudeMCOC("test_comp"),1);
        VarstarsOutputLayer testOutputLayer = new VarstarsOutputLayer("testol");
        testNetwork.addLayer(testInputLayer,FilterTranslationType.TOP_N,new COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>(1));
        testNetwork.addLayer(testOutputLayer,FilterTranslationType.NONE,new COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>(testInputLayer));
        return testNetwork;
    }
    */

    public VarstarsNetwork getTestNetwork(Class compToTest, Set<IReferenceObject> refSet) throws ComparatorException, NetworkException {

        @SuppressWarnings("unused")
        Map<IReferenceObject, Set<AbstractExceptionRule>> mapFamilyExceptions = new HashMap<IReferenceObject, Set<AbstractExceptionRule>>();
        Cloner cloner = new Cloner();
        Set<IReferenceObject> refSetClone = cloner.deepClone(refSet);
        VarstarsNetwork testNetwork = new VarstarsNetwork("Siec Testowa");
        testNetwork.setNormalization4Comparators(new Pair<SharpenType, COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>>(SharpenType.SHARPEN_E_X, new COParameter<IMonolithicCOComparator<VarstarFeatureSet>,IMonolithicInputGranule<VarstarFeatureSet>,IReferenceObject>(2.0)));
        VarstarsInputLayer testInputLayer = new VarstarsInputLayer("testil", refSetClone, new HashMap<IReferenceObject, Set<AbstractExceptionRule>>());
        Object testComp = null;
        try {
            Constructor<?> cons = compToTest.getConstructor(String.class);
            testComp = cons.newInstance(new Object[] {"testComp"});
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (testComp == null) {
            testComp = new AmplitudeMCOC("testComp");
        }
        testInputLayer.addComparator((AbstractMonolithicCOComparator<VarstarFeatureSet>)testComp,1);
        VarstarsOutputLayer testOutputLayer = new VarstarsOutputLayer("testol");
        testNetwork.addLayer(testInputLayer,FilterTranslationType.TOP_N,new COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>(1));
        testNetwork.addLayer(testOutputLayer,FilterTranslationType.RESULTS_FROM_PREVIOUS_LAYER,new COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>(testInputLayer));
        return testNetwork;
    }

    public VarstarsNetwork getFirstNetwork(Set<IReferenceObject> refSet) throws ComparatorException, NetworkException {

        @SuppressWarnings("unused")
        Map<IReferenceObject, Set<AbstractExceptionRule>> mapFamilyExceptions = new HashMap<IReferenceObject, Set<AbstractExceptionRule>>();
        Cloner cloner = new Cloner();
        Set<IReferenceObject> refSetClone = cloner.deepClone(refSet);
        VarstarsNetwork firstNetwork = new VarstarsNetwork("Siec Testowa");
        firstNetwork.setNormalization4Comparators(new Pair<SharpenType, COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>>(SharpenType.SHARPEN_E_X, new COParameter<IMonolithicCOComparator<VarstarFeatureSet>,IMonolithicInputGranule<VarstarFeatureSet>,IReferenceObject>(2.0)));
        VarstarsInputLayer firstInputLayer = new VarstarsInputLayer("firstil", refSetClone, new HashMap<IReferenceObject, Set<AbstractExceptionRule>>());
        Class[] comparators = Constants.allDblComparators;
        for(Class compToLayer : comparators) {
            Object testComp = null;
            try {
                Constructor<?> cons = compToLayer.getConstructor(String.class);
                String compName = compToLayer.getName();
                testComp = cons.newInstance(new Object[]{compName});
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (testComp == null) {
                testComp = new AmplitudeMCOC("testComp");
            }
            firstInputLayer.addComparator((AbstractMonolithicCOComparator<VarstarFeatureSet>) testComp, 1);
        }
        VarstarsMidLayer firstMidLayer = new VarstarsMidLayer("firstml", refSetClone, new HashMap<IReferenceObject, Set<AbstractExceptionRule>>());
        firstMidLayer.addComparator(new TimeseriesDTWMCOC("DTWCOmp"),1);
        VarstarsOutputLayer firstOutputLayer = new VarstarsOutputLayer("firstol");
        firstNetwork.addLayer(firstInputLayer,FilterTranslationType.TOP_N,new COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>(new Integer(10)));
        firstNetwork.addLayer(firstMidLayer,FilterTranslationType.TOP_N,new COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>(new Integer(1)));
        firstNetwork.addLayer(firstOutputLayer,FilterTranslationType.RESULTS_FROM_PREVIOUS_LAYER,new COParameter<IMonolithicCOComparator<VarstarFeatureSet>, IMonolithicInputGranule<VarstarFeatureSet>, IReferenceObject>(firstMidLayer));
        return firstNetwork;
    }
}