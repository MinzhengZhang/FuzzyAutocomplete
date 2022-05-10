package edu.upenn.cit594project.service;

import edu.upenn.cit594project.common.SearchResultItem;

import java.util.List;

public interface ISearchService {

    List<SearchResultItem> searchLevenshtein(String word);

    List<SearchResultItem> searchWeightedLevenshtein(String word);

    List<SearchResultItem> searchPhonetic(String word);

    List<SearchResultItem> searchJaroWinkler(String word);
}
