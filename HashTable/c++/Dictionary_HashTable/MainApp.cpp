#include <iostream>
#include <fstream>
#include <string>
#include "LinkedList.cpp"
#include "HashTable.h"
using namespace std;

int main() {

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

	system("pause");
	return 0;
}