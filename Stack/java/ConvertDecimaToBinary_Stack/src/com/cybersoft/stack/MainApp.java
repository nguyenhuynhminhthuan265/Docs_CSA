package com.cybersoft.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {
	public static void main(String[] args) {
		int decimal = 10001;
		String res = "";
		MyStack<Integer> myStack = new MyStack<Integer>();
		do {
			int du = decimal % 2;
			decimal = decimal / 2;
			myStack.push(du);

		} while (decimal > 0);

		while (!myStack.isEmpty()) {

			res += myStack.pop();

		}

		System.out.println(prettyBinary(res, 4, " "));

	}

	public static String prettyBinary(String binary, int blockSize, String separator) {
		if (binary.length() % 4 != 0) {
			String temp = "0";
			int lengthBinary = binary.length();
			for (int i = 0; i < Math.abs(lengthBinary % blockSize - blockSize); i++) {
				binary = temp + binary;
			}
		}

		List<String> result = new ArrayList<>();
		int index = 0;
		while (index < binary.length()) {
			result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
			index += blockSize;
		}

		return result.stream().collect(Collectors.joining(separator));
	}
}
