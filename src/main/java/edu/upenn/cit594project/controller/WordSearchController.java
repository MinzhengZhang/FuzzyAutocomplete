package edu.upenn.cit594project.controller;

import edu.upenn.cit594project.common.SearchResultItem;
import edu.upenn.cit594project.common.SimpleDTO;
import edu.upenn.cit594project.repo.index.LevenshteinIndex;
import edu.upenn.cit594project.repo.index.PhoneticIndex;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class WordSearchController {
    final LevenshteinIndex li;

    final PhoneticIndex pi;

    public WordSearchController(LevenshteinIndex li, PhoneticIndex pi) {
        this.li = li;
        this.pi = pi;
    }

    @GetMapping("/supportedMethods")
    public SimpleDTO<List<String>> getSupportedMethods() {
        return new SimpleDTO<>(
                List.of("Levenshtein", "WeightedLevenshtein", "Phonetic", "JaroWinkler")
        );
    }

    @GetMapping("/Levenshtein/{word}")
    public SimpleDTO<List<SearchResultItem>> searchLevenshtein(
            @PathVariable String word, String method) {
        return new SimpleDTO<>(
                List.of(new SearchResultItem(
                        "TODO",
                        "https://github.com/upenn-cit594/github-workshop-activity-mxz"
                ))
        );
    }

    @GetMapping("/WeightedLevenshtein/{word}")
    public SimpleDTO<List<SearchResultItem>> searchWeightedLevenshtein(
            @PathVariable String word, String method) {
        return new SimpleDTO<>(
                List.of(new SearchResultItem(
                        "TODO",
                        "https://github.com/upenn-cit594/github-workshop-activity-mxz"
                ))
        );
    }

    @GetMapping("/Phonetic/{word}")
    public SimpleDTO<List<SearchResultItem>> searchPhonetic(
            @PathVariable String word, String method) {
        return new SimpleDTO<>(
                List.of(new SearchResultItem(
                        "TODO",
                        "https://github.com/upenn-cit594/github-workshop-activity-mxz"
                ))
        );
    }

    @GetMapping("/JaroWinkler/{word}")
    public SimpleDTO<List<SearchResultItem>> searchJaroWinkler(
            @PathVariable String word, String method) {
        return new SimpleDTO<>(
                List.of(new SearchResultItem(
                        "TODO",
                        "https://github.com/upenn-cit594/github-workshop-activity-mxz"
                ))
        );
    }
}
