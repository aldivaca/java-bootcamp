package com.tdd.exercise3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecentFileListTest {

	RecentFileList list;

	@Test
	public void OpenFileTest() {
		list = new RecentFileList(3);
		list.openFile("cancion.mp3");
		assertEquals("cancion.mp3", list.printFirstElement());
	}

	@Test
	public void ReOpenFileTest() {
		list = new RecentFileList(3);
		list.openFile("cancion.mp3");
		list.openFile("unDocumento.doc");
		list.openFile("cancion.mp3");
		assertEquals("cancion.mp3", list.printFirstElement());
		assertEquals("unDocumento.doc", list.printLastElement());

	}

	@Test
	public void OpenOtherFile() {
		list = new RecentFileList(3);
		list.openFile("unDocumento.doc");
		list.openFile("cancion.mp3");
		list.openFile("unaImagen.jpg");
		assertEquals("unaImagen.jpg", list.printFirstElement());
		assertEquals("unDocumento.doc", list.printLastElement());

	}

	@Test
	public void OverflowFileList() {
		list = new RecentFileList(3);
		list.openFile("unDocumento.doc");
		list.openFile("cancion.mp3");
		list.openFile("unaImagen.jpg");
		list.openFile("documentoExtra.zip");
		assertEquals("documentoExtra.zip", list.printFirstElement());
		assertEquals("cancion.mp3", list.printLastElement());
		assertEquals(false, list.contains("unDocumento.doc"));
	}
}
