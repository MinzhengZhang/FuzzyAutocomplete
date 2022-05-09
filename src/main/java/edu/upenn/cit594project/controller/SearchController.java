package edu.upenn.cit594project.controller;

import edu.upenn.cit594project.common.SearchResultItem;
import edu.upenn.cit594project.common.SimpleDTO;
import edu.upenn.cit594project.service.ISearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/supportedMethods")
    public SimpleDTO<List<String>> getSupportedMethods() {
        return new SimpleDTO<>(
                List.of("Levenshtein", "WeightedLevenshtein", "Phonetic", "JaroWinkler")
        );
    }

    @GetMapping("/Levenshtein/{word}")
    public SimpleDTO<List<SearchResultItem>> getLevenshteinSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchLevenshtein(word));
    }

    @GetMapping("/WeightedLevenshtein/{word}")
    public SimpleDTO<List<SearchResultItem>> getWeightedLevenshteinSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchWeightedLevenshtein(word));
    }

    @GetMapping("/Phonetic/{word}")
    public SimpleDTO<List<SearchResultItem>> getPhoneticSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchPhonetic(word));
    }

    @GetMapping("/JaroWinkler/{word}")
    public SimpleDTO<List<SearchResultItem>> getJaroWinklerSearch(
            @PathVariable String word) {
        return new SimpleDTO<>(searchService.searchJaroWinkler(word));
    }
}
