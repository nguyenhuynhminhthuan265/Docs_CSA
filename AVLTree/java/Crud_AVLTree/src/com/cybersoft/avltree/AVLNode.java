package com.cybersoft.avltree;

public class AVLNode {
	int key;
	int height;
	AVLNode left;
	AVLNode right;

	public AVLNode() {

	}

	public AVLNode(int key, int height, AVLNode left, AVLNode right) {

		this.key = key;
		this.height = height;
		this.left = left;
		this.right = right;
	}

	public AVLNode(int key) {

		this.key = key;
		this.left = null;
		this.right = null;
		this.height = 1;
	}

	AVLNode createNode(int key) {
		AVLNode pNode = new AVLNode();
		pNode.key = key;
		pNode.left = null;
		pNode.right = null;
		pNode.height = 1;
		return pNode;
	}
}
