package edu.upenn.cit594project.common.bkTree;

import java.util.Collection;
/**
 * Interface of BKTree data structure
 */
public interface IBKTree {
    // maximum number of words in dict[]
    public static final int MAX_N = 10000;
    // define the tolerance value

    /**
     * Calculate the edit distance between two input strings
     *
     * @param str1 input string str1
     * @param str2 input string str2
     * @return the edit distance between str1 and str2
     */
    public int editDistance(String str1, String str2);


    /**
     * Add the current Node to the Tree
     *
     * @param cur  the current node
     */
    public void add(INode cur);


    /**
     * Get the words that are similar to the input string
     *
     * @param str  the input string str
     * @return a collection of strings that are similar to str
     */
    public Collection<String> getSimilarWords(String str);
}
