package com.cybersoft.stack.excersies;

public class MyStack<T> implements Stack<T> {
	private Node<T> top;

	public MyStack() {
		this.top = null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public boolean isFull() {
		return true;
	}

	@Override
	public void push(T elem) {
		// Khởi tạo một node mới
		Node<T> node = new Node<T>(); // tạo mới một node để lưu giá trị

		node.data = elem; // gán giá trị vào biến data của Node

		node.next = top; // trỏ phần tử tiếp theo của node đến đỉnh Stack

		top = node; // cần cập nhật lại đỉnh Stack

	}

	@Override
	public T pop() {

		if (!isEmpty()) {
			Node<T> object = top;
			// cập nhật lại đỉnh stack trỏ tới phần tử tiếp theo
			top = top.next;

			return object.data;
		} else {
			System.out.println("Stack empty");
			return null;
		}

	}

	@Override
	public T peek() {
		// check for empty stack
		if (!isEmpty()) {
			return top.data;
		} else {
			System.out.println("Stack empty");
			return null;
		}
	}
}
