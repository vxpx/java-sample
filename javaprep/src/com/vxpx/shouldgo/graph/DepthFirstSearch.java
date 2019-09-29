package com.vxpx.shouldgo.graph;

import java.util.Stack;

public class DepthFirstSearch {

	
	public void depthfirstSearch(Graph graph) {
	
		Stack<Integer> stack = new Stack<Integer>();
		graph.vertices[0].visted = true;
		stack.add(0);
		
		graph.displayVertex(0);
		
		while(!stack.isEmpty()) {
			
			//The element is not popped because of DFS, until all the 
			// vertices are visted the vertex has to be on the stack.
			int vertex = graph.getAdjacentVertex(stack.peek());
			if (vertex != -1) {
				graph.displayVertex(vertex);
				graph.vertices[vertex].visted = true;
				stack.push(vertex);
			} else {
				stack.pop();
			}/* end if */
		}/* end while */
	}/* end depthfirstSearch */
	
	public static void main(String[] args) {
		DepthFirstSearch dfs = new DepthFirstSearch();
		
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
		
		dfs.depthfirstSearch(graph);
	}
}
