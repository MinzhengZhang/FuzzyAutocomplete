package edu.upenn.cit594project.repo.index;

import java.util.Collection;

/**
 * Indexes are used to quickly locate objects
 *
 * @param <V> type of the values that are being indexed
 * @param <H> type of hint used to search in the in-memory database
 */
public interface Index<V, H> {
    /**
     * Add a value to the in-memory database
     *
     * @param value value to be added
     */
    void add(V value);

    /**
     * Find values in the in-memory database with a hint, only return size 1000 collection
     *
     * @param hint hint used to find objects
     * @return a collection of the found values
     */
    Collection<V> find(H hint);
}
