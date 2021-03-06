package com.tdd.Exercise4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdd.Exercise4.DecimalToRoman;
import com.tdd.Exercise4.RomanToDecimal;

public class RomanArabicTest {

	@Test
	public void romanToDecimalTest() {
		RomanToDecimal strategy = new RomanToDecimal();
		int numberConverted = strategy.convert("MCMLIV");
		assertEquals(1954, numberConverted);
	}

	@Test
	public void decimalToRomanTest() {
		DecimalToRoman strategy = new DecimalToRoman();
		String numberConverted = strategy.convert("2014");
		assertEquals("MMXIV", numberConverted);
	}
}
