package edu.upenn.cit594project.common.metric;

/**
 * Interface for distances between 2 objects
 *
 * @param <T1> type of the first object
 * @param <T2> type of the second object
 */
public interface IDistance<T1, T2> {
    /**
     * Compute the distance between 2 objects
     *
     * @param obj1 the first object
     * @param obj2 the second object
     * @return the distance between obj1 and obj2
     */
    double getDistance(T1 obj1, T2 obj2);
}
