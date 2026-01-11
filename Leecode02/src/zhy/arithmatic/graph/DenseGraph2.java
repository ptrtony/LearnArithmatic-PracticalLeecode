package zhy.arithmatic.graph;

//稠密图- 邻接矩阵
public class DenseGraph2 extends MyGraph {

	int n, m;//m指边的个数
	boolean directed;
	Edge[][] g;
	public DenseGraph2() {
	}
	public DenseGraph2(int n, boolean directed) {
		init(n, directed);
	}
		
	public void init(int n, boolean directed) {
		this.n = n;
		this.directed = directed;
		this.m = 0;
		this.directed = directed;
		g = new Edge[n][];
		for(int i = 0; i < n; i++) {
			g[i] = new Edge[n];
		}
	}
	
	public int V() {
		return n;
	}
	
	public int E() {
		return m;
	}
	
	public void addEdge(int v, int w, Weight weight) {
		assert(v >= 0 && v < n);
		assert(w >= 0 && w < n);
		if(hasEdge(v, w)) {
			g[v][w] = null;
			if(!directed) {
				g[w][v] = null;
			}
			m--;
		}
		g[v][w] = new Edge(v, w, weight);
		if(!directed) {
			g[w][v] = new Edge(w, v, weight);
		}
		m++;
	}
	
	public boolean hasEdge(int v, int w) {
		assert(v >= 0 && v < n);
		assert(w >= 0 && w < n);
		return g[v][w] != null;
	}
	
	public void show() {
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				if( g[i][j] != null) {
					System.out.println("<< " + g[i][j].wt() + " <<");	
				}
			}
		}
	}
	
	public static class AdjIterator {
		private DenseGraph2 G;
		private int v;
		private int index;
		
		public AdjIterator(DenseGraph2 graph, int v) {
			this.v = v;
			this.index = -1;
			this.G = graph;
		}
		
		
		public Edge begin() {
			int index = -1;
			return next();
		}
		
		public Edge next() {
			for(index+= 1; index < G.V(); index++) {
				if(G.g[v][index] != null) {
					return G.g[v][index];
				}
			}
			return null;
		}
		
		public boolean end() {
			return index >= G.V();
		}
	}
	
	
}
