package edu.upenn.cit594project;

import edu.upenn.cit594project.common.metric.Levenshtein;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevenshteinTest {
    @Test
    public void testGetDistance(){
        Levenshtein lv = new Levenshtein();
        assertTrue(Math.abs(4 - lv.getDistance("clap",""))<0.0001);
        assertTrue(Math.abs(4 - lv.getDistance("","cram"))<0.0001);
        assertTrue(Math.abs(2 - lv.getDistance("clap","cram"))<0.0001);
        assertTrue(Math.abs(3 - lv.getDistance("mitt","smitten"))<0.0001);
        assertTrue(Math.abs(2 - lv.getDistance("start","cart"))<0.0001);
        assertTrue(Math.abs(15 - lv.getDistance("this is a long sentence","this sentence is long"))<0.0001);
    }

}
