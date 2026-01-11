package com.example.test20260109.graph;
public class UnionFind {
    private int[] parent;
    private int[] rank;//层级
    private int count;

    public UnionFind(int n) {
        this.count = n;
        this.rank = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        assert(p > 0 && p < count);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int v, int w) {
        assert(v > 0 && v < count);
        assert(w > 0 && w < count);
        return find(v) == find(w);
    }

    public void unionElement(int v, int w) {
        assert(v > 0 && v < count);
        assert(w > 0 && w < count);
        int rootV = find(v);
        int rootW = find(w);
        if (rank[rootW] > rank[rootV]) {
            parent[rootW] = parent[rootV];
        } else if (rank[rootW] < rank[rootV]) {
            parent[rootV] = parent[rootW];
        } else {
            parent[rootV] = parent[rootW];
            rank[rootW] = rank[rootW] + 1;
        }
    }
}
