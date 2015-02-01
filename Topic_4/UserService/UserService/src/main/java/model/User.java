package model;

import java.util.ArrayList;

public class User {

	public String username;
	public String firstname;
	public String lastname;
	public String password;
	public ArrayList<String> friends;
	public ProfilePhoto photo;

	public User() {
		this.username = "Sin usuario";
		this.firstname = "Sin nombre";
		this.lastname = "Sin apellido";
		this.password = "Sin contraseña";
		friends = new ArrayList<String>();
		photo = new ProfilePhoto();
	}

	public User(String userName, String firstName, String lastname, String password) {
		this.username = userName;
		this.firstname = firstName;
		this.lastname = lastname;
		this.password = password;
		friends = new ArrayList<String>();
		photo = new ProfilePhoto();
	}

	public User(User u) {
		this.username = u.username;
		this.firstname = u.firstname;
		this.lastname = u.lastname;
		this.password = u.password;
		this.friends = u.friends;
		this.photo = u.photo;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	public boolean addFriend(String friendUsername) {
		if (!isFriend(friendUsername)) {
			this.friends.add(friendUsername);
			return true;
		} else {
			return false;
		}
	}

	public boolean isFriend(String friendUsername) {
		if (friends.contains(friendUsername)) {
			return true;
		} else {
			return false;
		}
	}

	public ProfilePhoto getPhoto() {
		return photo;
	}

	public void setPhoto(ProfilePhoto photo) {
		this.photo = photo;
	}

	public boolean giveLike(User user) {
		if (isFriend(user.getUserName())) {
			user.getPhoto().setLike(this.getUserName());
			return true;
		} else {
			return false;
		}
	}

	public int friendsQuantity() {
		int totalFriends = 0;
		for (int i = 0; i < friends.size(); i++) {
			totalFriends++;
		}
		return totalFriends;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("\n");
		sb.append(username + "\n");
		sb.append(lastname + ", " + firstname + "\n");
		sb.append("Friends: " + friendsQuantity() + "\n");
		sb.append(photo.toString());
		return sb.toString();
	}
}
