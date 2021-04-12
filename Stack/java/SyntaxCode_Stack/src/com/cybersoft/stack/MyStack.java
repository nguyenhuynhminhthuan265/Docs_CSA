package com.cybersoft.stack;

public class MyStack<T> implements Stack<T> {
	private Node<T> top;

	public MyStack() {
		this.top = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
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

		Node<T> node = new Node<T>();

		node.data = elem;

		node.next = top;

		top = node;

	}

	@Override
	public T pop() {

		if (top == null) {
			System.out.print("\nStack Underflow");
			return null;
		}

		Node<T> object = top;

		top = top.next;

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
