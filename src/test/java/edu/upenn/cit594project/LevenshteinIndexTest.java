package edu.upenn.cit594project;

import edu.upenn.cit594project.common.metric.Levenshtein;
import edu.upenn.cit594project.repo.index.LevenshteinIndex;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;
public class LevenshteinIndexTest {
    @Test
    public void testFind(){
        LevenshteinIndex li = new LevenshteinIndex();
        li.setRoot("abandon");
        li.add("zm");
        li.add("campus");
        li.add("canvas");
        li.add("can");
        li.add("bus");
        Collection collection1 = li.find("campus");
        Collection collection2 = li.find("zz");
        Collection collection3 = li.find("dqjkdqnjkashdaojhjd");


        assertEquals(6, collection1.size());
        assertEquals(6,collection2.size());
        assertEquals(0,collection3.size());
    }





}
