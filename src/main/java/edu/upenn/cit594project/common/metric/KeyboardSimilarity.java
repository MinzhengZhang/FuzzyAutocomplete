package edu.upenn.cit594project.common.metric;

/**
 * Calculation of the inverse of the Euclidean distance between two keys on a QWERTY keyboard
 */
public class KeyboardSimilarity implements ILevenshteinWeight {

    /**
     * Get the keyboard similarity score which is the inverse of
     * the Euclidean distance between two keys on a QWERTY keyboard
     *
     * @param obj1 the first character
     * @param obj2 the second character
     * @return the keyboard similarity score for the 2 characters
     */
    @Override
    public double getWeight(Character obj1, Character obj2) {
        return 0;
    }

}
