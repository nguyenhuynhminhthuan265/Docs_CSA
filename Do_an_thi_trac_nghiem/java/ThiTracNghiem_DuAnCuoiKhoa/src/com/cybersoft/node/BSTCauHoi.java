package com.cybersoft.node;

import java.util.Scanner;
import java.util.Vector;

import com.cybersoft.model.entity.CauHoi;
import com.cybersoft.node.generic.NodeBST;

public class BSTCauHoi {
	public NodeBST<CauHoi> root;

	public BSTCauHoi() {
		root = null;
	}

	private NodeBST<CauHoi> addRecursive(NodeBST<CauHoi> current, CauHoi value) {
		if (current == null) {
			return new NodeBST<CauHoi>(value);
		}

		if (value.getId() < current.data.getId()) {
			current.left = addRecursive(current.left, value);
		} else if (value.getId() > current.data.getId()) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void insert(CauHoi data) {
		root = addRecursive(root, data);
	}

	public void CreateTree() {
		CauHoi data = new CauHoi();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Nhap vao du lieu, -1 de ket thuc: ");
			data.input(scanner);
			if (data == null)
				break;
			insert(data);
		} while (true);
	}

//	public void CreateTreeDemo() {
//		// demo 1
//		int[] arrays = { 25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90 };
//		for (int i = 0; i < arrays.length; i++) {
//			insert(arrays[i]);
//		}
//
//		// demo2
//
////		insert(45);
////		insert(10);
////		insert(7);
////		insert(12);
////		insert(90);
////		insert(50);
//	}

	public void NLR(NodeBST<CauHoi> tree) {
		if (tree != null) {
			System.out.format("%4d", tree.data);
			NLR(tree.left);
			NLR(tree.right);
		}
	}

	public void LNR(NodeBST<CauHoi> tree) {
		if (tree != null) {

			LNR(tree.left);
			System.out.println(tree.data.toString());
			LNR(tree.right);
		}
	}

	public void LRN(NodeBST<CauHoi> tree) {
		if (tree != null) {

			LRN(tree.left);
			LRN(tree.right);
			System.out.format("%4d", tree.data);
		}
	}

	public NodeBST<CauHoi> searchRecursive(NodeBST<CauHoi> root, CauHoi key) {
		if (root == null)
			return null;
		if (key.getId() < root.data.getId())
			return searchRecursive(root.left, key);
		else if (key.getId() > root.data.getId())
			return searchRecursive(root.right, key);
		else {
			return root;
		}

	}

	public NodeBST<CauHoi> searchRecursive(NodeBST<CauHoi> root, int key) {
		if (root == null)
			return null;
		if (key < root.data.getId())
			return searchRecursive(root.left, key);
		else if (key > root.data.getId())
			return searchRecursive(root.right, key);
		else {
			return root;
		}

	}

	public boolean search(CauHoi key) {
		NodeBST<CauHoi> res = searchRecursive(root, key);
		if (res != null)
			return true;
		else
			return false;
	}

	public CauHoi search(int key) {
		NodeBST<CauHoi> res = searchRecursive(root, key);
		if (res != null)
			return res.data;
		else
			return null;
	}

	public int max(int a, int b) {
		if (a >= b) {
			return a;
		}
		return b;
	}

	public int getHeight(NodeBST<CauHoi> root) {
		return root == null ? 0 : 1 + max(getHeight(root.left), getHeight(root.right));
	}

	public int Height(NodeBST<CauHoi> root) {
		if (root == null)
			return 0;
		int HL, HR;
		HL = Height(root.left);
		HR = Height(root.right);
		if (HL > HR)
			return (1 + HL);
		return (1 + HR);
	}

	public boolean balancedTree(NodeBST<CauHoi> root) {
		if (root == null) {
			return true;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.abs(left - right) <= 1 && balancedTree(root.left) && balancedTree(root.right);
	}

	CauHoi minValue(NodeBST<CauHoi> root) {
		// initially minval = root
		CauHoi minval = root.data;
		// find minval
		while (root.left != null) {
			minval = root.left.data;
			root = root.left;
		}
		return minval;
	}

	public NodeBST<CauHoi> removeNodeRecursive(NodeBST<CauHoi> root, CauHoi key) {
		NodeBST<CauHoi> p;
		if (root == null) {
			System.out.format("%d khong co trong cay", key);
			return root;
		}

		else {
			if (key.getId() < root.data.getId())
				root.left = removeNodeRecursive(root.left, key);
			else if (key.getId() > root.data.getId())
				root.right = removeNodeRecursive(root.right, key);
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

	public void removeNode(CauHoi x) {
		root = removeNodeRecursive(root, x);
	}

//	Build Balanced Binary Search Tree
	/*
	 * This function traverse the skewed binary tree and stores its nodes pointers
	 * in vector nodes[]
	 */
	void storeBSTNodes(NodeBST<CauHoi> root, Vector<NodeBST<CauHoi>> nodes) {
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
	NodeBST<CauHoi> buildTreeUtil(Vector<NodeBST<CauHoi>> nodes, int start, int end) {
		// base case
		if (start > end)
			return null;
		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		NodeBST<CauHoi> node = nodes.get(mid);
		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		node.left = buildTreeUtil(nodes, start, mid - 1);
		node.right = buildTreeUtil(nodes, mid + 1, end);
		return node;
	}

	// This functions converts an unbalanced BST to
	// a balanced BST
	public NodeBST<CauHoi> buildTree(NodeBST<CauHoi> root) {
		// Store nodes of given BST in sorted order
		Vector<NodeBST<CauHoi>> nodes = new Vector<NodeBST<CauHoi>>();
		storeBSTNodes(root, nodes);
		// Constucts BST from nodes[]
		int n = nodes.size();
		return buildTreeUtil(nodes, 0, n - 1);
	}

	public NodeBST<CauHoi> buildTree() {
		return this.buildTree(root);
	}
}
