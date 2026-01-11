package zhy.arithmatic.graph;

//稀疏图 --邻接表
public class SparseGraph extends MyGraph {
	private int n, m;
	private boolean isDirected;
	private int[][] g;
	
	public SparseGraph() {
	}
	
	public SparseGraph(int n, boolean isDirected) {
		init(n, isDirected);
	}
	
	public void init(int n, boolean isDirected) {
		this.n = n;
		this.m = 0;
		this.isDirected = isDirected;
		g = new int[n][];
		for(int i = 0; i < n; i++) {
			g[i] = new int [n];
		}
	}
	
	public int[][] g() {
		return g;
	}
	
	public int V() {
		return n;
	}
	
	public int E() {
		return m;
	}
	
	public void addEdge(int v, int w) {
		assert(v >=0 && v < n);
		assert(w >= 0 && w < n);
		g[v][w] = w;
		if(v != w && !isDirected) {
			g[w][v] = v;
		}
		m++;
	}
	
	public boolean hasEdge(int v, int w) {
		assert(v >=0 && v < n);
		assert(w >= 0 && w < n);
		for(int i = 0; i < g[v].length; i++) {
			if(g[v][i] == w) {
				return true;
			}
		}
		return false;
	}
	
	public static class AdjSparseIterator {
		private SparseGraph G;
		private int v;
		private int index;
		public AdjSparseIterator(SparseGraph graph, int v) {
			this.G = graph;
			this.v = v;
			this.index = 0;
		}
		
		
		public int begin() {
			index = 0;
			if(G.g()[v].length != 0) {
				return G.g()[v][index];
			}
			return -1;
		}
		
		public int next() {
			index++;
			if(index < G.g()[v].length) {
				return G.g()[v][index];
			}
			return -1;
		}
		
		public boolean end() {
			return index >= G.g()[v].length;
		}
		
	}
	
}
