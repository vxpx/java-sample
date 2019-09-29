package com.vxpx.shouldgo.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GraphSaver {

	int vertices;

	LinkedList<Integer>[] adj = null;

	int[] distance = null;
	int[] path = null;
	boolean[] visted = null;

	GraphSaver(int v) {

		this.vertices = v;
		this.adj = new LinkedList[v];

		this.distance = new int[v];
		this.path = new int[v];
		this.visted = new boolean[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}

	private int getAdjacentVertex(GraphSaver graph, int vertex) {

		int unvisited = -1;

		Iterator<Integer> iter = graph.adj[vertex].iterator();
		while (iter.hasNext()) {
			int u = iter.next();

			if (graph.visted[u] == false) {
				unvisited = u;
				graph.visted[u] = true;
				break;
			}
		}

		return unvisited;
	}

	public void shortestPath(GraphSaver graph, int start) {

		for (int i = 0; i < graph.distance.length; i++) {
			graph.distance[i] = -1;
		}

		graph.distance[start] = 0;

		Queue<Integer> queue = new LinkedList();
		queue.add(start);

		while (!queue.isEmpty()) {
			int v = queue.remove();

			int adjacentVertex = v;//getAdjacentVertex(graph, v);

			while ((adjacentVertex = getAdjacentVertex(graph, v))!= -1) {

				if (graph.distance[adjacentVertex] == -1) {
					graph.distance[adjacentVertex] = graph.distance[v] + 6;
					graph.path[adjacentVertex] = v;
					queue.add(adjacentVertex);
				}
			}

		}
	}

}

public class BFSAdjacency {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		
		//int q = 1;

		for (int i = 0; i < q; i++) {

			int n = in.nextInt();
			int m = in.nextInt();
			
			/*int n = 3;
			int m = 1;*/

			GraphSaver graph = new GraphSaver(n);

			for (int j = 0; j < m; j++) {
				int u = in.nextInt();
				int v = in.nextInt();

				graph.addEdge(u-1, v-1);
			}
			
			//start node
			int start = in.nextInt();

			graph.shortestPath(graph, start-1);
			
			for(int k = 0; k < graph.vertices; k ++) {
				if (k != (start-1)) {
					System.out.print(graph.distance[k]+ " ");
				}
			}
		}
	}
}
