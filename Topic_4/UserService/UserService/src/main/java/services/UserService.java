package services;

import model.User;

public interface UserService {

	public void createUser(User user);

	public void readUser(String username);

	public void updateUser(User user);

	public void deleteUser(String username);

	public void addFriend(User actualLogin, String username);

	public void giveLike(User actualLogin, String username);

}
