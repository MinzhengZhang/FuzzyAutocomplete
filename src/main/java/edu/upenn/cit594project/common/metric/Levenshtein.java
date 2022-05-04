package edu.upenn.cit594project.common.metric;

/**
 * Calculation of weighted Levenshtein edit distance
 */
public class Levenshtein implements IDistance<String, String> {
    ILevenshteinWeight weight;

    public Levenshtein() {
        this.weight = (c1, c2) -> 1;
    }

    public Levenshtein(ILevenshteinWeight weight) {
        this.weight = weight;
    }

    /**
     * @param obj1 the first string obj1
     * @param obj2 the second string obj2
     * @return the weighted Levenshtein distance between obj1 and obj2
     */
    @Override
    public double getDistance(String obj1, String obj2) {
        return 0;
    }
}
