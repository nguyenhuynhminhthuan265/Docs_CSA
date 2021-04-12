#include <iostream>
#include <fstream>
#include <string>
#include "LinkedList.cpp"
#include "HashTable.h"
using namespace std;

HashTable::HashTable() {
	this->hashTable = new LinkedList();
}

HashTable::HashTable(int lenHashTable) {
	this->lenHashTable = lenHashTable;
	hashTable = new LinkedList[lenHashTable];
}

int HashTable::hash(string key) {
	int pos = 0;
	for (int j = 0; j < key.length(); j++) {
		pos = (R * pos + key.at(j)) % lenHashTable;
	}
	return pos;
}

void HashTable::init() {

	for (int i = 0; i < lenHashTable; i++)
		hashTable[i] = NULL;
}

void HashTable::initHash() {
	/*List<Word> words = readFile();
	int pos;
	init();

	for (int i = 0; i < words.size(); i++) {
		insertHashTable(words.get(i));

	}*/


	fstream newfile;
	//newfile.open("raw.txt", ios::out);  // open a file to perform write operation using file object
	//if (newfile.is_open()) //checking whether the file is open
	//{
	//	newfile << "Tutorials point \n";   //inserting text
	//	newfile.close();    //close the file object
	//}



	newfile.open("D:\\Cybersoft_Mentor\\Uu_tien\\workspace_CPlusPlus\\folder_file\\raw.csv", ios::in); //open a file to perform read operation using file object
	if (newfile.is_open()) {   //checking whether the file is open
		string tp;
		while (getline(newfile, tp)) { //read data from file object and put it into string.
			cout << tp << "\n"; //print the data of the string
		}
		newfile.close(); //close the file object.
	}

}





//void HashTable::insertHashTable(Word word) {
//	int pos;
//	pos = hash(word.getWord());
//	if (hashTable[pos] == null) {
//		hashTable[pos] = new LinkedList();
//		hashTable[pos].addTail(word);
//	}
//	else {
//		hashTable[pos].addTail(word);
//	}
//}
//
//List<Word> HashTable::readFile() throws IOException {
//	String row = "";
//	List<Word> words = new ArrayList<Word>();
//	Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
//	BufferedReader csvReader = new BufferedReader(new FileReader(path + "/src/com/cybersoft/hashtable/raw.csv"));
//	csvReader.readLine(); // this will read the first line
//	while ((row = csvReader.readLine()) != null) {
//		String[] data = row.split(",");
//		//				System.out.print(data[i] + " ");
//		Word word = new Word(data[0], data[1], data[2], data[3]);
//		words.add(word);
//
//	}
//	csvReader.close();
//	return words;
//}
//
//void HashTable::print() {
//
//	for (int i = 0; i < lenHashTable; i++) {
//
//		System.out.format("hashTable[%d]-->", i);
//		if (hashTable[i] != null) {
//			Node<Word> currentNode = hashTable[i].head;
//			while (currentNode != null) {
//				System.out.format("%s -->", currentNode.data.getWord());
//				currentNode = currentNode.next;
//			}
//		}
//
//		System.out.println("NULL\n");
//	}
//}
//
//void HashTable::Add(Word word) {
//
//	int pos = hash(word.getWord());
//	if (hashTable[pos] == null) {
//		hashTable[pos] = new LinkedList();
//		hashTable[pos].addTail(word);
//	}
//	else {
//		hashTable[pos].addTail(word);
//	}
//
//}
//
//List<Word> HashTable::Search(String word) {
//	List<Word> words = new ArrayList<Word>();
//	int pos = hash(word);
//	if (hashTable[pos] == null) {
//		System.out.println("Word not found");
//		return null;
//	}
//	else {
//		List<Node<Word>> nodes = hashTable[pos].findByWord(word);
//		if (nodes != null && !nodes.isEmpty()) {
//			for (Node<Word> nodeWord : nodes) {
//				words.add(nodeWord.data);
//			}
//
//			return words;
//		}
//		else {
//			System.out.println("Word not found");
//			return null;
//		}
//	}
//}


