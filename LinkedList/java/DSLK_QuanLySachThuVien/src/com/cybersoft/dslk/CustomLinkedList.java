package com.cybersoft.dslk;

public class CustomLinkedList {
	public Node<Sach> head;

	public CustomLinkedList() {
		this.head = null;
	}

	public CustomLinkedList(Node<Sach> head) {
		this.head = head;
	}

	public void insert(Sach data) {
		Node<Sach> newNode = new Node<Sach>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<Sach> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	public void insertAtStart(Sach data) {
		Node<Sach> newNode = new Node<Sach>(data);

		newNode.next = head;
		head = newNode;
	}

	public void insertAt(int index, Sach data) {
		if (index == 0) {
			insertAtStart(data); // We already have a function to do this.
		} else {
			Node<Sach> newNode = new Node<Sach>(data);

			Node<Sach> currentNode = head;
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
			Node<Sach> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}

	public void show() {
		Node<Sach> currentNode = head;
		if (currentNode == null) {
			System.out.println("Linked list is empty");
		} else {
			while (currentNode != null) {
				System.out.println(currentNode.data + " ");
				currentNode = currentNode.next;
			}
		}
	}
}
