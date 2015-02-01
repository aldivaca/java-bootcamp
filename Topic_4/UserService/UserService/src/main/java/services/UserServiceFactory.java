package services;

public class UserServiceFactory {

	public UserServiceFactory() {
	}

	public static UserService getLocalService() {
		return new UserServiceImplementation();
	}

	public static UserService getWebService() {
		return new UserServiceProxy(new UserWebService());
	}

}
