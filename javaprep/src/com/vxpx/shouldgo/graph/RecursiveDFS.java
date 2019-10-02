package com.vxpx.shouldgo.graph;

public class RecursiveDFS {

	public static void main(String[] args) {
		RecursiveDFS dfs = new RecursiveDFS();

		Graph graph = new Graph(6);
		graph.addVertex('a');
		graph.addVertex('b');
		graph.addVertex('c');
		graph.addVertex('d');
		graph.addVertex('e');
		graph.addVertex('f');

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 5);

		dfs.depthfirstSearch(graph, 0);
	}

	private void depthfirstSearch(Graph graph, int u) {

		graph.vertices[u].visted = true;
		graph.displayVertex(u);

		for (int i = 0; i < graph.vertexcount; i++) {
			int vertex = graph.getAdjacentVertex(u);
			if (vertex != -1) {
				depthfirstSearch(graph, vertex);
			}
		}
	}

}
