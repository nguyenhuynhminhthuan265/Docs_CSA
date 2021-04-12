package com.cybersoft.node.generic;

public class NodeBST<T> {
	public T data;
	public NodeBST<T> left;
	public NodeBST<T> right;

	public NodeBST() {

	}

	public NodeBST(T data) {
		this.data = data;
		this.left = this.right = null;
	}
}
