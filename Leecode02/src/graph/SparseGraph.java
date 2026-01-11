package com.example.test20260109.graph;

public class SparseGraph implements IGraph {
    private int V;
    private int m;
    private int[][] g;
    private boolean isDirected;
    private AdjIterator adjIterator;
    public SparseGraph(int n, boolean isDirected) {
        this.V = n;
        this.m = 0;
        this.g = new int[n][];
        this.isDirected = isDirected;
        for (int i = 0; i < n; i++) {
            this.g[i] = new int[n];
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public int[][] G() {
        return g;
    }

    @Override
    public void addEdge(int v, int w) {
        assert(v >= 0 && v < V);
        assert(w >= 0 && w < V);
        g[v][w] = w;
        if (!isDirected) {
            g[w][v] = v;
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        for (int i = 0; i < g[v].length; i++) {
            if (g[v][i] == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public IGraph.AdjIterator getIterator(int v) {
        if (adjIterator == null) {
            adjIterator = new AdjIterator(this, v);
        }
        adjIterator.setV(v);
        return adjIterator;
    }


    public static class AdjIterator implements IGraph.AdjIterator {
        private SparseGraph graph;
        private int v;
        private int index;
        public AdjIterator(SparseGraph graph, int v) {
            this.graph = graph;
            this.v = v;
            this.index = 0;
        }
        @Override
        public int begin() {
            index = 0;
            if (graph.G()[v].length != 0) {
                return graph.G()[v][index];
            }
            return -1;
        }

        @Override
        public int next() {
            index++;
            if (index < graph.G()[v].length) {
                return graph.G()[v][index];
            }
            return -1;
        }

        @Override
        public boolean end() {
            return index >= graph.G()[v].length;
        }

        public void setV(int v) {
            this.v = v;
        }
    }
}
