package Lecture35;

import java.util.HashMap;
import java.util.Map;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addEdge("A", "B", 40);
		g.addEdge("A", "C", 10);
		g.addEdge("B", "D", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("E", "F", 4);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 2);
		// g.display();
		// g.removeVertex("E");
		// g.display();
		// g.removeEdge("E", "F");
		// g.removeEdge("A", "B");
		// g.removeEdge("D", "E");
		// g.display();
		// System.out.println(g.numEdge());
		// System.out.println(g.numVertices());
		// System.out.println(g.hasPath("A", "G"));
		// System.out.println(g.hasPathBFS("A", "G"));
		// System.out.println(g.hasPathDFSI("A", "G"));
		// g.bft();
		// g.dft();
		// System.out.println(g.isConnected());
		// System.out.println(g.getConnectedComponents());
		// System.out.println(g.isBipartite());
		// System.out.println(g.isACyclic());
		HashMap<String, Integer> a = g.djikstra("A");
		for (Map.Entry<String, Integer> entry : a.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
	}

}
