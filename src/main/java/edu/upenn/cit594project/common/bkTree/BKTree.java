package edu.upenn.cit594project.common.bkTree;

import edu.upenn.cit594project.common.metric.IDistance;
import edu.upenn.cit594project.common.metric.Levenshtein;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BKTree implements IBKTree {
    private final INode root;
    private final INode[] tree;
    int ptr;
    IDistance<String, String> distCalc;
    private final int tol;

    /**
     * Constructor for BKTree, set root equals to null node
     *
     * @param tol tolerance limit for BKTree, which determines the range of edit distances
     */
    public BKTree(int tol) {
        this.root = new Node();
        this.tree = new INode[MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            tree[i] = new Node();
        }
        this.ptr = 0;
        this.distCalc = new Levenshtein();
        this.tol = tol;
    }

    /**
     * Constructor for BKTree, set root equals to argument root
     *
     * @param root root of BKTree
     * @param tol  tolerance limit for BKTree, which determines the range of edit distances
     */
    public BKTree(INode root, int tol) {
        this.root = root;
        this.tree = new INode[MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            tree[i] = new Node();
        }
        this.ptr = 0;
        this.distCalc = new Levenshtein();
        this.tol = tol;
    }

    /**
     * Constructor for BKTree, set root equals to null node and set distance calculation method to distCalc
     *
     * @param distCalc IDistance class, which includes distance calculation method
     * @param tol      tolerance limit for BKTree, which determines the range of edit distances
     */
    public BKTree(IDistance<String, String> distCalc, int tol) {
        this.root = new Node();
        this.tree = new INode[MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            tree[i] = new Node();
        }
        this.ptr = 0;
        this.distCalc = distCalc;
        this.tol = tol;
    }

    /**
     * Calculate the edit distance between two input strings
     *
     * @param str1 input string str1
     * @param str2 input string str2
     * @return the edit distance between str1 and str2
     */
    @Override
    public int editDistance(String str1, String str2) {
        return (int) Math.round(distCalc.getDistance(str1, str2));
    }

    /**
     * Add the current Node to the Tree
     *
     * @param cur the current node
     */
    @Override
    public void add(INode cur) {
        this.addHelper(this.root, cur);
    }


    private void addHelper(INode root, INode cur) {
        if (root.getWord() == null) {
            root = cur;
            return;
        }
        int dist = editDistance(cur.getWord(), root.getWord());
        if (this.tree[root.getNext(dist)].getWord() == null) {
            this.ptr++;
            tree[this.ptr] = cur;
            root.setNext(dist, this.ptr);
        } else {
            addHelper(tree[root.getNext(dist)], cur);
        }
    }

    /**
     * Get the words that are similar to the input string
     *
     * @param str the input string str
     * @return a collection of strings that are similar to str
     */
    @Override
    public List<String> getSimilarWords(String str) {
        return this.getSimilarWordsHelper(this.root, str);
    }


    private List<String> getSimilarWordsHelper(INode root, String str) {
        List<String> ret = new ArrayList<>();
        if (Objects.equals(root.getWord(), "") || root.getWord() == null) {
            return ret;
        }
        int dist = editDistance(root.getWord(), str);
        if (dist <= tol) {
            ret.add(root.getWord());
        }

        int start = dist - tol;
        if (start < 0) {
            start = 1;
        }

        while (start <= dist + tol) {
            List<String> tmp = this.getSimilarWordsHelper(this.tree[root.getNext(start)], str);
            ret.addAll(tmp);
            start++;
        }
        return ret;
    }
}
