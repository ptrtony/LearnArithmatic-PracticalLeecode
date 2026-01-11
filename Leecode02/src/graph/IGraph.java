package com.example.test20260109.graph;

public interface IGraph {
    int V();//表示顶点的个数
    int E();//表示边的条数

    <G> G G();
    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    AdjIterator getIterator(int v);

    interface AdjIterator {
        int begin();

        int next();

        boolean end();
    }
}
