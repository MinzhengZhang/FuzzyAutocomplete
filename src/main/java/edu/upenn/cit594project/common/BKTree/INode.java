package edu.upenn.cit594project.common.BKTree;

public interface INode {
    // define the maximum length of a word
    public static final int LEN = 10;

    /**
     * @return the word of the current node
     */
    public String getWord();


    /**
     * @return the child at given index
     */
    public int getNext(int index);


    /**
     * @param set the word of the current node
     */
    public void setWord(String word);


    /**
     * @param set the child at the given index to the given value
     */
    public void setNext(int index, int value);
}
