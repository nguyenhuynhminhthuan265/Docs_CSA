package com.cybersoft.stack.example;

import java.util.Stack;

public class Example {
	public static void main(String[] args) {
		
		
		
		// Khởi tạo 1 Stack
		Stack<Integer> stack = new Stack<Integer>();

		// Thêm phần tử vào đỉnh Stack
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		// Lấy phần tử ở đỉnh nhưng không xóa
		System.out.println("peek function: " + stack.peek());
		
		// Lấy phần tử ở đỉnh và xóa
		System.out.println("pop function: " + stack.pop());
		
		// Kiểm tra stack có trống không
		System.out.println("isEmpty function: " + stack.isEmpty());
		
		// Tìm phần tử trong Stack ==> trả về vị trí index của phần tử trong Stack
		System.out.println("search function: " + stack.search(9));
		
	}
}
