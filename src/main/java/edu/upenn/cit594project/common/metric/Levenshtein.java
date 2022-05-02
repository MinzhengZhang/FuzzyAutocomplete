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

    @Override
    public double getDistance(String obj1, String obj2) {
        return 0;
    }
}
