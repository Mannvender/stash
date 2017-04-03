package Lecture35;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Lecture11.string2Number;
import Lecture32.LinkedList;
import Lecture33.Heap;

public class Graph {
	HashMap<String, Vertex> vertices;

	public Graph() {
		this.vertices = new HashMap<>();
	}

	private class Vertex {
		String name;
		HashMap<Vertex, Edge> neighbours;

		public Vertex(String v) {
			this.name = v;
			this.neighbours = new HashMap<>();
		}

		@Override
		public boolean equals(Object other) {
			Vertex ov = (Vertex) other;
			return this.name.equals(ov.name);

		}

		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
	}

	private class Edge {
		Vertex one;
		Vertex two;
		int weight;

		public Edge(Vertex v1, Vertex v2, int weight) {
			this.one = v1;
			this.two = v2;
			this.weight = weight;
		}

	}

	private Vertex getVertex(String v) {
		return this.vertices.get(v);
	}

	public boolean containsVertex(String v) {
		Vertex v1 = this.getVertex(v);
		if (v1 == null) {
			return false;
		} else {
			return true;
		}
	}

	public void addVertex(String v) {
		if (this.containsVertex(v)) {
			return;
		}
		Vertex vtex = new Vertex(v);
		this.vertices.put(v, vtex);

	}

	public void removeVertex(String v) {
		if (!this.containsVertex(v)) {
			return;
		}
		// getting address of object of v.
		Vertex v1 = this.getVertex(v);
		// getting neighbors for this object
		Set<Vertex> vtices = v1.neighbours.keySet();
		// for these neighbors removing this object from their neighbors map.
		for (Vertex vtex : vtices) {
			vtex.neighbours.remove(v1);
		}
		this.vertices.remove(v);

	}

	public int numEdge() {
		Collection<Vertex> allV = this.vertices.values();
		int rv = 0;
		for (Vertex vtex : allV) {
			rv += vtex.neighbours.size();
		}

		return rv / 2;

	}

	public boolean containsEdge(String v1, String v2) {
		Vertex one = this.getVertex(v1);
		Vertex two = this.getVertex(v2);
		if (one == null || two == null) {
			return false;
		}

		return one.neighbours.containsKey(two);
	}

	public void removeEdge(String v1, String v2) {
		Vertex one = this.getVertex(v1);
		Vertex two = this.getVertex(v2);
		if (one == null || two == null) {
			return;
		}
		one.neighbours.remove(two);
		two.neighbours.remove(one);
	}

	public void addEdge(String v1, String v2, int weight) {
		Vertex one = this.getVertex(v1);
		Vertex two = this.getVertex(v2);
		if (one == null || two == null || this.containsEdge(v1, v2)) {
			return;
		}
		Edge toAdd = new Edge(one, two, weight);
		one.neighbours.put(two, toAdd);
		two.neighbours.put(one, toAdd);

	}

	public void display() {
		String toPrint = "";
		Collection<Vertex> veri = this.vertices.values();
		for (Vertex v : veri) {
			toPrint += v.name + "=>";
			Set<Vertex> allN = v.neighbours.keySet();
			for (Vertex v1 : allN) {
				toPrint += v1.name + ",";
			}
			toPrint += " END";

			System.out.println(toPrint);
			toPrint = "";

		}
		System.out.println("************");

	}

	public int numVertices() {
		return this.vertices.size();
	}

	public boolean hasPath(String v1, String v2) {
		Vertex one = this.getVertex(v1);
		Vertex two = this.getVertex(v2);
		if (one == null || two == null) {
			return false;
		}

		HashMap<Vertex, Vertex> visited = new HashMap<>();
		visited.put(one, null);
		return this.hasPath(one, two, visited);

	}

	private boolean hasPath(Vertex v1, Vertex v2, HashMap<Vertex, Vertex> visited) {
		if (v1.neighbours.containsKey(v2)) {
			return true;
		}
		Set<Vertex> nbr = v1.neighbours.keySet();
		for (Vertex counter : nbr) {
			if (!visited.containsKey(counter)) {
				visited.put(counter, null);
				if (this.hasPath(counter, v2, visited)) {
					return true;
				}

			}

		}

		return false;

	}

	private boolean hasPathBFS(Vertex v1, Vertex v2, HashMap<Vertex, Vertex> visited) throws Exception {
		LinkedList<Vertex> queue = new LinkedList<>();
		if (!visited.containsKey(v1)) {
			visited.put(v1, v1);
			queue.addLast(v1);
		}

		while (!queue.isEmpty()) {
			Vertex vtx = queue.removeFirst();

			if (vtx.neighbours.containsKey(v2)) {
				return true;
			}

			Set<Vertex> nbr = vtx.neighbours.keySet();
			for (Vertex v : nbr) {
				if (!visited.containsKey(v)) {
					visited.put(v, v);
					queue.addLast(v);
				}
			}

		}

		return false;

	}

	public boolean hasPathBFS(String v1, String v2) throws Exception {

		Vertex one = this.getVertex(v1);
		Vertex two = this.getVertex(v2);
		if (one == null || two == null) {
			return false;
		}
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		return this.hasPathBFS(one, two, visited);

	}

	private boolean hasPathDFSI(Vertex v1, Vertex v2, HashMap<Vertex, Vertex> visited) throws Exception {
		LinkedList<Vertex> stack = new LinkedList<>();
		if (!visited.containsKey(v1)) {
			visited.put(v1, v1);
			stack.addFirst(v1);
		}

		while (!stack.isEmpty()) {
			Vertex vtx = stack.removeFirst();

			if (vtx.neighbours.containsKey(v2)) {
				return true;
			}

			Set<Vertex> nbr = vtx.neighbours.keySet();
			for (Vertex v : nbr) {
				if (!visited.containsKey(v)) {
					visited.put(v, v);
					stack.addFirst(v);
				}
			}

		}

		return false;

	}

	public boolean hasPathDFSI(String v1, String v2) throws Exception {

		Vertex one = this.getVertex(v1);
		Vertex two = this.getVertex(v2);
		if (one == null || two == null) {
			return false;
		}
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		return this.hasPathDFSI(one, two, visited);

	}

	public void bft() throws Exception {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		Collection<Vertex> allV = this.vertices.values();
		for (Vertex v : allV) {
			if (!visited.containsKey(v)) {
				visited.put(v, v);
				queue.addLast(v);
			}

			while (!queue.isEmpty()) {
				Vertex vtx = queue.removeFirst();
				// work area
				System.out.println(vtx.name);

				Set<Vertex> nbr = vtx.neighbours.keySet();
				for (Vertex ver : nbr) {
					if (!visited.containsKey(ver)) {
						visited.put(ver, ver);
						queue.addLast(ver);
					}
				}

			}

		}
		System.out.println("****************");
	}

	public void dft() throws Exception {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allV = this.vertices.values();
		for (Vertex v : allV) {
			if (!visited.containsKey(v)) {
				visited.put(v, v);
				stack.addFirst(v);
			}

			while (!stack.isEmpty()) {
				Vertex vtx = stack.removeFirst();
				// work area
				System.out.println(vtx.name);

				Set<Vertex> nbr = vtx.neighbours.keySet();
				for (Vertex ver : nbr) {
					if (!visited.containsKey(ver)) {
						visited.put(ver, ver);
						stack.addFirst(ver);
					}
				}

			}

		}
		System.out.println("****************");
	}

	public boolean isConnected() throws Exception {

		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		int size = 0;

		Vertex[] allV = new Vertex[this.vertices.size()];
		this.vertices.values().toArray(allV);

		if (!visited.containsKey(allV[0])) {
			queue.addLast(allV[0]);

			while (!queue.isEmpty()) {
				Vertex vtx = queue.removeFirst();
				// work area
				size++;

				Set<Vertex> nbr = vtx.neighbours.keySet();
				for (Vertex ver : nbr) {
					if (!visited.containsKey(ver)) {
						visited.put(ver, ver);
						queue.addLast(ver);
					}
				}

			}
		}

		return this.vertices.size() == visited.size();

	}

	public ArrayList<ArrayList<String>> getConnectedComponents() throws Exception {
		ArrayList<ArrayList<String>> rv = new ArrayList<>();

		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		ArrayList<String> al = new ArrayList<>();

		Collection<Vertex> allV = this.vertices.values();
		for (Vertex v : allV) {
			if (!visited.containsKey(v)) {
				visited.put(v, v);
				queue.addLast(v);

				// above if should be till end

				while (!queue.isEmpty()) {
					Vertex vtx = queue.removeFirst();
					// work area
					al.add(vtx.name);

					Set<Vertex> nbr = vtx.neighbours.keySet();
					for (Vertex ver : nbr) {
						if (!visited.containsKey(ver)) {
							visited.put(ver, ver);
							queue.addLast(ver);
						}
					}

				}
				if (!al.isEmpty()) {
					rv.add(al);
				}

				al = new ArrayList<>();
				// start adding in new AL.

			}
		}

		return rv;

	}

	public boolean isBipartite() throws Exception {
		HashMap<Vertex, String> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		Collection<Vertex> allV = this.vertices.values();
		boolean isR = true;
		for (Vertex v : allV) {
			if (!visited.containsKey(v)) {
				visited.put(v, "R");

				queue.addLast(v);

				while (!queue.isEmpty()) {
					Vertex vtx = queue.removeFirst();
					// work area

					String coloronV = visited.get(vtx);
					String colorToAppy = coloronV.equals("R") ? "G" : "R";
					Set<Vertex> nbr = vtx.neighbours.keySet();
					for (Vertex ver : nbr) {
						if (!visited.containsKey(ver)) {

							visited.put(ver, colorToAppy);
							queue.addLast(ver);
						} else {
							String color = visited.get(ver);
							if (colorToAppy.equals(color)) {
								continue;
							}
							return false;
						}
					}

				}
			}

		}

		return true;

	}

	public boolean isACyclic() throws Exception {

		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		Collection<Vertex> allV = this.vertices.values();
		boolean isR = true;
		for (Vertex v : allV) {
			if (!visited.containsKey(v)) {
				visited.put(v, null);

				queue.addLast(v);

				while (!queue.isEmpty()) {
					Vertex vtx = queue.removeFirst();
					// work area

					Set<Vertex> nbr = vtx.neighbours.keySet();
					for (Vertex ver : nbr) {
						if (!visited.containsKey(ver)) {

							visited.put(ver, vtx);
							queue.addLast(ver);
						} else {
							Vertex reasonForVTx = visited.get(vtx);
							if (reasonForVTx == ver) {
								continue;
							}
							return false;
						}
					}

				}
			}

		}

		return true;
	}

	private class pair implements Comparable<pair> {
		int cost;
		Vertex vtx;

		public pair(int cost, Vertex vtx) {
			this.cost = cost;
			this.vtx = vtx;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	public HashMap<String, Integer> djikstra(String src) {
		HashMap<String, Integer> rv = new HashMap<>();
		HashMap<Vertex, pair> vtxMap = new HashMap<>();
		Heap<pair> vtxheap = new Heap<>(true);

		Set<Map.Entry<String, Vertex>> allV = this.vertices.entrySet();

		for (Map.Entry<String, Vertex> entry : allV) {
			Vertex toput = entry.getValue();
			pair P = null;

			if (entry.getKey().equals(src)) {

				P = new pair(0, toput);
			} else {
				P = new pair(Integer.MAX_VALUE, toput);
			}

			vtxMap.put(toput, P);
			vtxheap.add(P);

		}

		while (!vtxheap.isEmpty()) {
			pair P = vtxheap.remove();
			Set<Map.Entry<Vertex, Edge>> nbrs = P.vtx.neighbours.entrySet();
			for (Map.Entry<Vertex, Edge> nbr : nbrs) {
				int OldScore = vtxMap.get(nbr.getKey()).cost;
				int newScore = P.cost + nbr.getValue().weight;
				pair op = vtxMap.get(nbr.getKey());

				if (OldScore > newScore) {
					op.cost = newScore;
					vtxheap.updatePriority(op);
				}

			}

		}
		Set<Map.Entry<Vertex, pair>> A = vtxMap.entrySet();
		for (Map.Entry<Vertex, pair> a : A) {
			rv.put(a.getKey().name, a.getValue().cost);
		}

		return rv;

	}
}
