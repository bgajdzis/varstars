/**
 * Created by gajdzis on 6/9/17.
 */
package general;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public final class Utils {
    public static Double mag2lux(Double intensity) {
        return Math.pow(10.0, intensity * -0.4);
    } //should be inlined by the JVM


    public static <E> List<E> pickNRandomElements(List<E> list, int n, Random r) {
        int length = list.size();
        if (length < n) return null;

        //We don't need to shuffle the whole list
        for (int i = length - 1; i >= length - n; --i) {
            Collections.swap(list, i, r.nextInt(i + 1));
        }
        return list.subList(length - n, length);
    }

    public static <E> List<E> listSample(List<E> list, int n) {
        return pickNRandomElements(list, n, ThreadLocalRandom.current());
    }

    public static List<Map.Entry<Double, Double>> listNormalize(List<Map.Entry<Double, Double>> list) {
        Double min = list.stream().min(Comparator.comparingDouble(Map.Entry<Double, Double>::getValue)).get().getValue();
        Double max = list.stream().max(Comparator.comparingDouble(Map.Entry<Double, Double>::getValue)).get().getValue();
        for (Map.Entry<Double, Double> el : list) {
            el.setValue((el.getValue() - min) / (max - min));
        }
        //System.out.println(list.stream().min(Comparator.comparingDouble(Map.Entry<Double,Double>::getValue)).get().getValue());
        //System.out.println(list.stream().max(Comparator.comparingDouble(Map.Entry<Double,Double>::getValue)).get().getValue());
        return list;
    }
}