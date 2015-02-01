package services;

import model.User;

public class UserServiceProxy implements UserService {

	UserService implementation;

	public UserServiceProxy(UserService userService) {
		implementation = userService;
	}

	public void createUser(User user) {
		implementation.createUser(user);
	}

	public void readUser(String username) {
		implementation.readUser(username);
	}

	public void updateUser(User user) {
		implementation.updateUser(user);
	}

	public void deleteUser(String username) {
		implementation.deleteUser(username);
	}

	public void addFriend(User actualLogin, String username) {
		implementation.addFriend(actualLogin, username);
	}

	public void giveLike(User actualLogin, String username) {
		implementation.giveLike(actualLogin, username);
	}

}
