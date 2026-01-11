package com.example.test20260109.graph;

/**
 * 稠密图 使用的是邻接矩阵
 */
public class DenseGraph implements IGraph {
    private int V;//顶点个数
    private int M;//边的条数
    private boolean[][] g;//邻接矩阵数据
    private boolean isDirected;//是否有边
    private AdjIterator iterator;
    public DenseGraph(int n, boolean isDirected) {
        this.V = n;
        this.M = 0;
        this.isDirected = isDirected;
        g = new boolean[n][];
        for (int i = 0; i < n; i++) {
            g[i] = new boolean[n];
        }
    }
    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return M;
    }

    @Override
    public boolean[][] G() {
        return g;
    }

    @Override
    public void addEdge(int v, int w) {
        assert(v >= 0 && v < V);
        assert(w >= 0 && w < V);
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!isDirected) {
            g[w][v] = true;
        }
        M++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert(v >= 0 && v < V);
        assert(w >= 0 && w < V);
        return g[v][w];
    }

    @Override
    public IGraph.AdjIterator getIterator(int v) {
        if (iterator == null) {
            iterator = new AdjIterator(this, v);
        }
        iterator.setV(v);
        return iterator;
    }

    public static class AdjIterator implements IGraph.AdjIterator {
        private int index = 0;
        private int v;
        private DenseGraph graph;
        public AdjIterator(DenseGraph graph, int V) {
            this.v = V;
            this.graph = graph;
        }
        @Override
        public int begin() {
            index = -1;
            return next();
        }

        @Override
        public int next() {
            for (int i = index+= 1; i < graph.V(); i++) {
                if (graph.G()[v][index]) {
                    return index;
                }
            }
            return -1;
        }

        @Override
        public boolean end() {
            return index >= graph.V();
        }

        public void setV(int v) {
            this.v = v;
        }
    }
}
