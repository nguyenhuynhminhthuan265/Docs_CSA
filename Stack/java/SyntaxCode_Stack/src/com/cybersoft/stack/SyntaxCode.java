package com.cybersoft.stack;

public class SyntaxCode {
	public static void main(String[] args) {
		String balancedParenthensies1 = "{(a,b)}";
		String balancedParenthensies2 = "{(a},b)";

		MyStack<Character> myStack = new MyStack<Character>();
		char[] charbalancedParenthensies = balancedParenthensies1.toCharArray();
		if (checkBalancedParentThensies(myStack, charbalancedParenthensies)) {
			System.out.println("Bieu thuc can bang");
		} else {
			System.out.println("Khong can bang");
		}

	}

	private static boolean checkBalancedParentThensies(MyStack<Character> myStack, char[] charbalancedParenthensies) {
		for (char c : charbalancedParenthensies) {
			if (c == '(' || c == '{' || c == '[') {
				myStack.push(c);
			} else if (c == '}' || c == ']' || c == ')') {
				if (myStack.isEmpty()) {
					return false;
				}
				switch (c) {
				case '}':
					if (myStack.peek() == '{') {
						myStack.pop();
					}
					break;
				case ']':
					if (myStack.peek() == '[') {
						myStack.pop();
					}
					break;

				case ')':
					if (myStack.peek() == '(') {
						myStack.pop();
					}
					break;
				default:
					return false;

				}
			}
		}
		if (myStack.isEmpty())
			return true;
		else
			return false;
	}
}
