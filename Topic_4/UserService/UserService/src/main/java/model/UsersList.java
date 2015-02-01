package model;

import java.util.HashMap;

public class UsersList {
	public HashMap<String, User> usersList;

	public UsersList() {
		usersList = new HashMap<String, User>();
	}

	public boolean addUser(User user) {
		if (!userExists(user.getUserName())) {
			usersList.put(user.getUserName(), user);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeUser(String user) {
		if (userExists(user)) {
			usersList.remove(user);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateUser(User user) {
		if (userExists(user.getUserName())) {
			usersList.remove(user.getUserName());
			usersList.put(user.getUserName(), user);
			return true;
		} else {
			return false;
		}
	}

	public User readUser(String user) {
		if (userExists(user)) {
			return usersList.get(user);
		} else {
			return null;
		}
	}

	public boolean userExists(String username) {
		if (usersList.containsKey(username)) {
			return true;
		} else {
			return false;
		}
	}
}
