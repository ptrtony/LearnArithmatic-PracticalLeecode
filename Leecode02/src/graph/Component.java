package com.example.test20260109.graph;

public class Component {
    private IGraph graph;
    private int ccount;//连通分量个数
    private int[] id;//并查集存储连通分量count数值
    private boolean[] visited;

    public Component(IGraph graph) {
        this.graph = graph;
        this.ccount = 0;
        this.id = new int[graph.V()];
        this.visited = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
           this.id[i] = -1;
           this.visited[i] = false;
        }
        //深度优先遍历
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
                id[i] = ccount;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        IGraph.AdjIterator iterator = graph.getIterator(v);
        for (int i = iterator.begin(); !iterator.end(); i = iterator.next()) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public int getCcount () {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        assert(v >= 0 && v < graph.V());
        assert(w >= 0 && w < graph.V());
        return id[v] == id[w];
    }
}
