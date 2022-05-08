package edu.upenn.cit594project.common.BKTree;

import edu.upenn.cit594project.common.metric.IDistance;
import edu.upenn.cit594project.common.metric.Levenshtein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class BKTree implements IBKTree {
    private final INode root;
    private final INode[] Tree;
    int ptr;
    IDistance<String, String> distCalc;

    public BKTree() {
        this.root = new Node();
        this.Tree = new INode[MAXN];
        for (int i = 0; i < MAXN; i++) {
            Tree[i] = new Node();
        }
        this.ptr = 0;
        this.distCalc = new Levenshtein();
    }

    public BKTree(INode root) {
        this.root = root;
        this.Tree = new INode[MAXN];
        for (int i = 0; i < MAXN; i++) {
            Tree[i] = new Node();
        }
        this.ptr = 0;
        this.distCalc = new Levenshtein();
    }

    public BKTree(IDistance<String, String> distCalc) {
        this.root = new Node();
        this.Tree = new INode[MAXN];
        for (int i = 0; i < MAXN; i++) {
            Tree[i] = new Node();
        }
        this.ptr = 0;
        this.distCalc = distCalc;
    }

    @Override
    public int editDistance(String str1, String str2) {
        return (int) Math.round(distCalc.getDistance(str1, str2));
    }

    @Override
    public void add(INode root, INode cur) {
        if (root.getWord() == null) {
            root = cur;
            return;
        }
        int dist = editDistance(cur.getWord(), root.getWord());
        if (this.Tree[root.getNext(dist)].getWord() == null) {
            this.ptr++;
            Tree[this.ptr] = cur;
            root.setNext(dist, this.ptr);
        } else {
            add(Tree[root.getNext(dist)], cur);
        }
    }

    @Override
    public Collection<String> getSimilarWords(INode root, String str) {
        Collection<String> ret = new ArrayList<>();
        if (Objects.equals(root.getWord(), "") || root.getWord() == null) {
            return ret;
        }
        int dist = editDistance(root.getWord(), str);
        if (dist <= TOL) {
            ret.add(root.getWord());
        }

        int start = dist - TOL;
        if (start < 0) {
            start = 1;
        }

        while (start <= dist + TOL) {
            Collection<String> tmp = this.getSimilarWords(this.Tree[root.getNext(start)], str);
            ret.addAll(tmp);
            start++;
        }
        return ret;
    }
}
