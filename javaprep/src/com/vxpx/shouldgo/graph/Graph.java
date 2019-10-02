package com.vxpx.shouldgo.graph;

class Vertex {
	char label;
	boolean visted;
}

public class Graph {

	int vertexcount;
	int addcount;

	Vertex[] vertices = null;
	int[][] adj = null;

	Graph(int count) {
		vertexcount = count;
		addcount = 0;
		vertices = new Vertex[vertexcount];
		adj = new int[vertexcount][vertexcount];
	}

	public void addVertex(char label) {
		Vertex vertex = new Vertex();
		vertex.label = label;
		vertex.visted = false;
		vertices[addcount++] = vertex;
	}
	
	public void addEdge(int source, int destination) {

		adj[source][destination] = 1;
		adj[destination][source] = 1;
	}

	public int getAdjacentVertex(int vertex) {
		int adjvertex = -1;
		for (int i = 0; i < vertexcount; i++) {
			if (adj[vertex][i] == 1 && vertices[i].visted == false) {
				adjvertex = i;
				//Not having a break will always start from the last node connected to source.
				break;
			}
		}
		return adjvertex;
	}
	
	public void displayVertex(int vertex) {
		System.out.print("  " + vertices[vertex].label);
	}
}
