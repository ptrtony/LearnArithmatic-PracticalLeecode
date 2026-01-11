package com.example.test20260109.graph;

import java.util.Vector;

public class KruskalMST {
    private Vector<Edge> mst;
    private Weight mstWeight;

    public KruskalMST(IWithWeightGraph graph) {
        mst = new Vector<>();
        LazyPrimMST.MinHeap minHeap = new LazyPrimMST.MinHeap(graph.E());
        IWithWeightGraph.AdjIterator iterator = graph.getIterator(graph.V());
        mstWeight = new Weight(0);
        for (int i = 0; i < graph.V(); i++) {
            Edge edge = iterator.begin();
            while (edge != null) {
                if (edge.V() < edge.W()) {
                    minHeap.push(edge);
                }
                edge = iterator.next();
            }
        }
        UnionFind unionFind = new UnionFind(graph.V());
        while (!minHeap.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = minHeap.pop();
            if (unionFind.isConnected(e.W(), e.V())) {
                continue;
            }
            mst.add(e);
            unionFind.unionElement(e.W(), e.V());
        }
        if (!mst.isEmpty()) {
            for (int i = 0; i < mst.size(); i++) {
                mstWeight.setWeight(mstWeight.getWeight() + mst.get(i).wt().getWeight());
            }
        }
    }

    public Vector<Edge> mstEdges() {
        return mst;
    }

    public Weight getMstWeight() {
        return mstWeight;
    }
}
