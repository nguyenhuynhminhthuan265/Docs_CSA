package com.cybersoft.hashtable;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		HashTable hashTable = new HashTable();
		Scanner sc = new Scanner(System.in);
		hashTable.initHash();
		hashTable.print();
		System.out.print("Find Word: ");
		System.out.println(hashTable.Search(sc.nextLine()));
	}
}
