package services;

import javax.jws.WebService;

@WebService
public class ServiceShopCartWeb implements ServiceShopCart {
	ServiceShopCart imp = new ServiceShopCartImplementation();

	public void createCart() {
		imp.createCart();
	}

	public void addItem() {
		imp.addItem();
	}

	public void detailCart() {
		imp.detailCart();
	}

	public void makePurchase() {
		imp.makePurchase();
	}
}
