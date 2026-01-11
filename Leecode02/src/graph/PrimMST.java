package com.example.test20260109.graph;

import java.util.Vector;

public class PrimMST {
    private IndexMinHeap ipq;
    private IWithWeightGraph graph;
    private Edge[] edgeTo;
    private boolean[] marked;
    private Vector<Edge> mst;
    private Weight mstWeight;

    public PrimMST(IWithWeightGraph graph) {
        this.graph = graph;
        ipq = new IndexMinHeap(graph.E());
        mstWeight = new Weight(0);
        marked = new boolean[graph.V()];
        edgeTo = new Edge[graph.V()];
        mst = new Vector<>();
        for (int i = 0; i < graph.V(); i++) {
            marked[i] = false;
            edgeTo[i] = null;
        }
        mst.clear();
        //prim
        visit(0);
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            if (v == -1) {
                break;
            }
            mst.add(edgeTo[v]);
            visit(v);
        }
        if (!mst.isEmpty()) {
            mstWeight.setWeight(mst.get(0).wt().getWeight());
        }
        if (mst.size() > 1) {
            for (int i = 1; i < mst.size(); i++) {
                mstWeight.setWeight(mst.get(i).wt().getWeight() + mstWeight.getWeight());
            }
        }
    }

    private void visit(int v) {
        assert(!marked[v]);
        marked[v] = true;
        IWithWeightGraph.AdjIterator iterator = graph.getIterator(v);
        Edge edge = iterator.begin();
        while (edge != null) {
            int w = edge.other(v);
            if (!marked[w]) {
                if (edgeTo[w] == null) {
                    ipq.push(w, edge.wt());
                    edgeTo[w] = edge;
                } else if (edge.wt().getWeight() < edgeTo[w].wt().getWeight()) {
                    edgeTo[w] = edge;
                    ipq.change(w, edge.wt());
                }
            }
            edge = iterator.next();
        }
    }

    public Vector<Edge> mstEdges() {
        return mst;
    }

    public Weight getMstWeight() {
        return mstWeight;
    }

    public static class IndexMinHeap {
        private int[] indexes;
        private int[] reverses;
        private Weight[] weights;
        private int count;
        private int capacity;
        public IndexMinHeap(int n) {
            this.capacity = n;
            this.count = 0;
            indexes = new int[n + 1];
            reverses = new int[n + 1];
            weights = new Weight[n];
            for (int i = 0; i <= n; i++) {
                indexes[i] = 0;
                reverses[i] = 0;
            }
        }

        public void push(int i, Weight weight) {
            if (count + 1 > capacity) {
                return;
            }
            if (i + 1 > capacity || i + 1 < 1) {
                return;
            }
            weights[i] = weight;
            indexes[i] = count + 1;
            reverses[count + 1] = i;
            count++;
            shiftUp(count);
        }

        public Weight peek() {
            if (indexes[1] == 0) {
                return null;
            }
            return weights[indexes[1]];
        }

        public Weight pop() {
            if (indexes[1] == 0) {
                return null;
            }
            Weight weight = weights[indexes[1]];
            swap(1, count);
            reverses[indexes[1]] = 1;
            reverses[indexes[count]] = count;
            count--;
            shiftDown(1);
            return weight;
        }

        public int extractMinIndex() {
            if (count == 0) {
                return -1;
            }
            int index = reverses[indexes[1]];
            swap(1, count);
            reverses[indexes[1]] = 1;
            reverses[indexes[count]] = count;
            count--;
            shiftDown(1);
            return index;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public void change(int i, Weight weight) {
            if (!contains(i)) {
                return;
            }
            i += 1;
            weights[i] = weight;
            int j = reverses[i];
            shiftUp(j);
            shiftDown(j);
        }

        boolean contains(int i) {
            if(i + 1 < 1 || i + 1 > capacity) {
                return false;
            }
            return reverses[i + 1] != 0;
        }

        private void shiftDown(int k) {
            while (k * 2 <= count) {
                int j = k * 2;
                if (j + 1 <= count && weights[indexes[j]].getWeight() > weights[indexes[j + 1]].getWeight()) {
                    j ++;
                }
                if (weights[indexes[k]].getWeight() > weights[indexes[j]].getWeight()) {
                    swap(k, j);
                    k = j;
                } else {
                    break;
                }
            }
        }

        private void shiftUp(int count) {
            int k = count - 1;
            while (k > 1) {
                if (weights[indexes[k]].getWeight() < weights[indexes[k / 2]].getWeight()) {
                    swap(k, k / 2);
                    reverses[indexes[k]] = k;
                    reverses[indexes[k / 2]] = k / 2;
                    k = k / 2;
                } else {
                    break;
                }
            }
        }

        private void swap(int k, int j) {
            int temp = indexes[k];
            indexes[k] = indexes[j];
            indexes[j] = temp;
        }
    }
}
