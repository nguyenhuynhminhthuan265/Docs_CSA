package com.cybersoft.stack.excersies;
/*
 * Mô phỏng lại chương trình Ctrl + Z
 * Nhập 1 dãy String: 
 * Vd: Cybersoft
 * Sau đó delete các ký tự (chỉ delete các ký tự cuối chuỗi)
 * Dùng các option từ bàn phím để mô phỏng lại phím Ctrl + Z (vd: ấn 1 -> Ctrl + Z)
 * 
 * */

import java.util.Scanner;


public class Bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Step 1: Tạo 1 Stack để lưu các ký tự vừa nhập
		MyStack<Character> stackWords = new MyStack<Character>();

//		Step 2: Tạo 1 Stack lưu lại các ký tự đã xóa 
		MyStack<Character> stackWordsDeleted = new MyStack<Character>();

//		Step 3: Gõ một đoạn text
		System.out.print("Text: ");
		String line = sc.nextLine();
		char[] characters = line.toCharArray();
		for (char c : characters) {
			stackWords.push(c);
		}

//		0 : Delete
//		1: Ctrl + Z
		System.out.println("0: Delete\t1: Ctrl + Z");
		int option;
		do {
			System.out.print("option: ");
			option = Integer.parseInt(sc.nextLine());
			if (option != 1 && option != 0) {
				break;
			}
			switch (option) {
			case 0:
//				 kiểm tra xem trong stack còn ký tự để xóa không
//				===> còn thì tiếp tục xóa
//				===> hết thì chỉ cần in lại chuỗi ""
				if (!stackWords.isEmpty()) {
					stackWordsDeleted.push(stackWords.pop());
				}
				System.out.println(convertStackCharToString(stackWords));
				break;
			case 1:
//				 kiểm tra xem trong stack các ký tự đã xóa còn trống không
//				===> còn thì tiếp tục Ctrl + Z
//				===> hết thì chỉ cần in lại chuỗi ban đầu
				if (!stackWordsDeleted.isEmpty()) {
					stackWords.push(stackWordsDeleted.pop());
				}
				System.out.println(convertStackCharToString(stackWords));
				break;

			}
		} while (option == 0 || option == 1);
	}

	public static String convertStackCharToString(MyStack<Character> stack) {
		MyStack<String> reverseStack = new MyStack<String>();
		MyStack<Character> object = stack;
		String result = "";
		while (!object.isEmpty()) {
			reverseStack.push(object.pop().toString());

		}

		while (!reverseStack.isEmpty()) {
			result += reverseStack.pop();

		}

		return result;

	}

}
