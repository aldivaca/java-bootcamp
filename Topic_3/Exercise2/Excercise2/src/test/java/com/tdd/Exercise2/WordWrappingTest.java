package com.tdd.Exercise2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdd.Exercise2.WrappedWords;

public class WordWrappingTest {

	@Test
	public void WordWrappedTest() {
		WrappedWords list = new WrappedWords(3);
		list.add("a b c d e f");
		assertEquals("'a b', 'c d', 'e f'", list.toString());
	}

	@Test
	public void LengthTest() {
		WrappedWords list = new WrappedWords(60);
		list.add("This is a text with less than 60 characters");
		assertEquals("'This is a text with less than 60 characters'", list.toString());
	}

	@Test
	public void WrappingTest() {
		WrappedWords list = new WrappedWords(7);
		list.add("Hello Word!");
		assertEquals("'Hello', 'Word!'", list.toString());
	}

	@Test
	public void CutAndWrapTest() {
		WrappedWords list = new WrappedWords(5);
		list.add("Excelent");
		assertEquals("'Excel', 'ent'", list.toString());
	}

	@Test
	public void FinalCompleteTest() {
		WrappedWords list = new WrappedWords(5);
		list.add("This is an Excelent idea to work character treatment");
		assertEquals("'This', 'is an', 'Excel', 'ent', 'idea', 'to', 'work', 'chara', 'cter', 'treat', 'ment'", list.toString());
	}
}
