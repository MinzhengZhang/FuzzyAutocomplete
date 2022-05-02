package edu.upenn.cit594project.repo.index;

import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Index for phonetic fuzzy search
 * Implemented with the Double Metaphone algorithm and a hash map
 */
@Component
public class PhoneticIndex implements Index<String, String> {
    @Override
    public void add(String value) {

    }

    @Override
    public Collection<String> find(String hint) {
        return null;
    }
}
