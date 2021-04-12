package com.cybersoft.dictionary;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("start");
		Dictionary dictionary = new Dictionary();
		System.out.println("end");
		dictionary.xuLyTuDien(sc);
		

		dictionary.dictionary.print();
	}

}
