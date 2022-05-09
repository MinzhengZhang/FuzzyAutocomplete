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

    @Override
    public int editDistance(String str1, String str2) {
        return (int) Math.round(distCalc.getDistance(str1, str2));
    }

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
