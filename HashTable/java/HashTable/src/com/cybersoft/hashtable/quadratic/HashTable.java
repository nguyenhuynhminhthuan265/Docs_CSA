package com.cybersoft.hashtable.quadratic;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	Integer[] hashTable;
	int lenHashTable = 7;

	public HashTable() {
		hashTable = new Integer[lenHashTable];
	}

	// hàm Hash return vị trí được lưu trong hashTable
	public int hash(int key) {
		if (lenHashTable == 0)
			return 0;
		return (key % lenHashTable);
	}

	public void init() {

		// safe hash table
		for (int i = 0; i < lenHashTable; i++)
			hashTable[i] = null;
	}

	public void initHash() {
		List<Integer> arrays = new ArrayList<Integer>();
		arrays.add(76);
		arrays.add(93);
		arrays.add(40);
		arrays.add(47);
		arrays.add(10);
		arrays.add(55);

		init();

		for (int i = 0; i < arrays.size(); i++) {
			insert(arrays.get(i));
		}

	}

	void insert(int integer) {
		int index = 1;
		int pos = hash(integer);
		while (hashTable[pos] != null) {
			pos = (pos + index * index) % lenHashTable;
			index++;
		}

		hashTable[pos] = integer;
	}

	void search(int key) {
		int pos = hash(key);
		int index = 1;
		while (hashTable[pos] != key && hashTable[pos] != null) {
			pos = (pos + index * index) % lenHashTable;
			index++;
		}

		if (hashTable[pos] == key)
			System.out.println("Tim thay");
		else
			System.out.println("Not found!!!");
	}

	public void print() {

		for (int i = 0; i < lenHashTable; i++) {

			System.out.format("hashTableStudent[%d]-->", i);
			if (hashTable[i] != null) {
				System.out.format("%d", hashTable[i]);
			}

			System.out.println("\n");
		}
	}
}
