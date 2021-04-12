package com.cybersoft.hashtable;

import java.util.Scanner;

public class HashTable {
	LinkedList[] hashTableStudent;
	int lenHashTable = 7;

	public HashTable() {
		hashTableStudent = new LinkedList[lenHashTable];
	}

	public HashTable(int lenHashTable) {
		this.lenHashTable = lenHashTable;
		hashTableStudent = new LinkedList[lenHashTable];
	}

	// hàm Hash return vị trí được lưu trong hashTable
	public int hash(int key) {
		if (lenHashTable == 0)
			return 0;
		return (key % lenHashTable);
	}

	public void init() {

//		safe hash table
		for (int i = 0; i < lenHashTable; i++)
			hashTableStudent[i] = null;
	}

	public void initHash() {
		init();
		int numberStudent, pos;
		Student[] students;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong sinh vien: ");
		numberStudent = Integer.parseInt(sc.nextLine());
		students = new Student[numberStudent];
		for (int i = 0; i < students.length; i++) {
			Student student = new Student();
			student.input(sc);
			students[i] = student;
		}

		for (int i = 0; i < numberStudent; i++) {
			insertHashTable(students[i]);
		}
	}

	public void insertHashTable(Student student) {
		int pos;
		pos = hash(student.getId());
		if (hashTableStudent[pos] == null) {
			hashTableStudent[pos] = new LinkedList();
			hashTableStudent[pos].addTail(student);
		} else {
			hashTableStudent[pos].addTail(student);
		}
	}

	public Student searchStudentByMSSV(int mssv) {

		int pos = hash(mssv);
		if (hashTableStudent[pos] == null) {
			return null;
		} else {
			Node<Student> node = hashTableStudent[pos].findByMSSV(mssv);
			if (node != null) {
				return node.data;
			} else {

				return null;
			}
		}
	}

	public void print() {

		for (int i = 0; i < lenHashTable; i++) {

			System.out.format("hashTableStudent[%d]-->", i);
			if (hashTableStudent[i] != null) {
				Node<Student> currentNode = hashTableStudent[i].head;
				while (currentNode != null) {
					System.out.format("%d -->", currentNode.data.getId());
					currentNode = currentNode.next;
				}
			}

			System.out.println("NULL\n");
		}
	}

}
