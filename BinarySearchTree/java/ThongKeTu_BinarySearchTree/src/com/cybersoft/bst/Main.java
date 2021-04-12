package com.cybersoft.bst;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		String check = "div   thuan minh  tuan      lon   thuan minh       ";
		binarySearchTree.CreateTree(check);
		binarySearchTree.CountEachStringOfParagraph(binarySearchTree.root, check);

	}

}
