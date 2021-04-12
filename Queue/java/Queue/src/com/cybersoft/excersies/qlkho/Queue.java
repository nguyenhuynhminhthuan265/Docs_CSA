package com.cybersoft.excersies.qlkho;

public interface Queue<T> {
	public void enqueue(T element);

	public T dequeue();

	public T peek();

	public int size();

	public boolean isEmpty();

	public boolean isFull();
}



