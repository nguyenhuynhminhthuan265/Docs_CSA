package com.cybersoft.avltree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Dictionary {
	TreeAVL dictionary;
	boolean flag = false;
	int count = 0;

	public Dictionary() throws IOException {
		dictionary = new TreeAVL();
		readFile();
	}

	public void xuLyTuDien(Scanner sc) {
		int option;
		String tempWord;
		do {
			System.out.println("1: Nhap tu moi");
			System.out.println("2: Hieu chinh tu");
			System.out.println("3: Xoa tu");
			System.out.println("4: Tra tu");
			System.out.println("5: Thoat");
			option = Integer.parseInt(sc.nextLine());

			switch (option) {
			case 1:
				Word word = new Word();
				word.input(sc);
				dictionary.insert(word);
				flag = true;
				break;

			case 2:
				System.out.println("Tu ban muon chinh sua: ");
				tempWord = sc.nextLine();
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
				for (int i = 0; i < wordEdit.getMeanings().size(); i++) {
					String temp = "";
					System.out.print("Sua nghia " + (i + 1) + " (" + wordEdit.getMeanings().get(i) + "): ");
					temp = sc.nextLine();
					if (temp == "")
						break;
					wordEdit.getMeanings().set(i, temp);
				}
				int count = 0;

				flag = true;
				break;

			case 3:
				System.out.println("Tu ban muon chinh xoa: ");
				tempWord = sc.nextLine();
//				int indexWordDelete = this.searchDelete(tempWord);
//				dictionary.(indexWordDelete);
				break;

			case 4:
				long startTime = System.nanoTime();
				System.out.print("Nhap tu ban muon tra (Eng): ");
				tempWord = sc.nextLine();
				Word res = this.search(tempWord);
				if (res != null) {
					System.out.println(res.toString());
				} else {
					System.out.println("Khong ton tai");
				}

				long endTime = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.print("totalTime: " + totalTime);
				break;
			case 5:

				break;
			default:
				break;
			}
		} while (option != 5);
	}

	public void readFile() throws IOException {
		boolean flag = true;
		String line = "";
		String nextLine = "";

		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(path + "/src/com/cybersoft/avltree/data.EV.txt"));
		BufferedReader bufferedReaderNextLine = new BufferedReader(
				new FileReader(path + "/src/com/cybersoft/avltree/data.EV.txt"));

		nextLine = bufferedReaderNextLine.readLine();
		Word word = new Word();
		while ((line = bufferedReader.readLine()) != null) {
			nextLine = bufferedReaderNextLine.readLine();
			if (line.isEmpty()) {
				continue;
			}

			String key = String.valueOf(line.charAt(0));
			switch (key) {
			case "@":
				word.setWord(line.replaceFirst("@", ""));
				flag = false;
				
				break;
			case "*":
				word.setType(line.replaceFirst("\\*", ""));
				flag = false;
				break;
			case "-":
				word.getMeanings().add(line.replaceFirst("-", ""));
				if (nextLine != null) {
					if (nextLine.startsWith("-")) {
						flag = false;
					} else if (nextLine.startsWith("@")) {
						flag = true;

					}
				} else {
					flag = true;
				}
				break;

			default:
				break;
			}

			if (flag == true) {
				++count;
				dictionary.insert(word);
				
				word = new Word();
			}

		}
		bufferedReader.close();

	}

	public Word search(String key) {

		if (dictionary.root == null) {
			return null;
		}
		AVLNode<Word> node = dictionary.find(key);

		return node != null ? node.key : null;
	}

//	public int searchDelete(String key) {
//		int pos = 0;
//		if (dictionary.head == null) {
//			return -1;
//		}
//		NodeDouble<Word> current = dictionary.head;
//		while (current != null) {
//
//			if (current.data.getWord().trim().toLowerCase().contains(key.trim().toLowerCase())) {
//				return pos;
//			}
//
//			pos++;
//			current = current.next;
//		}
//		return pos;
//	}
}
