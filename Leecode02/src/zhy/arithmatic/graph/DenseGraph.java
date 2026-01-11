package zhy.arithmatic.graph;

//稠密图- 邻接矩阵
public class DenseGraph extends MyGraph {

	int n, m;//m指边的个数
	boolean directed;
	boolean[][] g;
	public DenseGraph() {
	}
	public DenseGraph(int n, boolean directed) {
		init(n, directed);
	}
		
	public void init(int n, boolean directed) {
		this.n = n;
		this.directed = directed;
		this.m = 0;
		this.directed = directed;
		g = new boolean[n][];
		for(int i = 0; i < n; i++) {
			g[i] = new boolean[n];
		}
	}
	
	public int V() {
		return n;
	}
	
	public int E() {
		return m;
	}
	
	public void addEdge(int v, int w) {
		assert(v >= 0 && v < n);
		assert(w >= 0 && w < n);
		if(hasEdge(v, w)) {
			return;
		}
		g[v][w] = true;
		if(!directed) {
			g[w][v] = true;
		}
		m++;
	}
	
	public boolean hasEdge(int v, int w) {
		assert(v >= 0 && v < n);
		assert(w >= 0 && w < n);
		return g[v][w] == true;
	}
	
	public static class AdjIterator {
		private DenseGraph G;
		private int v;
		private int index;
		
		public AdjIterator(DenseGraph graph, int v) {
			this.v = v;
			this.index = -1;
			this.G = graph;
		}
		
		
		public int begin() {
			int index = -1;
			return next();
		}
		
		public int next() {
			for(index+= 1; index < G.V(); index++) {
				if(G.g[v][index]) {
					return index;
				}
			}
			return -1;
		}
		
		public boolean end() {
			return index >= G.V();
		}
	}
	
	
}
