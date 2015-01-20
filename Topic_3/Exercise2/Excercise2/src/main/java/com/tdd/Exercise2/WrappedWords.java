package com.tdd.Exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class WrappedWords {

	public ArrayList<String> words;
	public int length;

	public WrappedWords(int length) {
		words = new ArrayList<String>();
		this.length = length;
	}

	public void addCharacters(String text) {
		String remainText = text;
		while (remainText.length() > length) {
			String word = remainText.substring(0, length);
			remainText = remainText.substring(length);
			remainText = remainText.trim();
			words.add(word);
		}
		if (remainText.length() != 0) {
			words.add(remainText);
		}

	}

	public String toString() {
		StringBuilder builder = new StringBuilder("");
		for (int i = 0; i < words.size(); i++) {
			builder.append("'");
			if (i == words.size() - 1) {
				builder.append(words.get(i));
				builder.append("'");
			} else {
				builder.append(words.get(i));
				builder.append("', ");
			}
		}
		return builder.toString();
	}

	public void add(String text) {
		Scanner scan = new Scanner(text);
		String word = scan.next();
		String nextWord = "";
		while (scan.hasNext()) {
			nextWord = scan.next();
			while ((word.length() + nextWord.length() + 1) <= length && scan.hasNext()) {
				word = word + " " + nextWord;
				nextWord = scan.next();
			}
			if ((word.length() + nextWord.length() + 1) <= length) {
				word = word + " " + nextWord;
				nextWord = "";
			}
			if (word.length() <= length) {
				words.add(word);
			} else {
				addCharacters(word);
			}
			word = nextWord;

		}
		if (word.length() != 0) {
			if (word.length() <= length) {
				words.add(word);
			} else {
				addCharacters(word);
			}
		}
		scan.close();
	}
}
