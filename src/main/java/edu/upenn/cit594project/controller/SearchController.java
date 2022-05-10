package edu.upenn.cit594project.controller;

import edu.upenn.cit594project.common.SearchResultItem;
import edu.upenn.cit594project.common.SimpleDTO;
import edu.upenn.cit594project.service.ISearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Main back-end controller
 */
@RestController
@RequestMapping("/api/search")
public class SearchController {

    final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    /**
     * Query search methods supported by the backend
     *
     * @return a SimpleDTO containing all supported search methods
     */
    @GetMapping("/supportedMethods")
    public SimpleDTO<List<String>> getSupportedMethods() {
        return new SimpleDTO<>(
                List.of("Levenshtein", "WeightedLevenshtein", "Phonetic", "JaroWinkler")
        );
    }

    /**
     * Search a word by Levenshtein distance
     *
     * @param word word to be searched for
     * @return a SimpleDTO containing search results
     */
    @GetMapping("/Levenshtein/{word}")
    public SimpleDTO<List<SearchResultItem>> getLevenshteinSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchLevenshtein(word));
    }

    /**
     * Search a word by weighted Levenshtein distance
     *
     * @param word word to be searched for
     * @return a SimpleDTO containing search results
     */
    @GetMapping("/WeightedLevenshtein/{word}")
    public SimpleDTO<List<SearchResultItem>> getWeightedLevenshteinSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchWeightedLevenshtein(word));
    }

    /**
     * Search a word with phonetic index
     *
     * @param word word to be searched for
     * @return a SimpleDTO containing search results
     */
    @GetMapping("/Phonetic/{word}")
    public SimpleDTO<List<SearchResultItem>> getPhoneticSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchPhonetic(word));
    }

    /**
     * Search a word with Jaro-Winkler distance
     *
     * @param word word to be searched for
     * @return a SimpleDTO containing search results
     */
    @GetMapping("/JaroWinkler/{word}")
    public SimpleDTO<List<SearchResultItem>> getJaroWinklerSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchJaroWinkler(word));
    }
}
