package zhy.arithmatic.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.Vector;

import zhy.arithmatic.graph.DenseGraph.AdjIterator;
import zhy.arithmatic.graph.SparseGraph.AdjSparseIterator;

//路径遍历
public class ShortestPath {
	private MyGraph graph;
	private boolean[] visited;
	private int s;
	private int[] from;
	private int[] ord;//存储最短路径访问的边数
	public ShortestPath(MyGraph graph, int s) {
		this.graph = graph;
		this.s = s;
		visited = new boolean[graph.V()];
		from = new int[graph.V()];
		ord = new int[graph.V()];
		for(int i = 0; i < graph.V(); i ++) {
			visited[i] = false;
			from[i] = -1;
			ord[i] = -1;
		}
		//无向图最短路径
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.push(s);
		visited[s] = true;
		ord[s] = 0;
		while(!q.isEmpty()) {
			int v = q.pop();
			if(graph instanceof DenseGraph) {
				DenseGraph denseGraph = (DenseGraph)graph;
				AdjIterator adj = new AdjIterator(denseGraph, v);
				for(int i = adj.begin(); !adj.end(); adj.next()) {
					if(!visited[i]) {
						from[i] = v;
						q.push(i);
						visited[i] = true;
						ord[i] = ord[v] + 1;
					}
				}
			} else if(graph instanceof SparseGraph) {
				SparseGraph sparseGraph = (SparseGraph)graph;
				AdjSparseIterator adj = new AdjSparseIterator(sparseGraph, v);
				for(int i = adj.begin(); !adj.end(); adj.next()) {
					if(!visited[i]) {
						from[i] = v;
						q.push(i);
						visited[i] = true;
						ord[i] = ord[v] + 1;
					}
				}
			}
			
		}
	}
	
	public boolean hasPath(int w) {
		assert(w >= 0 && w < graph.V());
		return visited[w];
	}
	
	public void path(int w, Vector<Integer> vec) {
		Stack<Integer> s = new Stack<Integer>();
		int p = w;
		while(p != -1) {
			s.push(p);
			p = from[p];
		}
		vec.clear();
		while(!s.isEmpty()) {
			vec.add(s.pop());
		}
	}
 
	public void showPath(int w) {
		Vector<Integer> vector = new Vector<Integer>();
		path(w, vector);
		for(int i = 0; i < vector.size(); i ++) {
			System.out.print("" + vector.get(i));
			if(i != vector.size()) {
				System.out.print("->");
			}
		}
	}
}
