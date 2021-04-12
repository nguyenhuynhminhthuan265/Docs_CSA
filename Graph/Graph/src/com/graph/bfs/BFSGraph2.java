package com.graph.bfs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph2 {

	private int vertices;
	private int[][] adjacentVertex;
	boolean visited[];

	public BFSGraph2() {

	}

	public void readFile() throws IOException {
		String line = "";
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/src/com/graph/bfs/BFS.txt"));
		this.vertices = Integer.parseInt(bufferedReader.readLine());
		init(vertices);
		int rowMatrix = 0, columnMatrix = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.isEmpty()) {
				continue;
			}

			String[] data = line.split("    ");
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
				if (1 == Integer.parseInt(data[i])) {
					addEdge(rowMatrix, i);
				}
			}
			rowMatrix++;
			System.out.println();
		}
		bufferedReader.close();
		System.out.println("\n");
	}

	public void init(int vertices) {
		int maxLineGraph = (vertices * (vertices - 3) / 2) + vertices + vertices;
		
		this.vertices = vertices;
		visited = new boolean[vertices];
		adjacentVertex = new int[maxLineGraph][maxLineGraph];

		for (int i = 0; i < vertices; i++) {
			visited[i] = false;
		}
	}

	public BFSGraph2(int vertices) {
		int maxLineGraph = (vertices * (vertices - 3) / 2) + vertices + vertices;

		this.vertices = vertices;
		visited = new boolean[vertices];
		adjacentVertex = new int[maxLineGraph][maxLineGraph];

		for (int i = 0; i < vertices; i++) {
			visited[i] = false;
		}
	}

	void addEdge(int src, int dest) {
		adjacentVertex[src][dest] = 1;
	}

	void BFS(int startVertex) {
		visited[startVertex] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startVertex);

		while (queue.size() != 0) {
			int src = queue.poll();

			System.out.print((src + 1) + " ");
			for (int j = 0; j <= vertices; j++) {
				if (adjacentVertex[src][j] == 1 && visited[j] == false) {
					queue.add(j);
					visited[j] = true;
				}
			}
		}
	}
	
	void BFSRecursive() {
		
	}

	public static void main(String args[]) throws IOException {
//		BFSGraph2 g = new BFSGraph2(4);
//
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(1, 2);
//		g.addEdge(2, 0);
//		g.addEdge(2, 3);
//		g.addEdge(3, 3);
//
//		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
//
//		g.BFS(2);

		BFSGraph2 g2 = new BFSGraph2();
		g2.readFile();
		g2.BFS(0);
	}

}
