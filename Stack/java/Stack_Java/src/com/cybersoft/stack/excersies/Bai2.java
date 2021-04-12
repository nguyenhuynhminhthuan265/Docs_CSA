package com.cybersoft.stack.excersies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Tương tự bài 1 nhưng delete các ký tự bất kỳ trong chuỗi
 *
 * */
public class Bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Step 1: Tạo 1 List để lưu các ký tự vừa nhập
		List<Character> characterList = new ArrayList<>();

//		Step 2: Tạo 1 Stack lưu lại các ký tự đã xóa
		MyStack<MyCharacter> stackWordsDeleted = new MyStack<MyCharacter>();

//		Step 3: Gõ một đoạn text
		System.out.print("Text: ");
		String line = sc.nextLine();
		char[] characters = line.toCharArray();
		for (char c : characters) {
			characterList.add(c);
		}

		
		
		
		
//		0 : Delete
//		1: Ctrl + Z
		System.out.println("0: Delete\t1: Ctrl + Z");
		int option, indexWord;
		do {
			System.out.print("option: ");
			option = Integer.parseInt(sc.nextLine());
			if (option != 1 && option != 0) {
				break;
			}

			switch (option) {
			case 0:
				System.out.print("Vị trí ký tự muốn xóa: ");
				indexWord = Integer.parseInt(sc.nextLine());
//				 kiểm tra xem trong stack còn ký tự để xóa không
//				===> còn thì tiếp tục xóa
//				===> hết thì chỉ cần in lại chuỗi ""
				if (!characterList.isEmpty()) {
					stackWordsDeleted.push(new MyCharacter(characterList.get(indexWord), indexWord));
					characterList.remove(indexWord);
				}
				System.out.println(convertListCharToString(characterList));
				break;
			case 1:
//				 kiểm tra xem trong stack các ký tự đã xóa còn trống không
//				===> còn thì tiếp tục Ctrl + Z
//				===> hết thì chỉ cần in lại chuỗi ban đầu
				if (!stackWordsDeleted.isEmpty()) {
					characterList.add(stackWordsDeleted.peek().getIndex(), stackWordsDeleted.pop().getCharacter());
				}
				System.out.println(convertListCharToString(characterList));
				break;

			}
		} while (option == 0 || option == 1);
	}

	public static String convertListCharToString(List<Character> characters) {
		String res = "";
		for (Character character : characters) {
			res += character;
		}

		return res;
	}
}
