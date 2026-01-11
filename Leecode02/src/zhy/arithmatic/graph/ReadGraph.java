package zhy.arithmatic.graph;

import java.util.List;

public class ReadGraph<G extends MyGraph> {
	
	private G graph;
	public ReadGraph(G graph, String fileName) {
		this.graph = graph;
		List<int[]> data = FileUtils.readFile(fileName);
		if(graph instanceof SparseGraph) {
			((SparseGraph) graph).init(data.size(), false);
			for(int i = 0; i < data.size(); i++) {
				int[] graphData = data.get(i);
				((SparseGraph) graph).addEdge(graphData[0], graphData[1]);	
			}
		} else if(graph instanceof DenseGraph) {
			((DenseGraph) graph).init(data.size(), false);
			for(int i = 0; i < data.size(); i++) {
				int[] graphData = data.get(i);
				((DenseGraph) graph).addEdge(graphData[0], graphData[1]);	
			}
		}
	}
}
