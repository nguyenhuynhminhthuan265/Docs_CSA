package com.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph4_LeetCode {
	static class Solution {
		public static int getImportance(List<Employee> employees, int id) {
			Queue<Integer> queue = new LinkedList<Integer>();
			Employee employee = null;
			for (Employee temp : employees) {
				if (temp.id == id) {
					employee = temp;
					break;
				}
			}
			if (employee == null) {
				return 0;
			}
			int importance = employee.importance;
			if (employee.subordinates.size() == 0) {
				return importance;
			}
			boolean visited[] = new boolean[2000];
			for (int i = 0; i < 2000; i++) {
				visited[i] = false;
			}

			for (int i = 0; i < employee.subordinates.size(); i++) {
				queue.add(employee.subordinates.get(i));
			}
			visited[id] = true;
			while (queue.size() != 0) {
				int srcId = queue.poll();
				for (int i = 0; i < employees.size(); i++) {
					if (srcId == employees.get(i).id && visited[employees.get(i).id] == false) {
						if (employees.get(i).subordinates.size() != 0) {
							for (int j = 0; j < employees.get(i).subordinates.size(); j++) {
								queue.add(employees.get(i).subordinates.get(j));
							}
						}
						importance += employees.get(i).importance;
						visited[employees.get(i).id] = true;
					}
				}
			}
			return importance;
		}
	}

	public static void main(String[] args) {
//		Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee1 = new Employee();
		employee1.id = 1;
		employee1.importance = 5;
		employee1.subordinates = Arrays.asList(new Integer[] { 2, 3 });

		Employee employee2 = new Employee();
		employee2.id = 2;
		employee2.importance = 3;
		employee2.subordinates = Arrays.asList(new Integer[] {});

		Employee employee3 = new Employee();
		employee3.id = 3;
		employee3.importance = 3;
		employee3.subordinates = Arrays.asList(new Integer[] {});

		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		System.out.println(Solution.getImportance(employees, 1));

		System.out.println(employee1);
	}
}
