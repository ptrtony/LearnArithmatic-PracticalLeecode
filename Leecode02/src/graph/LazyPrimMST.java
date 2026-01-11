package com.example.test20260109.graph;

import java.util.Vector;

public class LazyPrimMST {

	private IWithWeightGraph graph;
	private MinHeap qp;
	private boolean[] marked;
	private Vector<Edge> mst;
	Weight mstWeight;
	public LazyPrimMST(IWithWeightGraph graph) {
		this.graph = graph;
		qp = new MinHeap(graph.E());
		mst = new Vector<Edge>();
		mstWeight = new Weight(0);
		marked = new boolean[graph.V()];
		for(int i = 0; i < graph.V(); i ++) {
			marked[i] = false;
		}
		//Lazy Prim
		visit(0);
		while (!qp.isEmpty()) {
			Edge edge = qp.pop();
			if (marked[edge.V()] == marked[edge.W()]) {
				continue;
			}
			mst.add(edge);
			if (!marked[edge.V()]) {
				visit(edge.V());
			} else {
				visit(edge.W());
			}
		}
		mstWeight.setWeight(mst.get(0).wt().getWeight());
		for (int i = 1; i < mst.size(); i++) {
			mstWeight.setWeight(mstWeight.getWeight() + mst.get(i).wt().getWeight());
		}
	}

	private void visit(int v) {
		marked[v] = true;
		IWithWeightGraph.AdjIterator iterator = graph.getIterator(v);
		Edge edge = iterator.begin();
		while (edge != null) {
			if (!marked[edge.other(v)]) {
				qp.push(edge);
			}
			edge = iterator.next();
		}
	}
	public Weight result() {
		return mstWeight;
	}

	public Vector<Edge> mstEdges() {
		return mst;
	}
	
	
	public static class MinHeap {
		private Edge[] edges;
		private int lastIndex;
		private int count;
		public MinHeap(int n) {
			this.count = n;
			edges = new Edge[n];
			lastIndex = -1;
		}

		public void push(Edge edge) {
			if(lastIndex >= count) {
				return;
			}
			lastIndex++;
			edges[lastIndex] = edge;
			shiftUp(lastIndex);
		}

		public Edge peek() {
			if(lastIndex < 0) {
				return null;
			}
			return edges[0];
		}

		public Edge pop() {
			if(lastIndex < 0) {
				return null;
			}
			Edge edge = edges[0];
			if(lastIndex != 0) {
				edges[0] = edges[lastIndex];
				lastIndex--;
				shiftDown(0);
			} else {
				lastIndex--;
			}
			return edge;
		}

		public boolean isEmpty() {
			return lastIndex < 0;
		}

		private void shiftUp(int k) {
			if(k == 0) {
				return;
			}
			while(k > 0) {
				if(edges[k].wt().getWeight() < edges[k / 2].wt().getWeight()) {
					swap(k, k / 2);
					k = k / 2;
				} else {
					break;
				}
			}
		}

		private void shiftDown(int k) {
			while(k * 2 + 1 <= lastIndex) {
				int j = k * 2 + 1;
				if((j + 1) <= lastIndex && edges[j].wt().getWeight() > edges[j + 1].wt().getWeight()) {
					j++;
				}
				if(edges[k].wt().getWeight() > edges[j].wt().getWeight()) {
					swap(k, j);
					k = j;
				} else {
					break;
				}
			}
		}

		private void swap(int k, int j) {
			Edge temp = edges[k];
			edges[k] = edges[j];
			edges[j] = temp;
		}
	}
}
