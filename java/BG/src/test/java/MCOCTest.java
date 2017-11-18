import comparators.*;
import general.*;
import pl.ls.objects.compound.base.IReferenceObject;
import java.util.*;
import org.junit.Test;
import java.util.Set;


public class MCOCTest {

/*
    @Test
    public void FullNetAllMCOCTestSuite(){
        Set<IReferenceObject> refSet;
        List<VarstarsIG> inputList = null;
        DataProvider dp = DataProvider.getInstance();
        refSet = dp.getRefSet();
        inputList = dp.getIgList();
        NetworkFactory nf = new NetworkFactory();
        try {
            VarstarsNetwork testNetwork = nf.getFirstNetwork(refSet);
            int i = 0;
            for(VarstarsIG vig:inputList) {
                System.out.println(++i);
                testNetwork.setInput(vig);
                testNetwork.processNetwork();
                String name = vig.getName();
                Map<IReferenceObject,Double> resultMap = testNetwork.getInput().getResults();
                if(resultMap!=null){
                    for (Map.Entry<IReferenceObject,Double> entry : resultMap.entrySet()) {
                        String key = entry.getKey().getReferenceName();
                        String value = entry.getValue().toString();
                        System.out.println(name+": "+key+" "+value);
                        dp.saveResult(name,key);
                    }
                }
		vig = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dp.commitResult();
        }
    }

    @Test
    public void GenericMCOCTestSuite(){
        Set<IReferenceObject> refSet;
        List<VarstarsIG> inputList;
        DataProvider dp = DataProvider.getInstance();
        refSet = dp.getRefSet();
        inputList = dp.getIgList();
        NetworkFactory nf = new NetworkFactory();
        VarstarsNetwork testNetwork;
        //Class[] classes = Constants.allDblComparators ;
        Class[] classes = {
                TimeseriesDTWMCOC.class
        };
        for (Class cls:classes) {
            try {
                int i = 0;
                testNetwork = nf.getTestNetwork(cls, refSet);
                for (VarstarsIG vig : inputList) {
                    if (++i > 100){
                        break;
                    }
                    System.out.println(vig.getName());
                    testNetwork.setInput(vig);
                    testNetwork.processNetwork();
                    Map<IReferenceObject, Double> resultMap = testNetwork.getInput().getResults();
                    if (resultMap != null) {
                        for (Map.Entry<IReferenceObject, Double> entry : resultMap.entrySet()) {
                            String key = entry.getKey().getReferenceName();
                            String value = entry.getValue().toString();
                            System.out.println(key + " " + value);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
*/

}
