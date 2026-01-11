package zhy.arithmatic.graph;

//稀疏图 --邻接表
public class SparseGraph2 extends MyGraph {
	private int n, m;
	private boolean isDirected;
	private Edge[][] g;
	
	public SparseGraph2() {
	}
	
	public SparseGraph2(int n, boolean isDirected) {
		init(n, isDirected);
	}
	
	public void init(int n, boolean isDirected) {
		this.n = n;
		this.m = 0;
		this.isDirected = isDirected;
		g = new Edge[n][];
		for(int i = 0; i < n; i++) {
			g[i] = new Edge [n];
		}
	}
	
	public Edge[][] g() {
		return g;
	}
	
	public int V() {
		return n;
	}
	
	public int E() {
		return m;
	}
	
	public void addEdge(int v, int w, Weight weight) {
		assert(v >=0 && v < n);
		assert(w >= 0 && w < n);
		g[v][w] = new Edge(v, w, weight);
		if(v != w && !isDirected) {
			g[w][v] = new Edge(w, v, weight);
		}
		m++;
	}
	
	public boolean hasEdge(int v, int w) {
		assert(v >=0 && v < n);
		assert(w >= 0 && w < n);
		for(int i = 0; i < g[v].length; i++) {
			if(g[v][i].other(v) == w) {
				return true;
			}
		}
		return false;
	}
	
	public void show() {
		for(int i = 0; i < n; i ++) {
			System.out.println("vertex " + i +" <<:");
			for(int j = 0; j < n; j ++) {
				System.out.println("to " + g[i][j].W() +" ,wt: <<" + g[i][j].wt() + "<<)");
			}
		}
	}
	
	public static class AdjSparseIterator {
		private SparseGraph2 G;
		private int v;
		private int index;
		public AdjSparseIterator(SparseGraph2 graph, int v) {
			this.G = graph;
			this.v = v;
			this.index = 0;
		}
		
		
		public Edge begin() {
			index = 0;
			if(G.g()[v].length != 0) {
				return G.g()[v][index];
			}
			return null;
		}
		
		public Edge next() {
			index++;
			if(index < G.g()[v].length) {
				return G.g()[v][index];
			}
			return null;
		}
		
		public boolean end() {
			return index >= G.g()[v].length;
		}
		
	}
	
}
