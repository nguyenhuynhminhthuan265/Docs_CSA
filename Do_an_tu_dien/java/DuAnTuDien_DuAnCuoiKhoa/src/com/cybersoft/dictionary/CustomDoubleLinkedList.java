package com.cybersoft.dictionary;

public class CustomDoubleLinkedList<T> {
	public NodeDouble<T> head;
	public NodeDouble<T> tail;

	public CustomDoubleLinkedList() {
		this.head = this.tail = null;
	}

	public CustomDoubleLinkedList(NodeDouble<T> head, NodeDouble<T> tail) {

		this.head = head;
		this.tail = tail;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void insertHead(T data) {
		NodeDouble<T> newNode = new NodeDouble<T>(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			// create connect 2 node
			head.prev = newNode;
			newNode.next = head;

			head = newNode;
		}
	}

	public void insertAtTail(T data) {
		NodeDouble<T> newNode = new NodeDouble<T>(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			// create connect 2 node
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void insertAt(int position, T data) {

	}

	public void deleteHead() {

	}

	public void deleteTail() {

	}

	public void deleteAt(int position) {

	}

	public void print() {

		NodeDouble<T> current = head;
		if (head == null) {
			System.out.println("Tu dien trong");
			return;
		}
		System.out.println("Tu dien: ");
		while (current != null) {

			System.out.println(current.data);
			current = current.next;
		}
	}

	public T search(T data) {

		NodeDouble<T> current = head;
		if (head == null) {
			return null;
		}
		while (current != null) {

			if (current.data == data) {
				return current.data;
			}

			current = current.next;
		}
		return null;
	}
}
