package com.cybersoft.bst;

import java.util.Scanner;
import java.util.Vector;

public class BinarySearchTree {
	Node<Integer> root;

	public BinarySearchTree() {
		root = null;
	}

	private Node<Integer> addRecursive(Node<Integer> current, int value) {
		if (current == null) {
			return new Node<Integer>(value);
		}

		if (value < current.data) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.data) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void insert(int data) {
		root = addRecursive(root, data);
	}

	public void CreateTree() {
		int data;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Nhap vao du lieu, -1 de ket thuc: ");
			data = Integer.parseInt(scanner.nextLine());
			if (data == -1)
				break;
			insert(data);
		} while (true);
	}

	public void CreateTreeDemo() {
		// demo 1
//		int[] arrays = { 25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90 };
		int[] arrays = { 10, 8, 7, 6, 5 };
		for (int i = 0; i < arrays.length; i++) {
			insert(arrays[i]);
		}

		// demo2

//		insert(45);
//		insert(10);
//		insert(7);
//		insert(12);
//		insert(90);
//		insert(50);
	}

	public void NLR(Node<Integer> tree) {
		if (tree != null) {
			System.out.format("%4d", tree.data);
			NLR(tree.left);
			NLR(tree.right);
		}
	}

	public void LNR(Node<Integer> tree) {
		if (tree != null) {

			LNR(tree.left);
			System.out.format("%4d", tree.data);
			LNR(tree.right);
		}
	}

	public void LRN(Node<Integer> tree) {
		if (tree != null) {

			LRN(tree.left);
			LRN(tree.right);
			System.out.format("%4d", tree.data);
		}
	}

	public Node<Integer> searchRecursive(Node<Integer> root, int x) {
		if (root == null)
			return null;
		if (x < root.data)
			return searchRecursive(root.left, x);
		else if (x > root.data)
			return searchRecursive(root.right, x);
		else {
			return root;
		}

	}

	public boolean search(int key) {
		Node<Integer> root2 = searchRecursive(root, key);
		if (root2 != null)
			return true;
		else
			return false;
	}

	public int max(int a, int b) {
		if (a >= b) {
			return a;
		}
		return b;
	}

	public int getHeight(Node<Integer> root) {
		return root == null ? 0 : 1 + max(getHeight(root.left), getHeight(root.right));
	}

	public int Height(Node<Integer> root) {
		if (root == null)
			return 0;
		int HL, HR;
		HL = Height(root.left);
		HR = Height(root.right);
		if (HL > HR)
			return (1 + HL);
		return (1 + HR);
	}

	public boolean balancedTree(Node<Integer> root) {
		if (root == null) {
			return true;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.abs(left - right) <= 1 && balancedTree(root.left) && balancedTree(root.right);
	}

	int minValue(Node<Integer> root) {
		// initially minval = root
		int minval = root.data;
		// find minval
		while (root.left != null) {
			minval = root.left.data;
			root = root.left;
		}
		return minval;
	}

	public Node<Integer> removeNodeRecursive(Node<Integer> root, int x) {
		Node<Integer> p;
		if (root == null) {
			System.out.format("%d khong co trong cay", x);
			return root;
		}

		else {
			if (x < root.data)
				root.left = removeNodeRecursive(root.left, x);
			else if (x > root.data)
				root.right = removeNodeRecursive(root.right, x);
			else {
				p = root;
				if (p.right == null)
					return root.left;
				else if (p.left == null)
					return root.right;
				else {
					root.data = minValue(root.right);

					// Delete the inorder successor
					root.right = removeNodeRecursive(root.right, root.data);
//					root = SearchStandFor(root, p);
				}

			}
			return root;
		}

	}

	public void removeNode(int x) {
		root = removeNodeRecursive(root, x);
	}

//	Build Balanced Binary Search Tree
	/*
	 * This function traverse the skewed binary tree and stores its nodes pointers
	 * in vector nodes[]
	 */
	void storeBSTNodes(Node<Integer> root, Vector<Node<Integer>> nodes) {
		// Base case
		if (root == null)
			return;
		// Store nodes in Inorder (which is sorted
		// order for BST)
		storeBSTNodes(root.left, nodes);
		nodes.add(root);
		storeBSTNodes(root.right, nodes);
	}

	/* Recursive function to construct binary tree */
	Node<Integer> buildTreeUtil(Vector<Node<Integer>> nodes, int start, int end) {
		// base case
		if (start > end)
			return null;
		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Node<Integer> node = nodes.get(mid);
		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		node.left = buildTreeUtil(nodes, start, mid - 1);
		node.right = buildTreeUtil(nodes, mid + 1, end);
		return node;
	}

	// This functions converts an unbalanced BST to
	// a balanced BST
	Node<Integer> buildTree(Node<Integer> root) {
		// Store nodes of given BST in sorted order
		Vector<Node<Integer>> nodes = new Vector<Node<Integer>>();
		storeBSTNodes(root, nodes);
		// Constucts BST from nodes[]
		int n = nodes.size();
		return buildTreeUtil(nodes, 0, n - 1);
	}

}
