package com.example.test20260109.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {
    private IGraph graph;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    public ShortestPath(IGraph graph, int s) {
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        ord = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        //广度优先遍历
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(s);
        while (!deque.isEmpty()) {
            int v = deque.pop();
            visited[v] = true;
            IGraph.AdjIterator iterator = graph.getIterator(v);
            for (int i = iterator.begin(); !iterator.end(); i = iterator.next()) {
                if (!visited[i]) {
                    deque.push(i);
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
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
        while (!stack.isEmpty()) {
            v.add(stack.pop());
        }
    }

    public void showPath(int w) {
        Vector<Integer> v = new Vector<>();
        path(w, v);
        for (int i = 0; i < v.size(); i++) {
            System.out.print("" + v.get(i));
            if (i != v.size() - 1) {
                System.out.print("->");
            }
        }
    }
}
