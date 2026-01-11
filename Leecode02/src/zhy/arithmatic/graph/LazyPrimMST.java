package zhy.arithmatic.graph;

public class LazyPrimMST {
	
	
	
	
	public static class MinHeap {
		private Edge[] edges;
		private int index;
		private int count;
		public MinHeap(int n) {
			this.count = n;
			edges = new Edge[n];
			index = 0;
		}
		
		public void push(Edge edge) {
			if(index >= count) {
				return;
			}
			edges[index] = edge;
			shiftUp(index);
			index++;
		}

		private void shiftUp(int index2) {
			// TODO Auto-generated method stub
			
		}
	}
}
