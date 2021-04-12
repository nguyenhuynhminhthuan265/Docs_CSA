package com.cybersoft.avltree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Word {
	private String word;
	private String type;
	private List<String> meanings;
	public static final int MAX_LENGTH_MEANING = 5;

	public Word() {
		this.meanings = new ArrayList<String>();

	}

	public Word(String word, String type, List<String> meanings) {

		this.word = word;
		this.type = type;
		this.meanings = meanings;

	}

	public Word(String word, String type) {

		this.word = word;
		this.type = type;
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

	public List<String> getMeanings() {
		return meanings;
	}

	public void setMeanings(List<String> meanings) {
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
			this.meanings.add(temp);
		}

	}

	public int generateCode() {
		String text = this.word + this.type;

		return text.hashCode();
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", type=" + type + "\n" + "meanings=" + printMeanings(meanings) + "]\n";

	}

	public String printMeanings(List<String> meanings) {
		String res = "[\n";
		for (int i = 0; i < meanings.size(); i++) {
			res += "-" + meanings.get(i) + "\n";
		}
		res += "]";
		return res;
	}

}
