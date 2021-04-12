package com.cybersoft.hashtable;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
	Node<Word> head;

	public LinkedList() {
		this.head = null;
	}

	public LinkedList(Node<Word> head) {

		this.head = head;
	}

	public void addTail(Word data) {
		Node<Word> newNode = new Node<Word>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<Word> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	public void addHead(Word data) {
		Node<Word> newNode = new Node<Word>(data);

		newNode.next = head;
		head = newNode;
	}

	public void insertAt(int index, Word data) {
		if (index == 0) {
			addHead(data);
		} else {
			Node<Word> newNode = new Node<Word>(data);

			Node<Word> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}

	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node<Word> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}

	public void show() {
		Node<Word> currentNode = head;
		if (currentNode == null) {
			System.out.println("Linked list is empty");
		} else {
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
		}
	}

	public List<Node<Word>> findByWord(String word) {
		List<Node<Word>> words = new ArrayList<Node<Word>>();
		Node<Word> currentNode = head;
		if (currentNode == null) {
			return null;
		} else {
			while (currentNode != null) {
				if (currentNode.data.getWord().equals(word)) {
					words.add(currentNode);
//					return currentNode;
				}
				currentNode = currentNode.next;
			}

			return words;
		}
	}

}
