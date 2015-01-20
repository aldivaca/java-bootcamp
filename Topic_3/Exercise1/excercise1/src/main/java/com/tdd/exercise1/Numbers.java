package com.tdd.exercise1;

import java.util.Scanner;

public class Numbers {

	public double number;
	public int integerLength;

	public Numbers(double number) {
		this.number = number;
		setIntegerLength();
	}

	public void setIntegerLength() {
		String number = toString();

		Scanner scan = new Scanner(number);
		scan.useDelimiter("\\s*");
		integerLength = 0;
		while (scan.hasNext()) {
			if (scan.next().equalsIgnoreCase(".")) {
				break;
			}
			integerLength++;
		}
		scan.close();
	}

	public String toText() {
		return integerToText() + " and " + centsToText() + " dollars";
	}

	public String integerToText() {
		Converter converter = new Converter();
		String dollars = converter.convert(integerToString());
		return dollars;
	}

	public String centsToText() {
		StringBuilder reason = new StringBuilder("1");
		for (int i = 0; i < centsToString().length(); i++) {
			reason.append("0");
		}
		return centsToString() + "/" + reason.toString();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("");
		builder.append(number);
		return builder.toString();
	}

	public String integerToString() {
		String number = toString();
		String integ = number.substring(0, integerLength);
		return integ;
	}

	public String centsToString() {
		String number = toString();
		String dec = number.substring(integerLength + 1, number.length());
		if (dec.length() < 2) {
			dec += "0";
		}
		return dec;
	}

	public double getValue() {
		return this.number;
	}

}
