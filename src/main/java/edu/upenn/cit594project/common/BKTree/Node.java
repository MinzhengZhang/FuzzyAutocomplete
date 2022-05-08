package edu.upenn.cit594project.common.BKTree;

public class Node implements INode{
    private String word;
    private int[] next;

    public Node() {
        this.word = null;
        this.next = new int[2*LEN];
    }

    public Node (String word) {
        this.word = word;
        this.next = new int[2*LEN];
    }

    @Override
    public String getWord() {
        return this.word;
    }

    @Override
    public int getNext(int index) {
        return this.next[index];
    }

    @Override
    public void setWord(String word) {
        this.word = word;
    }

    public void setNext(int index, int value) {
        this.next[index] = value;
    }
}
