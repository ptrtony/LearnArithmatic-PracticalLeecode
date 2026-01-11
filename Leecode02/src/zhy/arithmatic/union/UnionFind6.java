package zhy.arithmatic.union;
//路径压缩
public class UnionFind6 {
	private int[] parent;
	private int[] rank;
	private int count;
	
	public UnionFind6(int count) {
		parent = new int[count];
		rank = new int[count];
		this.count = count;
		for(int i = 0; i < count; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	public int find(int p) {
		assert(p >= 0 && p < count);
		if(p != parent[p]) {
			parent[p] = find(parent[p]);
		}
		return parent[p];
	}
	
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	public void unionElement(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) {
			return;
		}
		if(rank[pRoot] < rank[qRoot]) {
			parent[qRoot] = pRoot;
		} else if(rank[pRoot] > rank[qRoot]){
			parent[pRoot] = qRoot;
		} else {
			parent[pRoot] = qRoot;
			rank[qRoot] = rank[qRoot] + 1;
		}
	}
}
