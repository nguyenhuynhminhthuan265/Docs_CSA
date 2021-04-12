package com.graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph1 {

	private int vertices;
	LinkedList<Integer> object[]; // danh sach canh cua do thi
	boolean visited[];

	public BFSGraph1() {

	}

	public BFSGraph1(int vertices) {
		this.vertices = vertices;
		this.object = new LinkedList[vertices];
		visited = new boolean[vertices];
		for (int vertex = 0; vertex < vertices; vertex++) {
			visited[vertex] = false;
			object[vertex] = new LinkedList<Integer>();
		}

	}

	void addEdge(int vertexSource, int vertexDes) {
		this.object[vertexSource].add(vertexDes);
	}

	void BFS(int vertex) {
		Queue<Integer> queueVertexNeighBors = new LinkedList<Integer>();
		visited[vertex] = true;
		queueVertexNeighBors.add(vertex);
		while (queueVertexNeighBors.size() != 0) {
			vertex = queueVertexNeighBors.poll();
			System.out.println(vertex + " ");
			Iterator<Integer> i = object[vertex].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queueVertexNeighBors.add(n);
				}
			}

		}
	}

	public static void main(String args[]) {
		BFSGraph1 g = new BFSGraph1(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

}
