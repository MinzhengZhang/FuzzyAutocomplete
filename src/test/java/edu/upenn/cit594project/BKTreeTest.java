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
        BKTree bkt = new BKTree();
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
        INode node5 = new Node("loop");
        INode node6 = new Node("helps");
        INode node7 = new Node("shell");
        INode node8 = new Node("helper");
        INode node9 = new Node("troop");
        BKTree bkt = new BKTree(root);
        bkt.add(root, node1);
        bkt.add(root, node2);
        bkt.add(root, node3);
        bkt.add(root, node4);
        bkt.add(root, node5);
        bkt.add(root, node6);
        bkt.add(root, node7);
        bkt.add(root, node8);
        bkt.add(root, node9);
        List<String> res = (ArrayList<String>) bkt.getSimilarWords(root,"oop");
        assertEquals(2, res.size());
        assertTrue(res.contains("loop"));
        assertTrue(res.contains("troop"));
    }
}
