package com.tdd.excercise1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AmountToTextTest {

	@Test
	public void testAmountToText() {
		Numbers number = new Numbers(2523.04);
		String s = number.toText();
		assertEquals("two thousand five hundred twenty three and 04/100 dollars", s);
	}

	@Test
	public void testCentsToText() {
		Numbers number = new Numbers(2523.04);
		String s = number.centsToText();
		assertEquals("04/100", s);
	}

	@Test
	public void testNumberToString() {
		Numbers number = new Numbers(2523.04);
		String s = number.toString();
		assertEquals("2523.04", s);
	}

	@Test
	public void testDollarsToString() {
		Numbers number = new Numbers(2523.04);
		String s = number.integerToString();
		assertEquals("2523", s);
	}

	@Test
	public void testCentsToString() {
		Numbers number = new Numbers(2523.04);
		String s = number.centsToString();
		assertEquals("04", s);
	}

}
