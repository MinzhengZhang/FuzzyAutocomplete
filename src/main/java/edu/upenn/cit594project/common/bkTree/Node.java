package edu.upenn.cit594project.common.bkTree;
/**
 * Node in the BKTree
 */
public class Node implements INode {
    private String word;
    private int[] next;
    /**
     * Default constructor for Node
     */
    public Node() {
        this.word = null;
        this.next = new int[2 * LEN];
    }

    /**
     * Constructor for Node
     * @param word set Node's word equals to word
     */
    public Node(String word) {
        this.word = word;
        this.next = new int[2 * LEN];
    }

    /**
     * Get Word in the Node
     * @return the word of the current node
     */
    @Override
    public String getWord() {
        return this.word;
    }

    /**
     * Get the children of the index
     * @param index the index of the child
     * @return the child at the given index
     */
    @Override
    public int getNext(int index) {
        return this.next[index];
    }


    /**
     * Set the word of Node equals to word
     * @param word the word to be set
     */
    @Override
    public void setWord(String word) {
        this.word = word;
    }


    /**
     * set the child at the given index to the given value
     *
     * @param index the index of the child
     * @param value the value of the child
     */
    public void setNext(int index, int value) {
        this.next[index] = value;
    }
}
