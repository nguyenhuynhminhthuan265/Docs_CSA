package com.cybersoft.bst;

public class Main {
	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.CreateTreeDemo();
//		binarySearchTree.buildTree(binarySearchTree.root);
		binarySearchTree.LNR(binarySearchTree.root); // 25 15 10 4 12 22 18 24 50 35 31 44 70 66 90

//		System.out.println("\nThe BST after Delete 12(leaf node):");
//		binarySearchTree.removeNode(12);
//		binarySearchTree.LNR(binarySearchTree.root);
//
//		// delete the node with one child
//		System.out.println("\nThe BST after Delete 10 (node with 1 child):");
//		binarySearchTree.removeNode(10);
//		binarySearchTree.LNR(binarySearchTree.root);
//
//		// delete node with two children
//		System.out.println("\nThe BST after Delete 25 (Node with two children):");
//		binarySearchTree.removeNode(25);
//		binarySearchTree.LNR(binarySearchTree.root);

//		System.out.println("\n==Thu them phan tu 15 vao BTS==");
//		binarySearchTree.insert(15);
//		binarySearchTree.LNR(binarySearchTree.root);
//
//		
//
//		System.out.println("\n==Thu xoa phan tu 50 khoi BTS==");
//		binarySearchTree.removeNode(50);
//		binarySearchTree.LNR(binarySearchTree.root);// 25 15 10 4 12 22 18 24 66 35 31 44 70 90

		System.out.println(binarySearchTree.search(15) ? "\nTRUE" : "\nNot found");
		binarySearchTree.LNR(binarySearchTree.root);
		System.out.format("Chieu cao cua nut %d : %d\n", 15, binarySearchTree.Height(binarySearchTree.root));
		binarySearchTree.LNR(binarySearchTree.root);
		if (binarySearchTree.balancedTree(binarySearchTree.root) == false) {
			System.out.println("Khong phai cay can bang.\n");
		} else
			System.out.println("Cay can bang.\n");

	}
}
