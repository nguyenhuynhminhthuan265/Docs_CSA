package com.cybersoft.excersies.qlkho;




public class KhoHang implements Queue<MatHang> {

	private Node<MatHang> front;

	private Node<MatHang> rear;
	private int currentSize;
	private int capacity;

	public KhoHang(int capacity) {

		this.currentSize = 0;
		this.capacity = capacity;
	}

	public KhoHang() {
		this.front = this.rear = null;
	}

	@Override
	public void enqueue(MatHang matHang) {
		if (isFull()) {
			System.out.println("Kho hàng đầy");
			return;
		}
		Node<MatHang> newNode = new Node<MatHang>(matHang);
		if (this.front == null) {
			this.front = newNode;
		} else {
			this.rear.next = newNode;
		}
		currentSize++;
		this.rear = newNode;
		this.rear.next = this.front;
	}

	@Override
	public MatHang dequeue() {
		if (isEmpty()) {
			return null;
		}
		Node<MatHang> node = this.front;
		this.front = node.next;
		currentSize--;

		if (this.front == null) {
			this.rear = null;
		}
		return node.data;

	}

	@Override
	public MatHang peek() {
		if (isEmpty()) {
			System.out.println("Không có hàng");
			return null;
		}
		return this.front.data;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public boolean isFull() {
		return currentSize == capacity;
	}

	public MatHang getNewItemPushed() {
		if (!isEmpty()) {
			return this.rear.data;
		}
		return null;
	}

	
	
	
	
	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void print() {
		Node<MatHang> node = this.front;
		for (int i = 0; i < currentSize; i++) {
			System.out.println(node.data.toString());
			node = node.next;
		}
	}

}
