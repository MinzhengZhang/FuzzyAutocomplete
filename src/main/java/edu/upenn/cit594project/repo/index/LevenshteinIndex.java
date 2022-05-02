package edu.upenn.cit594project.repo.index;

import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Index for search by Levenshtein distance
 * Implemented with a B-K tree
 */
@Component
public class LevenshteinIndex implements Index<String, String> {
    @Override
    public void add(String value) {

    }

    @Override
    public Collection<String> find(String hint) {
        return null;
    }
}
