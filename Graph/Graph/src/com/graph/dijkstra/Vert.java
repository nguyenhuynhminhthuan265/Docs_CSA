package com.graph.dijkstra;

import java.util.List;

public class Vert {
	public boolean visited;
	public String name;
	public List<Edge> list;
	public double dist = Double.MAX_VALUE;
	public Vert pr;
}
