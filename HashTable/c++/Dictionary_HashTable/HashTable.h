#ifndef HASHTABLE_H
#define HASHTABLE_H

#include <iostream>
#include "LinkedList.h"
#include "string.h"
#include "Word.h"
using namespace std;
class HashTable {
private:
	static const int R = 256;
	LinkedList* hashTable;
	int lenHashTable = 7;

public:
	HashTable();

	HashTable(int);

	int hash(string key);

	void init();

	void initHash();

	void insertHashTable(Word);

	//List<Word> readFile();
	void print();

	void Add(Word);

	//List<Word> Search(string);

};
#endif