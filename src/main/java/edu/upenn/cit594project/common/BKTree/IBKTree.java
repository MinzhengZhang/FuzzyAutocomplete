package edu.upenn.cit594project.common.BKTree;

import java.util.Collection;

public interface IBKTree {
    // maximum number of words in dict[]
    public static final int MAXN = 100;
    // define the tolerance value
    public static final int TOL = 2;

    /**
     * Get the minimum value of integer a, b and c
     *
     * @param a  input integer a
     * @param b  input integer b
     * @param c  input integer c
     * @return the minimum value of integer a, b and c
     */
    public static int min(int a, int b, int c)
    {
        return Math.min(a, Math.min(b, c));
    }


    /**
     * Calculate the edit distance between two input strings
     *
     * @param str1 input string str1
     * @param str2 input string str2
     * @return he edit distance between str1 and str2
     */
    public int editDistance(String str1, String str2);


    /**
     * Add the current Node to the Tree
     *
     * @param root the root of the Tree
     * @param cur the current node
     */
    public void add(INode root, INode cur);


    /**
     * Get the words that are similar to the input string
     *
     * @param root the root of the Tree
     * @param str the input string str
     * @return a collection of strings that are similar to str
     */
    public Collection<String> getSimilarWords(INode root, String str);
}
