package edu.upenn.cit594project.common.metric;

/**
 * Interface for calculation of the weight in Levenshtein distance
 */
public interface ILevenshteinWeight {
    /**
     * Compute the weight between 2 characters
     *
     * @param c1 the first character
     * @param c2 the second character
     * @return the computed weight
     */
    double getWeight(Character c1, Character c2);
}
