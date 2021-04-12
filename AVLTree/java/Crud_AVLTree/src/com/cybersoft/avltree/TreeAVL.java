package com.cybersoft.avltree;

public class TreeAVL {
	AVLNode root;

	public TreeAVL() {

	}

	public TreeAVL(AVLNode root) {
		this.root = root;
	}


	public AVLNode find(int key) {
		AVLNode current = root;
		while (current != null) {
			if (current.key == key) {
				break;
			}
			current = current.key < key ? current.right : current.left;
		}
		return current;
	}

	public void insert(int key) {
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
    int height(AVLNode N) {
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
    AVLNode rightRotate(AVLNode y) {
    	AVLNode x = y.left;
    	AVLNode T2 = x.right;
 
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
    AVLNode leftRotate(AVLNode x) {
    	AVLNode y = x.right;
    	AVLNode T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    AVLNode insert(AVLNode node, int key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new AVLNode(key));
 
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 
	public void TraverseRecursive(AVLNode t) {
		if (t != null) {

			System.out.format("Khoa: %d, can bang: %d\n", t.key, t.height);
			TraverseRecursive(t.left);
			TraverseRecursive(t.right);
		}
	}

	public void Traverse() {
		TraverseRecursive(root);
	}
}
