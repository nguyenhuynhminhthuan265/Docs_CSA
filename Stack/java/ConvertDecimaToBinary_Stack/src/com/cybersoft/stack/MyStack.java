package com.cybersoft.stack;

public class MyStack<T> implements Stack<T> {
	private Node<T> top;
	private int size = 0;

	public MyStack() {
		this.top = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public boolean isFull() {
		return true;
	}

	@SuppressWarnings("unused")
	@Override
	public void push(T elem) {
		// Khởi tạo một node mới trong heap
		Node<T> node = new Node<T>();

		// Kiểm tra bộ nhớ heap nếu full thì thoát hàm, thông báo không
		// insert được
		if (node == null) {
			System.out.print("\nHeap Overflow");
			return;
		}
//		System.out.println("Inserting " + elem);

		node.data = elem;

		node.next = top;

		top = node;

		size++;

	}

	@Override
	public T pop() {
		// check for stack underflow
		if (top == null) {
			System.out.print("\nStack Underflow");
			return null;
		}

//		System.out.println("Removing " + peek());
		Node<T> object = top;
		// cập nhật lại đỉnh stack tr�? tới phần tử tiếp theo
		top = top.next;
		size--;
		return object.data;
	}

	@Override
	public T peek() {
		// check for empty stack
		if (!isEmpty()) {
			return top.data;
		} else {
			System.out.println("Stack is empty");
			return null;
		}
	}
}
