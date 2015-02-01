package com.services.ShopCart;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import services.ServiceShopCart;
import services.ServiceShopCartFactory;

public class ServiceShopCartTest {

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Test
	public void localServiceCartCreationTest() {
		System.setOut(new PrintStream(outContent));
		ServiceShopCart service = ServiceShopCartFactory.getLocalService();
		service.createCart();
		assertEquals("Cart Created", outContent.toString());

	}

	@Test
	public void localServiceItemsAddTest() {
		System.setOut(new PrintStream(outContent));
		ServiceShopCart service = ServiceShopCartFactory.getLocalService();
		service.createCart();
		service.addItem();
		assertEquals("Cart CreatedItems Added", outContent.toString());
	}

	@Test
	public void localServiceMakePurchaseTest() {
		System.setOut(new PrintStream(outContent));
		ServiceShopCart service = ServiceShopCartFactory.getLocalService();
		service.createCart();
		service.makePurchase();
		assertEquals("Cart CreatedLa transaccion Nro 1 fue realizada", outContent.toString());
	}
}
