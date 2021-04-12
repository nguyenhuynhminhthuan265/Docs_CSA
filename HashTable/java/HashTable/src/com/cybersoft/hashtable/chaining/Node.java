package com.cybersoft.hashtable.chaining;

public class Node<T> {
	T data;
	Node<T> next;

	public Node() {

	}

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

}
