package edu.upenn.cit594project.repo.index;

import edu.upenn.cit594project.common.BKTree.BKTree;
import edu.upenn.cit594project.common.BKTree.INode;
import edu.upenn.cit594project.common.BKTree.Node;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Index for search by Levenshtein distance
 * Implemented with a B-K tree
 */
@Component
public class LevenshteinIndex implements Index<String, String> {
    private INode root = new Node("abandon");
    private BKTree bkt = new BKTree(root,4);
    /**
     * Add a value to the in-memory database
     *
     * @param value value to be added
     */
    @Override
    public void add(String value) {
        INode node = new Node(value);
        bkt.add(node);
    }

    /**
     * Find values in the in-memory database with a hint
     *
     * @param hint hint used to find objects
     * @return a collection of the found values
     */
    @Override
    public Collection<String> find(String hint) {
        Collection<String> res = bkt.getSimilarWords(hint);
        return res;
    }

}
