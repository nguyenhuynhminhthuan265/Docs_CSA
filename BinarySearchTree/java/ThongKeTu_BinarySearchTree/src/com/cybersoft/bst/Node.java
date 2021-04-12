package com.cybersoft.bst;

public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;

	public Node() {

	}

	public Node(T data) {
		this.data = data;
		this.left = this.right = null;
	}

}
