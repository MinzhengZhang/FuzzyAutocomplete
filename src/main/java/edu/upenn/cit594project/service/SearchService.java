package edu.upenn.cit594project.service;

import edu.upenn.cit594project.common.SearchResultItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService {
    @Override
    public List<SearchResultItem> searchLevenshtein(String word) {
        return List.of(new SearchResultItem(
                "TODO",
                "https://github.com/upenn-cit594/github-workshop-activity-mxz"
        ));
    }

    @Override
    public List<SearchResultItem> searchWeightedLevenshtein(String word) {
        return List.of(new SearchResultItem(
                "TODO",
                "https://github.com/upenn-cit594/github-workshop-activity-mxz"
        ));
    }

    @Override
    public List<SearchResultItem> searchPhonetic(String word) {
        return List.of(new SearchResultItem(
                "TODO",
                "https://github.com/upenn-cit594/github-workshop-activity-mxz"
        ));
    }

    @Override
    public List<SearchResultItem> searchJaroWinkler(String word) {
        return List.of(new SearchResultItem(
                "TODO",
                "https://github.com/upenn-cit594/github-workshop-activity-mxz"
        ));
    }
}
