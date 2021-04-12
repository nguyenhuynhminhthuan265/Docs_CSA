package com.cybersoft.dictionary;

public class NodeDouble<T> {
	T data;
	NodeDouble<T> prev;
	NodeDouble<T> next;

	public NodeDouble() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public NodeDouble(T data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public NodeDouble(T data, NodeDouble<T> prev, NodeDouble<T> next) {

		this.data = data;
		this.prev = prev;
		this.next = next;
	}

}
