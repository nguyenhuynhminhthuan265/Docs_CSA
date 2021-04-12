package com.cybersoft.node.generic;

public abstract class CustomLinkedList<T> {
	public Node<T> head;

	public CustomLinkedList() {
		this.head = null;
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

	public void show() {
		Node<T> currentNode = head;
		if (currentNode == null) {
			System.out.println("Lop chua co sinh vien");
		} else {
			while (currentNode != null) {
				System.out.println(currentNode.data + " ");
				currentNode = currentNode.next;
			}
		}
	}
	
	public void show(String message) {
		Node<T> currentNode = head;
		if (currentNode == null) {
			System.out.println(message);
		} else {
			while (currentNode != null) {
				System.out.println(currentNode.data + " ");
				currentNode = currentNode.next;
			}
		}
	}
}
