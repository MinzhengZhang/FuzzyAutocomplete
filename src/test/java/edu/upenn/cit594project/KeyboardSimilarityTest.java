package edu.upenn.cit594project;

import edu.upenn.cit594project.common.metric.KeyboardSimilarity;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeyboardSimilarityTest {
    @Test
    public void testGetWeight() {
        KeyboardSimilarity ks = new KeyboardSimilarity();
        assertTrue(0.0 == ks.getWeight('a', 'a'));
        double threshold = 0.001;

        assertTrue(Math.abs(0.4974623 - ks.getWeight('q', 'y')) < threshold);
        assertTrue(Math.abs(0.2763679 - ks.getWeight('q', 'p')) < threshold);
        assertTrue(Math.abs(0.8793974910 - ks.getWeight('n', 'r')) < threshold);
        assertTrue(Math.abs(0.786557027 - ks.getWeight('v', 'j')) < threshold);
    }
}
