package edu.upenn.cit594project.repo.index;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Index for phonetic fuzzy search
 * Implemented with the Double Metaphone algorithm and a hash map
 */
@Component
public class PhoneticIndex implements Index<String, String> {
    private Map<String, Collection> phoneticMap = new HashMap<>();
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
            Collection collection = new ArrayList();
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
        if (phoneticMap.containsKey(metaphone)) {
            return phoneticMap.get(metaphone);
        } else {
            Collection retCollection = new ArrayList();
            return retCollection;
        }
    }
}
