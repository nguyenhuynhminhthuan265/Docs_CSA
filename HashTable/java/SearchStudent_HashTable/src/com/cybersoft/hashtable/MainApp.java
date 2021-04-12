package com.cybersoft.hashtable;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		int mssv;
		HashTable hashTable = new HashTable();
		Scanner sc = new Scanner(System.in);
		
		hashTable.initHash();
		hashTable.print();

		System.out.print("MSSV cần tìm kiếm: ");
		mssv = Integer.parseInt(sc.nextLine());

		Student student = hashTable.searchStudentByMSSV(mssv);
		if (student == null) {
			System.out.println("Sinh viên không tồn tại");
		} else {
			System.out.println("Sinh viên có tồn tại");
			System.out.println(student.toString());
		}

	}

}
