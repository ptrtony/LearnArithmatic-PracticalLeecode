package com.example.test20260109.graph;

import java.util.Stack;
import java.util.Vector;

public class Dijkstra {
    private IWithWeightGraph graph;
    private int s;
    private Weight[] distTo;
    private boolean[] marked;
    private Edge[] from;

    public Dijkstra(IWithWeightGraph graph, int s) {
        this.graph = graph;
        this.s = s;
        this.distTo = new Weight[graph.V()];
        this.marked = new boolean[graph.V()];
        this.from = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = new Weight(0);
            marked[i] = false;
            from[i] = null;
        }

        PrimMST.IndexMinHeap ipq = new PrimMST.IndexMinHeap(graph.V());
        //dijkstra
        distTo[s] = new Weight(0);
        marked[s] = true;
        ipq.push(s, distTo[s]);
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            marked[v] = true;
            IWithWeightGraph.AdjIterator iterator = graph.getIterator(v);
            Edge e = iterator.begin();
            while (e != null) {
                int w = e.other(v);
                if (!marked[w]) {
                    if ((from[w] == null) || (distTo[v].getWeight() + e.wt().getWeight()) < distTo[w].getWeight()) {
                        distTo[w].setWeight(distTo[v].getWeight() + e.wt().getWeight());
                        from[w] = e;
                        if (ipq.contains(w)) {
                            ipq.change(w, distTo[w]);
                        } else {
                            ipq.push(w, distTo[w]);
                        }
                    }
                }
                e = iterator.next();
            }
        }
    }

    public Weight shortestPathTo(int w) {
        assert(w >= 0 && w < graph.V());
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        assert(w >= 0 && w < graph.V());
        return marked[w];
    }

    public void shortestPath(int w, Vector<Edge> vec) {
        assert(w >= 0 && w < graph.V());
        Stack<Edge> stack = new Stack<>();
        Edge e = from[w];
        while (e != null && e.V() != e.W()) {
            stack.push(e);
            e = from[e.V()];
        }
        while (!stack.isEmpty()) {
            e = stack.pop();
            vec.add(e);
        }
    }

    public void showPath(int w) {
        assert(w >= 0 && w < graph.V());
        Vector<Edge> vec = new Vector<>();
        shortestPath(w, vec);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print("<< " + vec.get(i).V() + " << ->");
            if (i == vec.size() - 1) {
                System.out.print(" << " + vec.get(i).V() + " << ");
            }
        }
    }
}
