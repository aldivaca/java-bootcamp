package services;

public class ServiceShopCartFactory {
	private ServiceShopCartFactory() {
	}

	public static ServiceShopCart getLocalService() {
		return new ServiceShopCartImplementation();
	}

	public static ServiceShopCart getRemoteServiceUsingWebService() {
		return new ServiceProxyShopCart(new ServiceShopCartWeb());
	}

}
