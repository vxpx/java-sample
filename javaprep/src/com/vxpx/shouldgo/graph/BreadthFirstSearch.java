package com.vxpx.shouldgo.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public void breadthFirstSearch(Graph graph) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		graph.vertices[0].visted = true;
		graph.displayVertex(0);
		queue.add(0);
		
		while (!queue.isEmpty()) {
			
			int vertex = queue.remove();
			int adjvertex = vertex;
			//while loop is needed since in one parse we need to cover all the connected nodes.
			while ((adjvertex = graph.getAdjacentVertex(vertex)) != -1) {
				graph.displayVertex(adjvertex);
				graph.vertices[adjvertex].visted = true;
				queue.add(adjvertex);
			}/* end if */
		}/* end while */
	}/* end breadthFirstSearch */
	
	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		
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
		
		bfs.breadthFirstSearch(graph);
	}
	
}
