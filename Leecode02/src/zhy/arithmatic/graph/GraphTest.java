package zhy.arithmatic.graph;

import java.io.File;
import java.nio.file.Path;

public class GraphTest {

	public static void main(String[] args) {
		SparseGraph graph = new SparseGraph();
		 String fileName = "E:/java-space-space/LeecodeProject/Leecode02/testGraph1.txt";
		Path path = Path.of(fileName).toAbsolutePath(); 
//		File file = new File("E:/java-space-space/LeecodeProject/Leecode02/testGraph1.txt");
//		System.out.println("exits = " + file.exists());
//		String fileName = "E:/java-space-space/LeecodeProject/Leecode02/testGraph1.txt";
		ReadGraph<SparseGraph> readGraph = new ReadGraph<SparseGraph>(graph, path.toString());
		
    }
}
