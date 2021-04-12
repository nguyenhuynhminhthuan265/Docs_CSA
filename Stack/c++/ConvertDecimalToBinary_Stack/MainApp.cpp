#include <iostream>
#include "math.h"
#include "MyStack.cpp"
using namespace std;
//string prettyBinary(string binary, int blockSize, string separator) {
//	if (binary.length() % 4 != 0) {
//		string temp = "0";
//		int lengthBinary = binary.length();
//		for (int i = 0; i < abs(lengthBinary % blockSize - blockSize); i++) {
//			binary = temp + binary;
//		}
//	}
//
//	List<string> result = new ArrayList<>();
//	int index = 0;
//	while (index < binary.length()) {
//		result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
//		index += blockSize;
//	}
//
//	return result.stream().collect(Collectors.joining(separator));
//}
int main() {
	int decimal = 10001;
	string res = "";
	MyStack<int> *myStack = new MyStack<int>();
	do {
		int du = decimal % 2;
		decimal = decimal / 2;
		myStack->push(du);

	} while (decimal > 0);

	while (!myStack->isEmpty()) {

		res += (char)(myStack->pop() + '0');

	}

	cout << res <<endl;

	system("pause");
	return 0;
}