package genetic;

import java.util.Map;

public class Genotype {
    private String name;
    private Map<Class, Integer> weights;
    private Map<Class, Double> thresholds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Class, Integer> getWeights() {
        return weights;
    }

    public void setWeights(Map<Class, Integer> weights) {
        this.weights = weights;
    }

    public Map<Class, Double> getThresholds() {
        return thresholds;
    }

    public void setThresholds(Map<Class, Double> thresholds) {
        this.thresholds = thresholds;
    }
}
