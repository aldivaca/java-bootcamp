package services;

public class ServiceProxyShopCart implements ServiceShopCart {

	ServiceShopCart implementation;

	protected ServiceProxyShopCart(ServiceShopCart imp) {
		this.implementation = imp;
	}

	public void createCart() {

	}

	public void addItem() {

	}

	public void detailCart() {

	}

	public void makePurchase() {

	}

}
