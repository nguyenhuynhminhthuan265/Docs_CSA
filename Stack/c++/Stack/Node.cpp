#include <iostream> 
using namespace std;
template <typename T> class Node {
public:
	T data;
	Node<T> *next;

public:
	Node() {
	
		this->next = NULL;
	}

	 Node(T data) {

		this->data = data;
		this->next = NULL;
	}

};





