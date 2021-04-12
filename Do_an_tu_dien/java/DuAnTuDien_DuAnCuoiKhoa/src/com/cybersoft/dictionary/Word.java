package com.cybersoft.dictionary;

import java.util.Arrays;
import java.util.Scanner;

public class Word {
	private String word;
	private String type;
	private String[] meanings;
	private CustomLinkedList<String> examples;
	public static final int MAX_LENGTH_MEANING = 5;

	public Word() {
		this.meanings = new String[MAX_LENGTH_MEANING];
		this.examples = new CustomLinkedList<String>();
	}

	public Word(String word, String type, String[] meanings, CustomLinkedList<String> examples) {

		this.word = word;
		this.type = type;
		this.meanings = meanings;
		this.examples = examples;
	}

	public Word(String word, String type, String[] meanings) {

		this.word = word;
		this.type = type;
		this.meanings = meanings;

	}

	public Word(String word, String type) {

		this.word = word;
		this.type = type;
	}

	public CustomLinkedList<String> getExamples() {
		return examples;
	}

	public void setExamples(CustomLinkedList<String> examples) {
		this.examples = examples;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getMeanings() {
		return meanings;
	}

	public void setMeanings(String[] meanings) {
		this.meanings = meanings;
	}

	public void input(Scanner sc) {
		System.out.print("Nhap tu: ");
		this.word = sc.nextLine();

		System.out.print("Loai tu: ");
		this.type = sc.nextLine();
		System.out.println("Nhap nghia, toi da 5 nghia: ");
		for (int i = 0; i < MAX_LENGTH_MEANING; i++) {
			String temp = "";
			System.out.print("Nhap nghia " + (i + 1) + ": ");
			temp = sc.nextLine();
			if (temp.equals(""))
				break;
			this.meanings[i] = temp;
		}

		System.out.println("Nhap vi du: ");
		int count = 0;
		while (true) {
			String temp = "";
			System.out.print("Nhap vi du " + ++count + ": ");
			temp = sc.nextLine();
			if (temp.equals(""))
				break;
			this.examples.insertAtStart(temp);
		}

	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", type=" + type + ", meanings=" + printMeanings(meanings) + "]\n" + "examples: "
				+ examples.show() + "\n"

		;

	}

	public String printMeanings(String[] meanings) {
		String res = "[";
		for (int i = 0; i < meanings.length; i++) {
			if (meanings[i] != null) {
				res = res + meanings[i];
			}
			if (i + 1 < MAX_LENGTH_MEANING) {
				if (meanings[i + 1] != null) {
					res += ", ";
				}

			}
		}
		res += "]";
		return res;
	}

}
