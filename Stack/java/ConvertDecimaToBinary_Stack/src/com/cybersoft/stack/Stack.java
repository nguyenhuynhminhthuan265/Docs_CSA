package com.cybersoft.stack;

public interface Stack<T> {

	public int size();

	public boolean isEmpty();

	public boolean isFull();

	public void push(T elem);

	public T pop();

	public T peek();
}