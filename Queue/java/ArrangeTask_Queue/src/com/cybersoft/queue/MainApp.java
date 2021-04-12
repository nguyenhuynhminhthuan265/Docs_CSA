package com.cybersoft.queue;

public class MainApp {
	public static void main(String[] args) {
		MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
		Task task1 = new Task(1, "task 1", 1);
		Task task2 = new Task(2, "task 2", 2);
		Task task3 = new Task(3, "task 3", 5);
		Task task4 = new Task(4, "task 4", 0);
		Task task5 = new Task(5, "task 5", 4);
		Task task6 = new Task(6, "task 6", 5);

		
		myPriorityQueue.enqueue(task1);
		myPriorityQueue.enqueue(task2);
		myPriorityQueue.enqueue(task3);
		myPriorityQueue.enqueue(task4);
		myPriorityQueue.enqueue(task5);
		myPriorityQueue.enqueue(task6);
		while (!myPriorityQueue.isEmpty()) {
			System.out.println(myPriorityQueue.peek().toString());
			myPriorityQueue.dequeue();
		}
		
//		System.out.println(myPriorityQueue.rear.data.toString());
	}
}

