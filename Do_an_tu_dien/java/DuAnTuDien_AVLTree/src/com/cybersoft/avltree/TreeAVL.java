package com.cybersoft.avltree;

public class TreeAVL {
	AVLNode<Word> root;
	public int count = 0;

	public TreeAVL() {

	}

	public TreeAVL(AVLNode<Word> root) {
		this.root = root;
	}

	public AVLNode<Word> find(String key) {
		return this.searchRecursive(root, key);
	}

	public AVLNode<Word> searchRecursive(AVLNode<Word> root, String key) {
		if (root.key.getWord().trim().toLowerCase().contains(key.trim().toLowerCase())) {
			return root;
		}
		if (key.compareTo(root.key.getWord()) < 0) {
			return searchRecursive(root.left, key);
		}
		if (key.compareTo(root.key.getWord()) > 0) {
			return searchRecursive(root.right, key);
		}

		return null;

	}

	public void insert(Word key) {
		root = insert(root, key);
	}

//	public void delete(int key) {
//		root = delete(root, key);
//	}
//
//	public AVLNode getRoot() {
//		return root;
//	}
//
//	public int height() {
//		return root == null ? 0 : root.height;
//	}
//
//	private AVLNode insert(AVLNode node, int key) {
//		if (node == null) {
//			return new AVLNode(key);
//		} else if (key < node.key) {
//			node.left = insert(node.left, key);
//		} else if (key > node.key) {
//			node.right = insert(node.right, key);
//		} else {
//			return node;
//		}
//		return rebalance(node, key);
//	}
//
//	private AVLNode delete(AVLNode node, int key) {
//		if (node == null) {
//			return node;
//		} else if (node.key > key) {
//			node.left = delete(node.left, key);
//		} else if (node.key < key) {
//			node.right = delete(node.right, key);
//		} else {
//			if (node.left == null || node.right == null) {
//				node = (node.left == null) ? node.right : node.left;
//			} else {
//				AVLNode mostLeftChild = mostLeftChild(node.right);
//				node.key = mostLeftChild.key;
//				node.right = delete(node.right, node.key);
//			}
//		}
//		if (node != null) {
////			node = rebalance(node);
//		}
//		return node;
//	}
//
//	private AVLNode mostLeftChild(AVLNode node) {
//		AVLNode current = node;
//		/* loop down to find the leftmost leaf */
//		while (current.left != null) {
//			current = current.left;
//		}
//		return current;
//	}
//
//	public AVLNode rebalance(AVLNode node, int key) {
//		node.height = updateHeight(node);
//		int balance = getBalance(node);
//		// Left left case
//		if (balance > 1 && key < node.left.key) {
//			return rotateRight(node);
//		}
//
//		// Right right Case
//		if (balance < -1 && key > node.right.key) {
//			return rotateLeft(node);
//		}
//
//		// Left Right Case
//		if (balance > 1 && key > node.left.key) {
//			node.left = rotateLeft(node.left);
//			return rotateRight(node);
//		}
//
//		// Right Left Case
//		if (balance < -1 && key > node.right.key) {
//			node.right = rotateRight(node.right);
//			return rotateLeft(node);
//		}
//
//		return node;
//	}
//
//	private AVLNode rotateRight(AVLNode rotateNode) {
////		 y 
////		/ \ 
////		x T3 
////	   / \ 
////	  T1 T2
//
//		AVLNode x = rotateNode.left;
//		AVLNode T2 = x.right;
//
//		// ROTATE
//		x.right = rotateNode;
//		rotateNode.left = T2;
//
//		// UPDATE HEIGHT
//		rotateNode.height = 1 + max(height(rotateNode.left), height(rotateNode.right));
//		x.height = 1 + max(height(x.left), height(x.right));
//		return x;
//	}
//
//	private AVLNode rotateLeft(AVLNode y) {
//
////		 y 
////		/ \ 
////		T3 x 
////		  / \ 
////	      T2 T1
//
//		AVLNode x = y.right;
//		AVLNode T2 = x.left;
//
//		// ROTATE
//		x.left = y;
//		y.right = T2;
//
//		// UPDATE HEIGHT
//		y.height = 1 + max(height(y.left), height(y.right));
//		x.height = 1 + max(height(x.left), height(x.right));
//		return x;
//	}
//
//	private int updateHeight(AVLNode n) {
//
//		return (1 + max(height(n.left), height(n.right)));
//
//	}
//
//	private int height(AVLNode n) {
//		return n == null ? 0 : n.height;
//	}
//
//	public int getBalance(AVLNode node) {
//		if (node == null)
//			return 0;
//		return height(node.left) - height(node.right);
//	}
	// A utility function to get the height of the tree
	int height(AVLNode<Word> N) {
		if (N == null)
			return 0;

		return N.height;
	}

	// A utility function to get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	AVLNode<Word> rightRotate(AVLNode<Word> y) {
		AVLNode<Word> x = y.left;
		AVLNode<Word> T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	AVLNode<Word> leftRotate(AVLNode<Word> x) {
		AVLNode<Word> y = x.right;
		AVLNode<Word> T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	int getBalance(AVLNode<Word> N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

	AVLNode<Word> insert(AVLNode<Word> node, Word key) {

		/* 1. Perform the normal BST insertion */
		if (node == null) {
			++count;
			return (new AVLNode<Word>(key));
		}

		if (key.getWord().compareTo(node.key.getWord()) < 0)
			node.left = insert(node.left, key);
		else if (key.getWord().compareTo(node.key.getWord()) > 0)
			node.right = insert(node.right, key);
		else {
			// Duplicate keys not allowed
			node.existNode.add(key);
			++count;
			return node;
		}

		node.height = 1 + max(height(node.left), height(node.right));

		int balance = getBalance(node);

		// Left Left Case
		if (balance > 1 && key.getWord().compareTo(node.left.key.getWord()) < 0)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key.getWord().compareTo(node.right.key.getWord()) > 0)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key.getWord().compareTo(node.left.key.getWord()) > 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key.getWord().compareTo(node.right.key.getWord()) < 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void TraverseRecursive(AVLNode<Word> t) {
		if (t != null) {

			System.out.format("Khoa: %s, can bang: %d\n", t.key.getWord(), t.height);
			TraverseRecursive(t.left);
			TraverseRecursive(t.right);
		}
	}

	public void Traverse() {
		TraverseRecursive(root);
	}
}
