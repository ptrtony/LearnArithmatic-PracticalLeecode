package com.example.test20260109.graph;

public interface IWithWeightGraph {
    int V();//表示顶点的个数
    int E();//表示边的条数

    <G> G G();
    void addEdge(int v, int w, double weight);

    boolean hasEdge(int v, int w);

    AdjIterator getIterator(int v);

    interface AdjIterator {
        Edge begin();

        Edge next();

        boolean end();
    }
}
