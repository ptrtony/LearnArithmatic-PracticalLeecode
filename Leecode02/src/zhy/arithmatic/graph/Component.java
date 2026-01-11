package zhy.arithmatic.graph;

import zhy.arithmatic.graph.DenseGraph.AdjIterator;
import zhy.arithmatic.graph.SparseGraph.AdjSparseIterator;

//联通分量
public class Component {
	private MyGraph graph;
	private boolean[] visited;
	private int ccount;
	private int[] id;
	public Component(MyGraph graph) {
		this.graph = graph;
		ccount = 0;
		visited = new boolean[graph.V()];
		id = new int[graph.V()];
		for(int i = 0; i < graph.V(); i ++) {
			visited[i] = false;
			id[i] = -1;
		}
		for(int i = 0; i < graph.V(); i++) {
			if(!visited[i]) {
				dfs(i);
				ccount++;
				id[i] = ccount;
			}
		}
	}
	
	public int ccout() {
		return ccount;
	}

	private void dfs(int v) {
		visited[v] = true;
		
		if(graph instanceof DenseGraph) {
			DenseGraph denseGraph = (DenseGraph)graph;
			AdjIterator adj = new AdjIterator(denseGraph, v);
			for(int i = adj.begin(); !adj.end(); adj.next()) {
				if(!visited[i]) {
					dfs(i);
				}
			}
		} else if(graph instanceof SparseGraph) {
			SparseGraph sparseGraph = (SparseGraph)graph;
			AdjSparseIterator adj = new AdjSparseIterator(sparseGraph, v);
			for(int i = adj.begin(); !adj.end(); adj.next()) {
				if(!visited[i]) {
					dfs(i);
				}
			}
		}
	}
	
	public boolean isConnected(int v, int w) {
		assert(v >= 0 && v < graph.V());
		assert(w >= 0 && w < graph.V());
		return id[v] == id[w];
	}
}
