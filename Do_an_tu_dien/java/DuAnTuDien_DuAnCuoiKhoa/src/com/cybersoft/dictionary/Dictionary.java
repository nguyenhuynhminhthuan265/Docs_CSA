package com.cybersoft.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Dictionary {
	CustomDoubleLinkedList<Word> dictionary;
	boolean flag = false;

	public Dictionary() throws IOException {
		dictionary = new CustomDoubleLinkedList<Word>();
		readFile();
	}

	public void xuLyTuDien(Scanner sc) {
		int option;
		option = Integer.parseInt(sc.nextLine());
		System.out.println("1: Nhap tu moi");
		System.out.println("2: Hieu chinh tu");
		System.out.println("3: Xoa tu");
		System.out.println("4: Tra tu");
		System.out.println("5: Thoat");

		switch (option) {
		case 1:
			Word word = new Word();
			word.input(sc);
			dictionary.insertAtTail(word);
			flag = true;
			break;

		case 2:
			System.out.println("Tu ban muon chinh sua: ");
			String tempWord = sc.nextLine();
			Word wordEdit = this.search(tempWord);
			System.out.print(wordEdit.toString());
			if (wordEdit != null) {
				String temp = "";
				System.out.print("Sua loai tu (" + wordEdit.getType() + "): ");
				temp = sc.nextLine();
				if (temp == "")
					return;
				wordEdit.setType(temp);
			}
			for (int i = 0; i < Word.MAX_LENGTH_MEANING; i++) {
				String temp = "";
				System.out.print("Sua nghia " + (i + 1) + " (" + wordEdit.getMeanings()[i] + "): ");
				temp = sc.nextLine();
				if (temp == "")
					break;
				wordEdit.getMeanings()[i] = temp;
			}
			int count = 0;
			
			
			
			flag = true;
			break;

		case 3:

			break;

		case 4:

			break;

		default:
			break;
		}
	}

	public void readFile() throws IOException {
		String row = "";
//		List<Word> words = new ArrayList<Word>();
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(path + "/src/com/cybersoft/dictionary/words.txt"));

		while ((row = bufferedReader.readLine()) != null) {
			if (row.isEmpty()) {
				continue;
			}
			String[] data = row.split("/");
			Word word = new Word(data[0], data[1]);

			String[] meanings = new String[Word.MAX_LENGTH_MEANING];
			String[] tempMeanings = data[2].split(";");
			for (int i = 0; i < tempMeanings.length; i++) {
				meanings[i] = tempMeanings[i];
			}
			word.setMeanings(meanings);
			CustomLinkedList<String> customLinkedList = new CustomLinkedList<String>();
			if (data[3].split(";").length > 0) {
				String[] examples = data[3].split(";");
				for (int i = 0; i < examples.length; i++) {
					customLinkedList.insert(examples[i]);
				}
			}
			word.setExamples(customLinkedList);

			dictionary.insertAtTail(word);

		}
		bufferedReader.close();

	}

	public Word search(String key) {

		if (dictionary.head == null) {
			return null;
		}
		NodeDouble<Word> current = dictionary.head;
		while (current != null) {

			if (current.data.getWord().trim().toLowerCase().equals(key.trim().toLowerCase())) {
				return current.data;
			}

			current = current.next;
		}
		return null;
	}
}
