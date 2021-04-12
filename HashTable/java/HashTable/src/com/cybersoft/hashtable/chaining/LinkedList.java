package com.cybersoft.hashtable.chaining;

public class LinkedList {
	Node<Integer> head;

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	public LinkedList(Node<Integer> head) {

		this.head = head;
	}

	public void addTail(Integer data) {
		Node<Integer> newNode = new Node<Integer>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<Integer> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	public void addHead(Integer data) {
		Node<Integer> newNode = new Node<Integer>(data);

		newNode.next = head;
		head = newNode;
	}

	public void insertAt(int index, Integer data) {
		if (index == 0) {
			addHead(data); // We already have a function to do this.
		} else {
			Node<Integer> newNode = new Node<Integer>(data);

			Node<Integer> currentNode = head;
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
			Node<Integer> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}

	public void show() {
		Node<Integer> currentNode = head;
		if (currentNode == null) {
			System.out.println("Linked list is empty");
		} else {
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
		}
	}

}
