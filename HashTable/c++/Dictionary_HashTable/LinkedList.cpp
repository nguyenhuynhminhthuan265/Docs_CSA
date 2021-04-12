#include <iostream>
#include "Node.h"
#include "Word.h"
#include "LinkedList.h"
#include <list>
#include <vector>
using namespace std;


LinkedList::LinkedList() {
	this->head = NULL;
}

LinkedList::LinkedList(Node<Word>* head) {

	this->head = head;
}

void LinkedList::addTail(Word data) {
	Node<Word>* newNode = new Node<Word>(data);
	if (head == NULL) {
		head = newNode;
	}
	else {
		Node<Word>* currentNode = head;
		while (currentNode->next != NULL) {
			currentNode = currentNode->next;
		}
		currentNode->next = newNode;
	}
}

void LinkedList::addHead(Word data) {
	Node<Word>* newNode = new Node<Word>(data);

	newNode->next = head;
	head = newNode;
}

void LinkedList::insertAt(int index, Word data) {
	if (index == 0) {
		addHead(data);
	}
	else {
		Node<Word>* newNode = new Node<Word>(data);

		Node<Word>* currentNode = head;
		for (int i = 0; i < index - 1; i++) {
			currentNode = currentNode->next;
		}
		newNode->next = currentNode->next;
		currentNode->next = newNode;
	}
}

void LinkedList::deleteAt(int index) {
	if (index == 0) {
		head = head->next;
	}
	else {
		Node<Word>* currentNode = head;
		for (int i = 0; i < index - 1; i++) {
			currentNode = currentNode->next;
		}
		currentNode->next = currentNode->next->next;
	}
}

void LinkedList::show() {
	Node<Word>* currentNode = head;
	if (currentNode == NULL) {
		cout << "Linked list is empty" << endl;
	}
	else {
		while (currentNode != NULL) {
			cout << currentNode->data.getWord() << " ";
			currentNode = currentNode->next;
		}
	}
}

vector<Node<Word>> LinkedList::findByWord(string word) {
	vector<Node<Word>> words;
	Node<Word>* currentNode = head;
	if (currentNode == NULL) {
		return words;
	}
	else {
		while (currentNode != NULL) {
			if (currentNode->data.getWord() == word) {
				words.push_back(*currentNode);

			}
			currentNode = currentNode->next;
		}

		return words;
	}
}
