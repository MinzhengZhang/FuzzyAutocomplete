package edu.upenn.cit594project.common.bkTree;

public interface INode {
    // define the maximum length of a word
    public static final int LEN = 40;


    /**
     * Get Word in the Node
     * @return the word of the current node
     */
    public String getWord();


    /**
     * Get the children of the index
     * @param index the index of the child
     * @return the child at the given index
     */
    public int getNext(int index);


    /**
     * Set the word of Node equals to word
     * @param word the word to be set
     */
    public void setWord(String word);


    /**
     * set the child at the given index to the given value
     *
     * @param index the index of the child
     * @param value the value of the child
     */
    public void setNext(int index, int value);
}
