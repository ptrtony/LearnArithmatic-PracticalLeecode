package com.example.test20260109.graph;

/**
 * 稠密图 使用的是邻接矩阵
 */
public class WithWeightDenseGraph implements IWithWeightGraph {
    private int V;//顶点个数
    private int M;//边的条数
    private Edge[][] g;//邻接矩阵数据
    private boolean isDirected;//是否有边
    private AdjIterator iterator;
    public WithWeightDenseGraph(int n, boolean isDirected) {
        this.V = n;
        this.M = 0;
        this.isDirected = isDirected;
        g = new Edge[n][];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge[n];
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
    public Edge[][] G() {
        return g;
    }

    @Override
    public void addEdge(int v, int w, double weight) {
        assert(v >= 0 && v < V);
        assert(w >= 0 && w < V);
        if (hasEdge(v, w)) {
            g[v][w] = null;
            if (!isDirected) {
                g[w][v] = null;
            }
            M--;
        }
        g[v][w] = new Edge(v, w, new Weight(weight));
        if (!isDirected) {
            g[w][v] = new Edge(w, v, new Weight(weight));
        }
        M++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert(v >= 0 && v < V);
        assert(w >= 0 && w < V);
        return g[v][w] != null;
    }

    @Override
    public IWithWeightGraph.AdjIterator getIterator(int v) {
        if (iterator == null) {
            iterator = new AdjIterator(this, v);
        }
        iterator.setV(v);
        return iterator;
    }

    public static class AdjIterator implements IWithWeightGraph.AdjIterator {
        private int index = 0;
        private int v;
        private WithWeightDenseGraph graph;
        public AdjIterator(WithWeightDenseGraph graph, int V) {
            this.v = V;
            this.graph = graph;
        }
        @Override
        public Edge begin() {
            index = -1;
            return next();
        }

        @Override
        public Edge next() {
            for (int i = index+= 1; i < graph.V(); i++) {
                if (graph.G()[v][index] != null) {
                    return graph.G()[v][index];
                }
            }
            return null;
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
