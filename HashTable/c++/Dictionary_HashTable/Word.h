#ifndef WORD_H
#define WORD_H
#include <iostream>
using namespace std;
class Word {
private:
	string word;
	string type;
	string pronunciation;
	string example;

public:
	Word();
	Word(string, string, string, string);

	string getWord();

	void setWord(string);

	string getType();

	void setType(string);

	string getPronunciation();

	void setPronunciation(string);

	string getExample();

	void setExample(string);

	string toString();

};
#endif