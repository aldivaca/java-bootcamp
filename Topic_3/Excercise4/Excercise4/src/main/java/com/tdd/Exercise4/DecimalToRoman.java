package com.tdd.Excercise4;

public class DecimalToRoman {

	public String convert(String number) {
		String roman[] = { "M", "XM", "CM", "D", "XD", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int decimal[] = { 1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder result = new StringBuilder();
		int i = 0;
		int numberInt = Integer.parseInt(number);
		while (numberInt > 0 || decimal.length == (i - 1)) {
			while ((numberInt - decimal[i]) >= 0) {
				numberInt -= decimal[i];
				result.append(roman[i]);
			}
			i++;
		}
		return result.toString();
	}

}
