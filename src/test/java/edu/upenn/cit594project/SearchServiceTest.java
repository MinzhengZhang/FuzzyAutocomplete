package edu.upenn.cit594project;


import edu.upenn.cit594project.service.ISearchService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cit594ProjectApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SearchServiceTest {
    @Autowired
    private ISearchService service;


    @Test
    public void searchJaroWinklerTest() {
        Collection collection = service.searchJaroWinkler("pikachu");
        assertEquals(10, collection.size());
    }

    @Test
    public void searchWeightedLevenshteinTest() {
        Collection collection = service.searchWeightedLevenshtein("pikachu");
        assertEquals(10, collection.size());
    }

    @Test
    public void searchLevenshteinTest() {
        Collection collection = service.searchLevenshtein("pikachu");
        assertEquals(10, collection.size());

    }

    @Test
    public void searchPhonetic() {
        Collection collection = service.searchPhonetic("pikachu");
        assertEquals(10, collection.size());
    }


}
