package com.cybersoft.queue;

public class MyPriorityQueue {
	Node<Task> front;
	Node<Task> rear;

	public MyPriorityQueue() {
		this.front = this.rear = null;
	}

	public void enqueue(Task value) {
		Node<Task> newNode = new Node<Task>(value);
		if (this.front == null) {
			this.front = this.rear = newNode;
			return;
		}
		if (this.front.data.getPriority() <= value.getPriority()) {
			newNode.next = this.front;
			this.front = newNode;

		} else {
			Node<Task> start = this.front;

			while (start.next != null && start.next.data.getPriority() > value.getPriority()) {
				start = start.next;
			}
			newNode.next = start.next;
			start.next = newNode;

		}

//		update rear
		Node<Task> temp = this.front;
		while (temp.next != null) {
			temp = temp.next;
		}
		this.rear = temp;

	}

	public void dequeue() {
		if (this.front == null) {
			this.rear = null;
			return;
		}
//		Node<Task> temp = this.front;
		this.front = this.front.next;

	}

	public Task peek() {
		return this.front.data;
	}

	public boolean isEmpty() {
		return this.front == null;
	}

}
