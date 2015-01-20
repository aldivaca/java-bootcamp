package com.tdd.Exercise4;

public class App {
	public static void main(String[] args) {
		RomanToDecimal strategyRD = new RomanToDecimal();
		int numberConvertedRD = strategyRD.convert("MCMLIV");
		System.out.println("MCMLIV is " + numberConvertedRD);

		DecimalToRoman strategyDR = new DecimalToRoman();
		String numberConvertedDR = strategyDR.convert("2014");
		System.out.println("2014 is " + numberConvertedDR);
	}
}
