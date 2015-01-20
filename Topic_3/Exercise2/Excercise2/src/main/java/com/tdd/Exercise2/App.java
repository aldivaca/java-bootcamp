package com.tdd.Exercise2;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		WrappedWords list = new WrappedWords(60);
		list.add("This is a text with less than 60 characters");
		System.out.println(list.toString());
		list = new WrappedWords(7);
		list.add("Hello Word!");
		System.out.println(list.toString());
		list = new WrappedWords(5);
		list.add("Excelent");
		System.out.println(list.toString());
		list = new WrappedWords(5);
		list.add("This is an Excelent idea to work character treatment");
		System.out.println(list.toString());

	}
}
