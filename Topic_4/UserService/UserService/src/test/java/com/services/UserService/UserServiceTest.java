package com.services.UserService;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import model.User;

import org.junit.Test;

import services.UserService;
import services.UserServiceFactory;

public class UserServiceTest {

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Test
	public void localServiceUserCreationTest() {
		System.setOut(new PrintStream(outContent));
		UserService service = UserServiceFactory.getLocalService();
		User user = new User("aldivaca", "Aldana Yael", "Vaca", "1234");
		service.createUser(user);
		assertEquals("User created", outContent.toString());

	}

	@Test
	public void localServiceUserDuplicateTest() {
		System.setOut(new PrintStream(outContent));
		UserService service = UserServiceFactory.getLocalService();
		User user = new User("aldivaca", "Aldana Yael", "Vaca", "1234");
		service.createUser(user);
		service.createUser(user);
		assertEquals("User createdUser already exists", outContent.toString());

	}

	@Test
	public void localServiceUserDeleteTest() {
		System.setOut(new PrintStream(outContent));
		UserService service = UserServiceFactory.getLocalService();
		User user = new User("aldivaca", "Aldana Yael", "Vaca", "1234");
		service.createUser(user);
		service.deleteUser("aldivaca");
		assertEquals("User createdUser deleted", outContent.toString());

	}

	@Test
	public void localServiceUserReadTest() {
		System.setOut(new PrintStream(outContent));
		UserService service = UserServiceFactory.getLocalService();
		User user = new User("aldivaca", "Aldana Yael", "Vaca", "1234");
		service.createUser(user);
		service.readUser("aldivaca");
		assertEquals("User created\naldivaca\nVaca, Aldana Yael\nFriends: 0\n" + "Profile Photo: No resources found\t \t" + new Date()
				+ "\n Likes: 0", outContent.toString());

	}

	@Test
	public void localServiceUserUpdateTest() {
		System.setOut(new PrintStream(outContent));
		UserService service = UserServiceFactory.getLocalService();
		User user = new User("aldivaca", "Aldana Yael", "Vaca", "1234");
		service.createUser(user);
		user = new User("aldivaca", "Melina Ayelen", "Vaca", "1245");
		service.updateUser(user);
		assertEquals("User createdUser updated", outContent.toString());

	}

	@Test
	public void localServiceAddFriendTest() {
		System.setOut(new PrintStream(outContent));
		UserService service = UserServiceFactory.getLocalService();
		User user = new User("aldivaca", "Aldana Yael", "Vaca", "1234");
		service.createUser(user);
		user = new User("melivaca", "Melina Ayelen", "Vaca", "1245");
		service.createUser(user);
		service.addFriend(user, "aldivaca");
		assertEquals("User createdUser createdFriend added", outContent.toString());

	}

	@Test
	public void localServiceGiveLikeTest() {
		System.setOut(new PrintStream(outContent));
		UserService service = UserServiceFactory.getLocalService();
		User user = new User("aldivaca", "Aldana Yael", "Vaca", "1234");
		service.createUser(user);
		user = new User("melivaca", "Melina Ayelen", "Vaca", "1245");
		service.createUser(user);
		service.addFriend(user, "aldivaca");
		service.giveLike(user, "aldivaca");
		assertEquals("User createdUser createdFriend addedYou like aldivaca's profile photo", outContent.toString());
		service.readUser("aldivaca");
		assertEquals("User createdUser createdFriend addedYou like aldivaca's profile photo\naldivaca\nVaca, Aldana Yael\nFriends: 0\n"
				+ "Profile Photo: No resources found\t \t" + new Date() + "\n Likes: 1", outContent.toString());
	}
}
