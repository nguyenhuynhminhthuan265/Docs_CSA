#include <iostream>
#include "Stack.cpp"
#include "Node.cpp"
using namespace std;

template <typename T> class MyStack : public Stack<T> {
private:
	Node<T> *top;
public:
	MyStack() {
		this->top = NULL;
	}




	int size() {
		return 0;
	}

	bool isEmpty() {
		return top == NULL;
	 }

	bool isFull() {
		return true;
	 }

	void push(T elem) {
		Node<T>* node = new Node<T>();
		if (!node)
		{
			cout << "\nHeap Overflow";
			exit(1);
		}

		node->data = elem;
		node->next = top;
		top = node;
	 }



	T pop() {
		if (!isEmpty()) {
			Node<T> *object = top;
			// cập nhật lại đỉnh stack trỏ tới phần tử tiếp theo
			top = top->next;

			return object->data;
		}
		else {
			cout << "Stack empty" << endl;
			return NULL;
		}
	 }

	T peek() {
		// check for empty stack
		if (!isEmpty()) {
			return top->data;
		}
		else {
			cout << "Stack empty" << endl;
			return NULL;
		}
	 }


};