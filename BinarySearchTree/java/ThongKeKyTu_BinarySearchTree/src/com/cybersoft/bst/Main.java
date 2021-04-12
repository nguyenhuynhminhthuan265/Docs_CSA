package com.cybersoft.bst;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char character;
		String data;
		System.out.print("Nhap vao du lieu: ");
		data = sc.nextLine();
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.CreateTree(data);

		binarySearchTree.CountEachCharOfParagraph(binarySearchTree.root, binarySearchTree.ChuanHoaMang(data));
		System.out.println("Nhap ky tu can kiem tra: ");
		character = sc.next().charAt(0);
		System.out.println(character + ": " + binarySearchTree.countCharOfParagraph(binarySearchTree.root, character));

	}

}
