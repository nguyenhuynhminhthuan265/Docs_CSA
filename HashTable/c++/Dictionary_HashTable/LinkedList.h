#ifndef LINKEDLIST_H
#define LINKEDLIST_H
#include "Word.h"
#include <iostream>
#include "Node.h"
#include <vector>
class LinkedList {
	Node<Word>* head;
public:
	LinkedList();
	LinkedList(Node<Word>* head);
	void addTail(Word data);

	void addHead(Word data);

	void insertAt(int, Word);

	void deleteAt(int);

	void show();

	vector<Node<Word>> findByWord(string);
};

#endif
