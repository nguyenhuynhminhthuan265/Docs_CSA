package com.cybersoft.hashtable;

import java.util.Scanner;

public class Student {
	private int id;
	private String name;

	public Student() {
		
	}

	public Student(int id, String name) {

		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void input(Scanner sc) {
		System.out.print("Ma sinh vien: ");
		this.id = Integer.parseInt(sc.nextLine());
		System.out.print("Ten sinh vien: ");
		this.name = sc.nextLine();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	

}
