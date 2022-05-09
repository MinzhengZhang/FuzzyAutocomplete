package edu.upenn.cit594project.repo.index;

import edu.upenn.cit594project.common.bkTree.BKTree;
import edu.upenn.cit594project.common.bkTree.INode;
import edu.upenn.cit594project.common.bkTree.Node;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Index for search by Levenshtein distance
 * Implemented with a BK tree
 */
@Component
public class LevenshteinIndex implements Index<String, String> {
    private final INode root = new Node();
    private final BKTree bkt = new BKTree(root, 8);

    /**
     * Set the word in the root of the BK-Tree to a specific value
     *
     * @param value word to be set in the root node
     */
    public void setRoot(String value) {
        root.setWord(value);
    }

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
    public List<String> find(String hint) {
        return bkt.getSimilarWords(hint);
    }

}
