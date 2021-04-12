package com.cybersoft.hashtable;

public class Word {
	private String word;
	private String type;
	private String pronunciation;
	private String example;

	public Word() {

	}

	public Word(String word, String type, String pronunciation, String example) {

		this.word = word;
		this.type = type;
		this.pronunciation = pronunciation;
		this.example = example;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", type=" + type + ", pronunciation=" + pronunciation + ", example=" + example
				+ "]";
	}

}
