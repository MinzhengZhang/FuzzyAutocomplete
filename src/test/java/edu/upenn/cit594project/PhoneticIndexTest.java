package edu.upenn.cit594project;



import edu.upenn.cit594project.repo.index.PhoneticIndex;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;
public class PhoneticIndexTest {


    @Test
    public void testFind(){
        PhoneticIndex pi = new PhoneticIndex();
        pi.add("apple");
        pi.add("banana");
        pi.add("smith");
        pi.add("smyth");
        pi.add("hello");
        pi.add("hallo");
        Collection collection1 = pi.find("hello");
        Collection collection2 = pi.find("smith");
        Collection collection3 = pi.find("banana");
        assertEquals(2,collection1.size());
        assertEquals(2,collection2.size());
        assertEquals(1,collection3.size());
    }






}
