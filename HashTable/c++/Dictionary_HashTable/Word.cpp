#include <iostream>
#include "Word.h"
using namespace std;

Word::Word() {

}

Word::Word(string word, string type, string pronunciation, string example) {

	this->word = word;
	this->type = type;
	this->pronunciation = pronunciation;
	this->example = example;
}

string Word::getWord() {
	return word;
}

void Word::setWord(string word) {
	this->word = word;
}

string Word::getType() {
	return type;
}

void Word::setType(string type) {
	this->type = type;
}

string Word::getPronunciation() {
	return pronunciation;
}

void Word::setPronunciation(string pronunciation) {
	this->pronunciation = pronunciation;
}

string Word::getExample() {
	return example;
}

void Word::setExample(string example) {
	this->example = example;
}

string Word::toString() {
	return "Word [word=" + word + ", type=" + type + ", pronunciation=" + pronunciation + ", example=" + example
		+ "]";
}

