package edu.upenn.cit594project.service;

import edu.upenn.cit594project.common.SearchResultItem;
import edu.upenn.cit594project.common.metric.JaroWinkler;
import edu.upenn.cit594project.common.metric.KeyboardSimilarity;
import edu.upenn.cit594project.common.metric.Levenshtein;
import edu.upenn.cit594project.repo.LinkRepo;
import edu.upenn.cit594project.repo.index.LevenshteinIndex;
import edu.upenn.cit594project.repo.index.PhoneticIndex;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Levenshtein l2 = new Levenshtein();
        List<String> keys = li.find(word);
        keys.sort(Comparator.comparingDouble(k -> l2.getDistance(word, k)));
        return keys
                .stream()
                .limit(10)
                .map(k -> new SearchResultItem(k, lr.getLink(k)))
                .toList();
    }

    @Override
    public List<SearchResultItem> searchWeightedLevenshtein(String word) {
        Levenshtein l1 = new Levenshtein(new KeyboardSimilarity(), 0.4, 1.1, 1);
        Levenshtein l2 = new Levenshtein();

        Comparator<String> l1Comparator = Comparator.comparingDouble(k -> l1.getDistance(word, k));

        List<String> candidates = li.find(word);

        Stream<String> preKeyStream = candidates
                .stream()
                .filter(k -> l2.getDistance(k, word) <= 0.2 * k.length())
                .sorted(l1Comparator);

        Stream<String> postKeyStream = candidates
                .stream()
                .sorted(l1Comparator);

        return Stream.concat(preKeyStream, postKeyStream)
                .distinct()
                .limit(10)
                .map(k -> new SearchResultItem(k, lr.getLink(k)))
                .toList();
    }

    @Override
    public List<SearchResultItem> searchPhonetic(String word) {
        Levenshtein l1 = new Levenshtein(new KeyboardSimilarity(), 0.4, 1.1, 1);

        Comparator<String> l1Comparator = Comparator.comparingDouble(k -> l1.getDistance(word, k));

        Stream<String> preKeyStream = pi
                .find(word)
                .stream()
                .sorted(l1Comparator);

        Stream<String> postKeyStream = li
                .find(word)
                .stream()
                .sorted(l1Comparator);

        return Stream.concat(preKeyStream, postKeyStream)
                .distinct()
                .limit(10)
                .map(k -> new SearchResultItem(k, lr.getLink(k)))
                .collect(Collectors.toList());
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
