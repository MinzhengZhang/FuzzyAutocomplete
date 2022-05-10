package edu.upenn.cit594project;

import edu.upenn.cit594project.common.metric.JaroWinkler;
import org.junit.Test;

import static org.junit.Assert.*;
public class JaroWinklerTest {
    @Test
    public void testSimilarity() {
        JaroWinkler jw = new JaroWinkler();
        assertEquals(0.73, jw.similarity("crate", "trace"), 0.01);
    }

    @Test
    public void testGetDistance() {
        JaroWinkler jw = new JaroWinkler();
        assertEquals(0.27, jw.getDistance("crate", "trace"), 0.01);
    }
}
