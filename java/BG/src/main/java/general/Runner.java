package general;

import pl.ls.objects.compound.base.IReferenceObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Runner {
    public static void main(String[] args){
        Set<IReferenceObject> refSet;
        List<VarstarsIG> inputList = null;
        DataProvider dp = DataProvider.getInstance();
        refSet = dp.getRefSet();
        inputList = dp.getIgList();
        NetworkFactory nf = new NetworkFactory();
        System.out.println(inputList.size());
        int i = 0;
        long t0 = System.currentTimeMillis();
        try {
            VarstarsNetwork testNetwork = nf.getFirstNetwork(refSet);
            for(Iterator<VarstarsIG> iter = inputList.listIterator();iter.hasNext();) {
                VarstarsIG vig = iter.next();
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
                iter.remove();
                if(++i % 1000 == 0) {
                    dp.commitResult();
                    System.out.println("Przetworzono " + String.valueOf(i) + " obiektów w " + String.valueOf((System.currentTimeMillis()-t0)/60000) + "minut");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dp.commitResult();
            System.out.println("Ukończono");
        }
    }
}