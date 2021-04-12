package com.cybersoft.dictionary;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Dictionary dictionary = new Dictionary();

		System.out.println("Tu ban muon chinh sua: ");
		String tempWord = sc.nextLine();
		Word wordEdit = dictionary.search(tempWord);
		System.out.print(wordEdit.toString());
		if (wordEdit != null) {
			String temp = "";
			System.out.print("Sua loai tu (" + wordEdit.getType() + "): ");
			temp = sc.nextLine();
			if (temp.equals(""))
				return;
			wordEdit.setType(temp);
		}
		for (int i = 0; i < Word.MAX_LENGTH_MEANING; i++) {
			String temp = "";
			System.out.print("Sua nghia " + (i + 1) + " (" + wordEdit.getMeanings()[i] + "): ");
			temp = sc.nextLine();
			if (temp.equals(""))
				break;
			wordEdit.getMeanings()[i] = temp;
		}
		

		dictionary.dictionary.print();
	}

}
