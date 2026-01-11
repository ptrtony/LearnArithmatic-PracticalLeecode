package com.example.test20260109.graph;

public class WithWeightSparseGraph implements IWithWeightGraph {
    private int V;
    private int m;
    private Edge[][] g;
    private boolean isDirected;
    private AdjIterator adjIterator;
    public WithWeightSparseGraph(int n, boolean isDirected) {
        this.V = n;
        this.m = 0;
        this.g = new Edge[n][];
        this.isDirected = isDirected;
        for (int i = 0; i < n; i++) {
            this.g[i] = new Edge[n];
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
    public Edge[][] G() {
        return g;
    }

    @Override
    public void addEdge(int v, int w, double weight) {
        assert(v >= 0 && v < V);
        assert(w >= 0 && w < V);
        g[v][w] = new Edge(v, w, new Weight(weight));
        if (!isDirected) {
            g[w][v] = new Edge(w, v, new Weight(weight));
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        for (int i = 0; i < g[v].length; i++) {
            if (g[v][i] != null && g[v][i].other(v) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public IWithWeightGraph.AdjIterator getIterator(int v) {
        if (adjIterator == null) {
            adjIterator = new AdjIterator(this, v);
        }
        adjIterator.setV(v);
        return adjIterator;
    }


    public static class AdjIterator implements IWithWeightGraph.AdjIterator {
        private WithWeightSparseGraph graph;
        private int v;
        private int index;
        public AdjIterator(WithWeightSparseGraph graph, int v) {
            this.graph = graph;
            this.v = v;
            this.index = 0;
        }
        @Override
        public Edge begin() {
            index = 0;
            if (graph.G()[v].length != 0) {
                return graph.G()[v][index];
            }
            return null;
        }

        @Override
        public Edge next() {
            index++;
            if (index < graph.G()[v].length) {
                return graph.G()[v][index];
            }
            return null;
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
