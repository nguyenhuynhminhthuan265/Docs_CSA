package com.cybersoft.avltree;

import java.util.ArrayList;
import java.util.List;

public class AVLNode<T> {
	T key;
	int height;
	AVLNode<T> left;
	AVLNode<T> right;
	List<T> existNode = new ArrayList<T>();

	public AVLNode() {

	}

	public AVLNode(T key, int height, AVLNode<T> left, AVLNode<T> right) {

		this.key = key;
		this.height = height;
		this.left = left;
		this.right = right;
	}

	public AVLNode(T key) {

		this.key = key;
		this.left = null;
		this.right = null;
		this.height = 1;
	}

	AVLNode<T> createNode(T key) {
		AVLNode<T> pNode = new AVLNode<T>();
		pNode.key = key;
		pNode.left = null;
		pNode.right = null;
		pNode.height = 1;
		return pNode;
	}
}
