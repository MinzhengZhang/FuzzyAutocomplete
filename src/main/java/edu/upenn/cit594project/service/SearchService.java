package edu.upenn.cit594project.service;

import edu.upenn.cit594project.common.SearchResultItem;
import edu.upenn.cit594project.common.metric.JaroWinkler;
import edu.upenn.cit594project.common.metric.KeyboardSimilarity;
import edu.upenn.cit594project.common.metric.Levenshtein;
import edu.upenn.cit594project.repo.LinkRepo;
import edu.upenn.cit594project.repo.index.LevenshteinIndex;
import edu.upenn.cit594project.repo.index.PhoneticIndex;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService implements ISearchService {
    final LevenshteinIndex li;
    final PhoneticIndex pi;

    final LinkRepo lr;

    public SearchService(LevenshteinIndex li, PhoneticIndex pi, LinkRepo lr) {
        this.li = li;
        this.pi = pi;
        this.lr = lr;
    }

    @Override
    public List<SearchResultItem> searchLevenshtein(String word) {
        Levenshtein l = new Levenshtein();
        List<String> keys = li.find(word);
        keys.sort(Comparator.comparingDouble(k -> l.getDistance(word, k)));
        return keys
                .stream()
                .limit(10)
                .map(k -> new SearchResultItem(k, lr.getLink(k)))
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchResultItem> searchWeightedLevenshtein(String word) {
        Levenshtein l = new Levenshtein(new KeyboardSimilarity(), 0.0, 1.1, 1);
        List<String> keys = li.find(word);
        keys.sort(Comparator.comparingDouble(k -> l.getDistance(word, k)));
        return keys
                .stream()
                .limit(10)
                .map(k -> new SearchResultItem(k, lr.getLink(k)))
                .collect(Collectors.toList());
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
        JaroWinkler jw = new JaroWinkler();
        List<String> keys = li.find(word);
        keys.sort(Comparator.comparingDouble(k -> jw.similarity(word,k)));
        Collections.reverse(keys);
        return keys
                .stream()
                .limit(10)
                .map(k -> new SearchResultItem(k, lr.getLink(k)))
                .collect(Collectors.toList());
    }
}
