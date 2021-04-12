#ifndef NODE_H
#define NODE_H
#include <iostream>
using namespace std;
template<typename T> class Node {
public:
	T data;
	Node<T>* next;

public:
	Node();
	Node(T);

	template<class T>
	Node() {

		this->next = NULL;
	}
	template<class T>
	Node(T data) {

		this->data = data;
		this->next = NULL;
	}
};

#endif