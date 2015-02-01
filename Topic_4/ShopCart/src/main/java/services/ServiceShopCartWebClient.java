package services;

public class ServiceShopCartWebClient implements ServiceShopCart {

	ServiceShopCart webService;

	public ServiceShopCartWebClient() {
		// webService = code to get the reference to Service A from the
		// webservice call
	}

	public void createCart() {
		webService.createCart();
	}

	public void addItem() {
		webService.addItem();
	}

	public void detailCart() {
		webService.detailCart();
	}

	public void makePurchase() {
		webService.makePurchase();
	}
}
