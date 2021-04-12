package com.cybersoft.dictionary;

public class CustomLinkedList<T> {
	public Node<T> head;

	public CustomLinkedList() {
		this.head = null;
	}

	public CustomLinkedList(Node<T> head) {
		this.head = head;
	}

	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	public void insertAtStart(T data) {
		Node<T> newNode = new Node<T>(data);

		newNode.next = head;
		head = newNode;
	}

	public void insertAt(int index, T data) {
		if (index == 0) {
			insertAtStart(data); // We already have a function to do this.
		} else {
			Node<T> newNode = new Node<T>(data);

			Node<T> currentNode = head;
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
			Node<T> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}

	public String show() {
		String res = "";
		Node<T> currentNode = head;
		if (currentNode == null) {
			return "Linked list is empty";
		} else {
			while (currentNode != null) {
				res += "\n" + currentNode.data;
				currentNode = currentNode.next;
			}

			return res;
		}
	}
}
