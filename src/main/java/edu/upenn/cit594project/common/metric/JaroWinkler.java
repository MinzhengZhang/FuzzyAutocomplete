package edu.upenn.cit594project.common.metric;

/**
 * Calculation of weighted Jaro-Winkler distance
 */
public class JaroWinkler implements IDistance<String, String> {
    /**
     * @param obj1 the first string obj1
     * @param obj2 the second string obj2
     * @return the Jaro-Winkler distance between obj1 and obj2
     */
    @Override
    public double getDistance(String obj1, String obj2) {
        return 0;
    }
}
