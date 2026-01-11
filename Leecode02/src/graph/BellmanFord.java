package com.example.test20260109.graph;

import java.util.Stack;
import java.util.Vector;

public class BellmanFord {
    private IWithWeightGraph graph;
    private int s;
    private Weight[] distTo;
    private Edge[] from;
    private boolean hasNegativeCircle;

    public BellmanFord(IWithWeightGraph graph, int s) {
        this.graph = graph;
        this.s = s;
        distTo = new Weight[graph.V()];
        from = new Edge[graph.V()];
        hasNegativeCircle = false;
        for (int i = 0; i < graph.V(); i++) {
           from[i] = null;
           distTo[i] = new Weight(0);
        }
        //Bellman ford
        distTo[s] = new Weight(0);
        for (int pass = 1; pass < graph.V(); pass++) {
            for (int i = 0; i < graph.V(); i++) {
                IWithWeightGraph.AdjIterator iterator = graph.getIterator(i);
                Edge e = iterator.begin();
                while (e != null) {
                    if (from[e.W()] == null || (distTo[e.V()].getWeight() + e.wt().getWeight()) < distTo[e.W()].getWeight()) {
                        distTo[e.W()].setWeight(distTo[e.V()].getWeight() + e.wt().getWeight());
                        from[e.W()] = e;
                    }
                    e = iterator.next();
                }
            }
        }

        hasNegativeCircle = detectedNegativeCircle();
    }

    private boolean detectedNegativeCircle() {
        for (int i = 0; i < graph.V(); i++) {
            IWithWeightGraph.AdjIterator iterator = graph.getIterator(i);
            Edge e = iterator.begin();
            while (e != null) {
                if (from[e.W()] == null || distTo[e.V()].getWeight() + e.wt().getWeight() < distTo[e.W()].getWeight()) {
                    return true;
                }
                e = iterator.next();
            }
        }
        return false;
    }

    public boolean isHasNegativeCircle() {
        return hasNegativeCircle;
    }

    public Weight shortestPathTo(int w) {
        assert(w >= 0 && w < graph.V());
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        assert(w >= 0 && w < graph.V());
        return from[w] != null;
    }

    public void shortestPath(int w, Vector<Edge> vec) {
        assert(w >= 0 && w < graph.V());
        assert(!hasNegativeCircle);
        Stack<Edge> stack = new Stack<>();
        Edge e = from[w];
        while (e != null && e.V() != this.s) {
            stack.push(e);
            e = from[e.V()];
        }
        while (!stack.isEmpty()) {
            vec.add(stack.pop());
        }
    }

    public void shortestPath(int w) {
        assert(w >= 0 && w < graph.V());
        assert(!hasNegativeCircle);
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
