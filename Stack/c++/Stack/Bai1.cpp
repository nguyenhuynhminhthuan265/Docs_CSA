#include <iostream>
#include "MyStack.cpp"
#include <string>
#include <cstring>
using namespace std;
int main() {
	MyStack<int> *stack = new MyStack<int>();
	//		Step 1: Tạo 1 Stack để lưu các ký tự vừa nhập
	MyStack<char> *stackWords = new MyStack<char>();
	//		Step 2: Tạo 1 Stack lưu lại các ký tự đã xóa 
	MyStack<char> *stackWordsDeleted = new MyStack<char>();
	//		Step 3: Gõ một đoạn text
	cout << "Text: ";
	string line;
	getline(cin, line);
	char* characters = &line[0];

	for (int i = 0; i < strlen(characters); i++) {
		stackWords->push(characters[i]);
	}
	cout << "0: Delete\t1: Ctrl + Z" << endl;
	int option;
	do {
		cout << "option: ";
		cin >> option;
		if (option != 1 && option != 0) {
			break;
		}
		switch (option) {
		case 0:
			//				 kiểm tra xem trong stack còn ký tự để xóa không
			//				===> còn thì tiếp tục xóa
			//				===> hết thì chỉ cần in lại chuỗi ""
			if (!stackWords->isEmpty()) {
				stackWordsDeleted->push(stackWords->pop());
			}
			cout << convertStackCharToString(*stackWords) << endl;
			break;
		case 1:
			//				 kiểm tra xem trong stack các ký tự đã xóa còn trống không
			//				===> còn thì tiếp tục Ctrl + Z
			//				===> hết thì chỉ cần in lại chuỗi ban đầu
			if (!stackWordsDeleted->isEmpty()) {
				stackWords->push(stackWordsDeleted->pop());
			}
			cout << convertStackCharToString(*stackWords) << endl;
			break;

		}
	} while (option == 0 || option == 1);
	system("pause");
	return 0;
}



string convertStackCharToString(MyStack<char> stack) {
	MyStack<string>* reverseStack = new MyStack<string>();
	MyStack<char>* object = &stack;
	string result = "";
	while (!object->isEmpty()) {
		reverseStack->push(string(1, object->pop()));
	}

	while (!reverseStack->isEmpty()) {
		result += reverseStack->pop();

	}

	return result;

}