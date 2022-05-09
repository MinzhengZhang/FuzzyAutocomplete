package edu.upenn.cit594project.repo.index;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Index for phonetic fuzzy search
 * Implemented with the Double Metaphone algorithm and a hash map
 */
@Component
public class PhoneticIndex implements Index<String, String> {
    private final Map<String, List<String>> phoneticMap = new HashMap<>();
    DoubleMetaphone dm = new DoubleMetaphone();

    /**
     * Add a value to the in-memory database
     *
     * @param value value to be added
     */
    @Override
    public void add(String value) {
        String metaphone = dm.doubleMetaphone(value);
        if (phoneticMap.containsKey(metaphone)) {
            phoneticMap.get(metaphone).add(value);
        } else {
            List<String> collection = new ArrayList<>();
            collection.add(value);
            phoneticMap.put(metaphone, collection);
        }
    }

    /**
     * Find values in the in-memory database with a hint
     *
     * @param hint hint used to find objects
     * @return a collection of the found values
     */
    @Override
    public Collection<String> find(String hint) {
        String metaphone = dm.doubleMetaphone(hint);
        return phoneticMap.getOrDefault(metaphone, Collections.emptyList());
    }
}
