package com.tdd.exercise1;

import java.util.Random;

public class App {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Random r = new Random();
			int tensNumber = r.nextInt(8);
			int dollarNumber = r.nextInt((int) Math.pow(10, tensNumber));
			int decimalsNumber = r.nextInt(100);
			double centsNumber = (double) decimalsNumber / 100;
			Numbers number = new Numbers(dollarNumber + centsNumber);
			System.out.println(number.toString() + " is " + number.toText());
		}
	}
}