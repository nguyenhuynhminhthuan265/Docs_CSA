package com.cybersoft.mystack;

public class MyStack implements Stack<Integer> {
	private int[] arr;
	private int pos;
	private int capacity;

	public MyStack(int maxSize) {
		this.arr = new int[maxSize];
		this.capacity = maxSize;
		this.pos = 0;
	}

	@Override
	public int size() {
		return pos;
	}

	@Override
	public boolean isEmpty() {
		return pos == 0;
	}

	@Override
	public boolean isFull() {

		return pos == capacity;

	}

	@Override
	public Integer peek() {
		if (!isEmpty())
			return arr[pos - 1];
		else
			System.exit(1);

		return -1;

	}

	@Override
	public void push(Integer value) {
		if (isFull()) {
			System.out.println("Stack full");
			System.exit(1);
		}

		System.out.println("Insert: " + value);
		arr[pos++] = value;
	}

	@Override
	public Integer pop() {

		if (isEmpty()) {
			System.out.println("Stack empty");
			System.exit(1);
		}

		return arr[--pos];
	}

}
