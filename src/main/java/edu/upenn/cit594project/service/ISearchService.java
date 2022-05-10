package edu.upenn.cit594project.service;

import edu.upenn.cit594project.common.SearchResultItem;

import java.util.List;

/**
 * Interface for basic search service
 */
public interface ISearchService {

    /**
     * Search words by primitive Levenshtein distance
     *
     * @param word word to be searched in the repo
     * @return a list of search results
     */
    List<SearchResultItem> searchLevenshtein(String word);

    /**
     * Search words by weighted Levenshtein distance
     *
     * @param word word to be searched in the repo
     * @return a list of search results
     */
    List<SearchResultItem> searchWeightedLevenshtein(String word);

    /**
     * Search words using Phonetic index
     *
     * @param word word to be searched in the repo
     * @return a list of search results
     */
    List<SearchResultItem> searchPhonetic(String word);

    /**
     * Search words with Jaro-Winkler distance
     *
     * @param word word to be searched in the repo
     * @return a list of search results
     */
    List<SearchResultItem> searchJaroWinkler(String word);
}
