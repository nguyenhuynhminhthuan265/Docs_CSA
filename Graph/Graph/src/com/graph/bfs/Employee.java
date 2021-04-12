package com.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;

	public Employee() {
		// TODO Auto-generated constructor stub
		subordinates = new ArrayList<Integer>();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", importance=" + importance + ", subordinates=" + subordinates + "]";
	}
	
	
}