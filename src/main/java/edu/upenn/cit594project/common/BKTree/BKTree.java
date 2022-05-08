package edu.upenn.cit594project.common.BKTree;

import java.util.ArrayList;
import java.util.Collection;

public class BKTree implements IBKTree{
    private INode root;
    private INode[] Tree;
    int ptr;

    public BKTree(){
        this.root = new Node();
        this.Tree = new INode[MAXN];
        for (int i = 0; i < MAXN; i++) {
            Tree[i] = new Node();
        }
        this.ptr = 0;
    }

    public BKTree(INode root){
        this.root = root;
        this.Tree = new INode[MAXN];
        for (int i = 0; i < MAXN; i++) {
            Tree[i] = new Node();
        }
        this.ptr = 0;
    }

    @Override
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i=0; i <= m; i++)
            dp[i][0] = i;
        for (int j=0; j <= n; j++)
            dp[0][j] = j;

        for (int i=1; i<=m; i++)
        {
            for (int j=1; j<=n; j++)
            {
                if (str1.charAt(i - 1) != str2.charAt(j - 1))
                {
                    dp[i][j] = IBKTree.min( 1 + dp[i-1][j],  // deletion
                            1 + dp[i][j-1],  // insertion
                            1 + dp[i-1][j-1] // replacement
                    );
                }
                else
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[m][n];
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
        if (root.getWord() == "" || root.getWord() == null) {
            return ret;
        }
        int dist = editDistance(root.getWord(), str);
        if (dist <= TOL) ret.add(root.getWord());

        int start = dist - TOL;
        if (start < 0) start = 1;

        while (start <= dist + TOL) {
            Collection<String> tmp = this.getSimilarWords(this.Tree[root.getNext(start)], str);
            for (String s: tmp) {
                ret.add(s);
            }
            start++;
        }
        return ret;
    }
}
