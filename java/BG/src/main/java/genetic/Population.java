package genetic;

import java.util.Map;

public class Population {
    private Map<Genotype, Double> population;

    private Population() {
    }

    public static Population getInstance() {
        return PopulationHolder.INSTANCE;
    }

    public void initialize(Integer populationSize) {

    }

    public Map<Genotype, Double> getFittest(Integer sampleSize) {
        return null;
    }

    private void setPopulation() {

    }

    public Map<Genotype, Double> getPopulation(Integer sampleSize) {
        return null;
    }

    private static class PopulationHolder {
        private static final Population INSTANCE = new Population();
    }

    public Integer size(){
        return this.population.size();
    }
}
