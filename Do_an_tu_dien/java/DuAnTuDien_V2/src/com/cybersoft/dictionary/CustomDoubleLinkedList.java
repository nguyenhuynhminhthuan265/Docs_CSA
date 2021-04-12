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
		NodeDouble<T> current = head;
		if (current != null) {
			if (current.next != null) {
				head = head.next;
				head.prev = null;
			}

		}
	}

	public void deleteTail() {
		NodeDouble<T> current = tail;
		if (tail != null) {
			tail = current.prev;
			current.prev = null;
			tail.next = null;
		}
	}

	public void deleteAt(int position) {
		NodeDouble<T> current = head;
		if (position == 0) {
			this.deleteHead();
		}
		for (int i = 0; i < position; i++) {
			current = current.next;
			if (current != null) {
				if (current.next != null) {
					current.next.prev = current.prev;
				}
				if (current.prev != null) {
					current.prev.next = current.next;
				}

			}
		}
	}

	public void print() {

		NodeDouble<T> current = head;
		if (head == null) {
			System.out.println("Tu dien trong");
			return;
		}
		int count = 0;
		System.out.println("Tu dien: ");
		while (current != null) {

			System.out.println(current.data);
			++count;
			current = current.next;
		}
		
		System.out.println(count);
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
