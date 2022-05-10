package edu.upenn.cit594project.common.bkTree;

public interface INode {
    // define the maximum length of a word
    public static final int LEN = 40;


    /**
     * @return the word of the current node
     */
    public String getWord();


    /**
     * @param index the index of the child
     * @return the child at the given index
     */
    public int getNext(int index);


    /**
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
