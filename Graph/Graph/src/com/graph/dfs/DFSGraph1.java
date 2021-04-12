package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSGraph1 {
	private int vertices;
	private int[][] adjacentVertex;
	boolean visited[];

	public DFSGraph1() {
		// TODO Auto-generated constructor stub
	}

	public void init(int vertices) {
		int maxLineGraph = (vertices * (vertices - 3) / 2) + vertices + vertices;

		this.vertices = vertices;
		visited = new boolean[vertices + 1];
		adjacentVertex = new int[maxLineGraph][maxLineGraph];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}

	public DFSGraph1(int vertices) {
		int maxLineGraph = (vertices * (vertices - 3) / 2) + vertices + vertices;

		this.vertices = vertices;
		visited = new boolean[vertices + 1];
		adjacentVertex = new int[maxLineGraph][maxLineGraph];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}

	void addEdge(int src, int dest) {
		adjacentVertex[dest][src] = 1;
		adjacentVertex[src][dest] = 1;
	}

	void DFS(int startVertex) {
		visited[startVertex] = true;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(startVertex);
		
		while (!stack.isEmpty()) {
			int src = stack.pop();
			visited[src] = true;
			System.out.print((src) + " ");
			for (int i = 1; i <= vertices; i++) {
				if (visited[i] == false && adjacentVertex[src][i] == 1) {
					stack.push(i);

				}
			}

		}
	}

	public static void main(String[] args) {
		DFSGraph1 g = new DFSGraph1(8);
//		g.addEdge(2, 0);
//		g.addEdge(0, 2);
//		g.addEdge(1, 2);
//		g.addEdge(0, 1);
//		g.addEdge(3, 3);
//		g.addEdge(1, 3);
		// tao canh noi giua cac dinh ke
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 5);
		g.addEdge(2, 6);
		g.addEdge(3, 4);
		g.addEdge(3, 8);
		g.addEdge(4, 8);
		g.addEdge(5, 8);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		System.out.println("Following is Depth First Traversal");

		g.DFS(1);
		
		System.out.println("============================");
		
		
	}
}
