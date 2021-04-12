package com.cybersoft.queue;

public class Node<T> {
	T data;
	Node<T> next;

	public Node() {
		
	}

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

//	public Node(Task data, int priority) {
//		this.data = data;
//		
//		this.next = null;
//	}
}
