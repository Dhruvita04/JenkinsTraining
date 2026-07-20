package com.example.jenkins.services;

import java.util.List;

import com.example.jenkins.models.User;

public interface UsersService {
	
	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
	public User insertUser(User newUser);

	boolean deleteUserById(int id);

	User updateUser(int id, User updatedUser);

	public User addUser(User user);
}