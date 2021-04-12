package com.cybersoft.hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashTable {
	private static final int R = 256;
	LinkedList[] hashTable;
	int lenHashTable = 7;

	public HashTable() {
		hashTable = new LinkedList[lenHashTable];
	}

	public HashTable(int lenHashTable) {
		this.lenHashTable = lenHashTable;
		hashTable = new LinkedList[lenHashTable];
	}

	public int hash(String key) {
		int pos = 0;
		for (int j = 0; j < key.length(); j++) {
			pos = (R * pos + key.charAt(j)) % lenHashTable;
		}
		return pos;
	}

	public void init() {

		for (int i = 0; i < lenHashTable; i++)
			hashTable[i] = null;
	}

	public void initHash() throws IOException {
		List<Word> words = readFile();
		int pos;
		init();

		for (int i = 0; i < words.size(); i++) {
			insertHashTable(words.get(i));

		}

	}

	
	
	
	
	private void insertHashTable(Word word) {
		int pos;
		pos = hash(word.getWord());
		if (hashTable[pos] == null) {
			hashTable[pos] = new LinkedList();
			hashTable[pos].addTail(word);
		} else {
			hashTable[pos].addTail(word);
		}
	}

	private List<Word> readFile() throws IOException {
		String row = "";
		List<Word> words = new ArrayList<Word>();
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		BufferedReader csvReader = new BufferedReader(new FileReader(path + "/src/com/cybersoft/hashtable/raw.csv"));
		csvReader.readLine(); // this will read the first line
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
//				System.out.print(data[i] + " ");
			Word word = new Word(data[0], data[1], data[2], data[3]);
			words.add(word);

		}
		csvReader.close();
		return words;
	}

	public void print() {

		for (int i = 0; i < lenHashTable; i++) {

			System.out.format("hashTable[%d]-->", i);
			if (hashTable[i] != null) {
				Node<Word> currentNode = hashTable[i].head;
				while (currentNode != null) {
					System.out.format("%s -->", currentNode.data.getWord());
					currentNode = currentNode.next;
				}
			}

			System.out.println("NULL\n");
		}
	}

	public void Add(Word word) {

		int pos = hash(word.getWord());
		if (hashTable[pos] == null) {
			hashTable[pos] = new LinkedList();
			hashTable[pos].addTail(word);
		} else {
			hashTable[pos].addTail(word);
		}

	}

	public List<Word> Search(String word) {
		List<Word> words = new ArrayList<Word>();
		int pos = hash(word);
		if (hashTable[pos] == null) {
			System.out.println("Word not found");
			return null;
		} else {
			List<Node<Word>> nodes = hashTable[pos].findByWord(word);
			if (nodes != null && !nodes.isEmpty()) {
				for (Node<Word> nodeWord : nodes) {
					words.add(nodeWord.data);
				}

				return words;
			} else {
				System.out.println("Word not found");
				return null;
			}
		}
	}

}
