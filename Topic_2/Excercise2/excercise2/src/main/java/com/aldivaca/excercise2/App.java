package com.aldivaca.excercise2;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, enter your name..");
		String s = scan.next();
		System.out.println("Hello " + s + "!");
		scan.close();
	}
}
