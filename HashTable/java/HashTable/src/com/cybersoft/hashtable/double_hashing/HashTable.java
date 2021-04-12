package com.cybersoft.hashtable.double_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTable {
	Integer[] hashTable;
	int lenHashTable = 13;
	final static int PRIME = 7;

	public HashTable() {
		hashTable = new Integer[lenHashTable];
	}

	// hàm Hash return vị trí được lưu trong hashTable
	public int hash1(int key) {
		if (lenHashTable == 0)
			return 0;
		return (key % lenHashTable);
	}

	// function to calculate second hash
	public int hash2(int key) {
		return (PRIME - (key % PRIME));
	}

	public void init() {

		// safe hash table
		for (int i = 0; i < lenHashTable; i++)
			hashTable[i] = null;
	}

	public void initHash() {
		List<Integer> arrays = new ArrayList<Integer>();
		arrays.addAll(Arrays.asList(19, 27, 36, 10, 64));

		init();

		for (int i = 0; i < arrays.size(); i++) {
			insert(arrays.get(i));
		}

	}

	void insert(int key) {

		int pos1 = hash1(key);
		int pos2 = hash2(key);

		while (hashTable[pos1] != null)
			pos1 = (pos1 + pos2) % lenHashTable;
		hashTable[pos1] = key;
	}

	void search(int key) {
		int pos1 = hash1(key);
		int pos2 = hash2(key);
		while (hashTable[pos1] != null)
			pos1 = (pos1 + pos2) % lenHashTable;

		if (hashTable[pos1] == key)
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
