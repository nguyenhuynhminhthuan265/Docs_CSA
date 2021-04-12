package com.cybersoft.hashtable.chaining;

import java.util.Random;
import java.util.Scanner;

public class HashTable {
	LinkedList[] hashTable;
	int lenHashTable = 7;

	public HashTable() {
		hashTable = new LinkedList[lenHashTable];
	}

	// hàm Hash return vị trí được lưu trong hashTable
	public int hash(int key, int lenHashTable) {
		this.lenHashTable = lenHashTable;
		if (lenHashTable == 0)
			return 0;
		return (key % lenHashTable);
	}

	// hàm Hash return vị trí được lưu trong hashTable
	public int hash(int key) {
		if (lenHashTable == 0)
			return 0;
		return (key % lenHashTable);
	}

	public void init() {

//		safe hash table
		for (int i = 0; i < lenHashTable; i++)
			hashTable[i] = null;
	}

	public void initHash() {
		int lenArrays, pos;
		Integer[] arrays;
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong mang: ");
		lenArrays = Integer.parseInt(sc.nextLine());
		arrays = new Integer[lenArrays];
		for (int i = 0; i < arrays.length; i++) {
//			Random integer
			arrays[i] = random.ints(1, 10).findFirst().getAsInt();
		}

		init();

		for (int i = 0; i < lenArrays; i++) {
			pos = hash(arrays[i], lenHashTable);
			if (hashTable[pos] == null) {
				hashTable[pos] = new LinkedList();
				hashTable[pos].addTail(arrays[i]);
			} else {
				hashTable[pos].addTail(arrays[i]);
			}

		}

	}

	public void print() {

		for (int i = 0; i < lenHashTable; i++) {

			System.out.format("hashTableStudent[%d]-->", i);
			if (hashTable[i] != null) {
				Node<Integer> currentNode = hashTable[i].head;
				while (currentNode != null) {
					System.out.format("%d -->", currentNode.data);
					currentNode = currentNode.next;
				}
			}

			System.out.println("NULL\n");
		}
	}

}
