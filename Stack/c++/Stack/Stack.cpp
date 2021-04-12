#include <iostream>
using namespace std;

template <typename T> class Stack {
	  
public:
	virtual int size() = 0;

	virtual bool isEmpty() = 0;

	virtual bool isFull() = 0;

	virtual void push(T elem) = 0;

	virtual T pop() = 0;

	virtual T peek() = 0;
};
