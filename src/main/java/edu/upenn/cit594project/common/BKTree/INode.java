package edu.upenn.cit594project.common.BKTree;

public interface INode {
    // define the maximum length of a word
    public static final int LEN = 10;

    /**
     * @return the word of the current node
     */
    public String getWord();


    /**
     * @return links to other Nodes in the tree
     */
    public int[] getNext();
}
