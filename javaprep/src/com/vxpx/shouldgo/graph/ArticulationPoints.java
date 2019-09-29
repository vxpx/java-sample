package com.vxpx.shouldgo.graph;

public class ArticulationPoints {

	Graph graph = new Graph(6);
	int[] dfsnum = new int[6];
	int[] low = new int[6];
	int num = 0;

	private void cutVertices(int u) {

		low[u] = dfsnum[u] = num++;

		for (int v = 0; v < graph.vertexcount; v++) {

			if (graph.adj[u][v] == 1 && dfsnum[v] == -1) {
				cutVertices(v);
				if (low[v] > dfsnum[u]) {
					System.out.println("Articulation Point " + u);
				}
				low[u] = Math.min(low[u], low[v]);
			} else if (graph.adj[u][v] == 1 && dfsnum[v] != -1) {
				low[u] = Math.min(low[u], dfsnum[v]);
			}
		}
	}

	public static void main(String[] args) {

		ArticulationPoints aPoints = new ArticulationPoints();

		for (int i = 0; i < aPoints.dfsnum.length; i++) {
			aPoints.dfsnum[i] = -1;
			aPoints.low[i] = 0;
		}

		aPoints.graph.addVertex('a');
		aPoints.graph.addVertex('b');
		aPoints.graph.addVertex('c');
		aPoints.graph.addVertex('d');
		aPoints.graph.addVertex('e');
		aPoints.graph.addVertex('f');

		aPoints.graph.addEdge(0, 1);
		aPoints.graph.addEdge(0, 2);
		aPoints.graph.addEdge(1, 2);
		aPoints.graph.addEdge(2, 3);
		aPoints.graph.addEdge(3, 4);
		aPoints.graph.addEdge(3, 5);

		aPoints.cutVertices(0);

	}

}
