package com.cybersoft.mystack;

public class Main {

	public static void main(String[] args) {

		MyStack myStack = new MyStack(5);

		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
//		s.push(6);

		System.out.println(myStack.pop()); // 5
		System.out.println(myStack.pop()); // 4
		System.out.println(myStack.pop()); // 3

		myStack.push(3);
		myStack.push(4);
		myStack.push(5);

		while (!myStack.isEmpty())
			System.out.println(myStack.pop());

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	  // BenchMark MyStack vs ArrayDeque.
//	  private static void benchMarkTest() {
//
//	    int n = 10000000;
//	    MyStack MyStack = new MyStack(n);
//
//	    // MyStack times at around 0.0324 seconds
//	    long start = System.nanoTime();
//	    for (int i = 0; i < n; i++) MyStack.push(i);
//	    for (int i = 0; i < n; i++) MyStack.pop();
//	    long end = System.nanoTime();
//	    System.out.println("MyStack Time: " + (end - start) / 1e9);
//
//	    // ArrayDeque times at around 1.438 seconds
//	    //    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
//	    //    java.util.Stack<Integer> arrayDeque = new java.util.Stack<>();
//	    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>(n); // strangely the
//	    // ArrayQueue is slower when you give it an initial capacity.
//	    start = System.nanoTime();
//	    for (int i = 0; i < n; i++) arrayDeque.push(i);
//	    for (int i = 0; i < n; i++) arrayDeque.pop();
//	    end = System.nanoTime();
//	    System.out.println("ArrayDeque Time: " + (end - start) / 1e9);
//
//	    Stack<Integer> listStack = new ListStack<>();
//
//	    start = System.nanoTime();
//	    for (int i = 0; i < n; i++) listStack.push(i);
//	    for (int i = 0; i < n; i++) listStack.pop();
//	    end = System.nanoTime();
//	    System.out.println("ListStack Time: " + (end - start) / 1e9);
//
//	    Stack<Integer> arrayStack = new ArrayStack<>();
//
//	    start = System.nanoTime();
//	    for (int i = 0; i < n; i++) arrayStack.push(i);
//	    for (int i = 0; i < n; i++) arrayStack.pop();
//	    end = System.nanoTime();
//	    System.out.println("ArrayStack Time: " + (end - start) / 1e9);
//	  }
}
