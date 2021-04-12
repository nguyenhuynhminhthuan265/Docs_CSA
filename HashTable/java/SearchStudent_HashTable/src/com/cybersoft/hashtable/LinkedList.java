package com.cybersoft.hashtable;

public class LinkedList {
	Node<Student> head;

	public LinkedList() {
		this.head = null;
	}

	public LinkedList(Node<Student> head) {

		this.head = head;
	}

	
	
	
	
	public void addTail(Student data) {
		Node<Student> newNode = new Node<Student>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<Student> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	public void addHead(Student data) {
		Node<Student> newNode = new Node<Student>(data);

		newNode.next = head;
		head = newNode;
	}

	
	
	
	
	
	public void insertAt(int index, Student data) {
		if (index == 0) {
			addHead(data);
		} else {
			Node<Student> newNode = new Node<Student>(data);

			Node<Student> currentNode = head;
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
			Node<Student> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}

	public void show() {
		Node<Student> currentNode = head;
		if (currentNode == null) {
			System.out.println("Linked list is empty");
		} else {
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
		}
	}

	public Node<Student> findByMSSV(int mssv) {
		Node<Student> currentNode = head;
		if (currentNode == null) {
			return null;
		} else {
			while (currentNode != null) {
				if (currentNode.data.getId() == mssv) {
					return currentNode;
				}
				currentNode = currentNode.next;
			}

			return null;
		}
	}

	
	
	
	
//	public static void main(String[] args) {
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		list.addTail(12); // 12
//		list.addTail(43); // 12 43
//		list.addHead(191); // 191 12 43
//		list.insertAt(2, 2222); // 191 12 2222 43
//		list.deleteAt(2); // 191 12 43
//		list.show();
//	}
}
