package services;

import model.User;

public class UserWebService implements UserService {

	UserService imp = new UserServiceImplementation();

	public void createUser(User user) {
		imp.createUser(user);
	}

	public void readUser(String username) {
		imp.readUser(username);
	}

	public void updateUser(User user) {
		imp.updateUser(user);
	}

	public void deleteUser(String username) {
		imp.deleteUser(username);
	}

	public void addFriend(User actualLogin, String username) {
		imp.addFriend(actualLogin, username);
	}

	public void giveLike(User actualLogin, String username) {
		imp.giveLike(actualLogin, username);
	}

}
