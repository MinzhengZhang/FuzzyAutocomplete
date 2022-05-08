package edu.upenn.cit594project;

import edu.upenn.cit594project.common.BKTree.BKTree;
import edu.upenn.cit594project.common.BKTree.INode;
import edu.upenn.cit594project.common.BKTree.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class BKTreeTest {
    @Test
    public void testEditDistance() {
        BKTree bkt = new BKTree(2);
        int distance = bkt.editDistance("apple", "appear");
        assertEquals(3, distance);
    }

    @Test
    public void testGetSimilarWords() {
        INode root = new Node("help");
        INode node1 = new Node("hell");
        INode node2 = new Node("hello");
        INode node3 = new Node("loop");
        INode node4 = new Node("helps");
        INode node5 = new Node("shell");
        INode node6 = new Node("helper");
        INode node7 = new Node("troop");
        BKTree bkt = new BKTree(root, 2);
        bkt.add(node1);
        bkt.add(node2);
        bkt.add(node3);
        bkt.add(node4);
        bkt.add(node5);
        bkt.add(node6);
        bkt.add(node7);
        List<String> res = (ArrayList<String>) bkt.getSimilarWords("oop");
        assertEquals(2, res.size());
        assertTrue(res.contains("loop"));
        assertTrue(res.contains("troop"));
    }
}
