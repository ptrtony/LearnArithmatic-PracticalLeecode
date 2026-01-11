package com.example.test20260109.graph;

import java.util.Stack;
import java.util.Vector;

public class Path {
    private IGraph graph;
    private boolean[] visited;
    private int[] from;
    private int s;

    public Path(IGraph graph, int s) {
        this.s = s;
        this.graph = graph;
        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        //深度搜索
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        IGraph.AdjIterator iterator = graph.getIterator(v);
        for (int i = iterator.begin(); !iterator.end(); i = iterator.next()) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    public boolean hasPath(int w) {
        assert(w >= 0 && w < graph.V());
        return visited[w];
    }

    public void path(int w, Vector<Integer> v) {
        int p = w;
        Stack<Integer> stack = new Stack<>();
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        v.clear();
        while (!stack.isEmpty()) {
            v.add(stack.pop());
        }
    }

    public void showPath(int w) {
        Vector<Integer> v = new Vector<>();
        path(w, v);
        for (int i = 0; i < v.size(); i++) {
            Integer curV = v.get(i);
            System.out.print("" + v.get(i));
            if (i != v.size() - 1) {
                System.out.print("->" );
            }
        }
    }
}
