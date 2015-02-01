package services;

import model.User;
import model.UsersList;

public class UserServiceImplementation implements UserService {

	public UsersList database;

	public UserServiceImplementation() {
		database = new UsersList();
	}

	public void createUser(User user) {
		boolean result = database.addUser(user);
		if (result) {
			System.out.print("User created");
		} else {
			System.out.print("User already exists");
		}
	}

	public void readUser(String username) {
		System.out.print(database.readUser(username).toString());
	}

	public void updateUser(User user) {
		boolean result = database.updateUser(user);
		if (result) {
			System.out.print("User updated");
		} else {
			System.out.print("Update aborted");
		}
	}

	public void deleteUser(String username) {
		boolean result = database.removeUser(username);
		if (result) {
			System.out.print("User deleted");
		} else {
			System.out.print("User cannot be deleted");
		}
	}

	public void addFriend(User actualLogin, String username) {
		if (database.userExists(username)) {
			boolean result = actualLogin.addFriend(username);
			if (result) {
				System.out.print("Friend added");
			} else {
				System.out.print("You're already a friend of this user " + username);
			}
		} else {
			System.out.print("Cannot add a friend who's not in the database");
		}
	}

	public void giveLike(User actualLogin, String username) {
		if (database.userExists(username)) {
			User photoOwner = database.readUser(username);
			boolean result = actualLogin.giveLike(photoOwner);
			if (result) {
				System.out.print("You like " + username + "'s profile photo");
			} else {
				System.out.print("You're not a friend of " + username);
			}
		} else {
			System.out.print("The user is not in the database");
		}
	}

}
