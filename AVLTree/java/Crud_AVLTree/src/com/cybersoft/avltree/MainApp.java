package com.cybersoft.avltree;

public class MainApp {
	public static void main(String[] args) {
		
		TreeAVL treeAVL = new TreeAVL();
		int arr[] = { 50, 20, 30, 10, -5, 7, 15, 35, 57, 65, 55, -1 };
		int arr1[] = { 10, 20, 30, 40, 50, 25 };
		int arr2[] = { 40, 20, 30, 60, 50, 10 };
		for (int i = 0; i < arr1.length; i++) {
			treeAVL.insert(arr1[i]);
		}

		treeAVL.Traverse();
		System.out.println(treeAVL.root.key);
	}
}
