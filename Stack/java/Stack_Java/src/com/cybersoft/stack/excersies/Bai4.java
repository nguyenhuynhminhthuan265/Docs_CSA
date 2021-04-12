package com.cybersoft.stack.excersies;

/*
 * Dùng Stack kiểm tra cú pháp trong các ngôn ngữ {[()]}
 * 
 * */
public class Bai4 {
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>();

		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");

		System.out.println("Top element is " + stack.peek());

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		if (stack.isEmpty()) {
			System.out.print("Stack is empty");
		} else {
			System.out.print("Stack is not empty");
		}
	}
}
