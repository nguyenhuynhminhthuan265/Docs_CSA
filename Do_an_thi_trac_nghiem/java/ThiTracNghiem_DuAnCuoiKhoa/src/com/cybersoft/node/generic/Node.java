package com.cybersoft.node.generic;

public class Node<T> {
	public T data;
	public Node<T> next;

	public Node() {
		this.next = null;
	}

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

}
