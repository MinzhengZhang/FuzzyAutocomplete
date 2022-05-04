package edu.upenn.cit594project.repo.index;

import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Index for phonetic fuzzy search
 * Implemented with the Double Metaphone algorithm and a hash map
 */
@Component
public class PhoneticIndex implements Index<String, String> {

    /**
     * Add a value to the in-memory database
     *
     * @param value value to be added
     */
    @Override
    public void add(String value) {

    }

    /**
     * Find values in the in-memory database with a hint
     *
     * @param hint hint used to find objects
     * @return a collection of the found values
     */
    @Override
    public Collection<String> find(String hint) {
        return null;
    }
}
