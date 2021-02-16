package com.excape.services;

import java.util.List;

import com.excape.beans.User;

public interface UserService {
	
	public User getUser(int id);
	public User getUser(String email);
	public List<User> getAllUsers();
	public List<User> getUsersByLastName(String lastName);
	public List<User> getUsersByBusinessName(String businessName);
	public User addUser(User u);
	public User updateUser(User u);
	public boolean deleteUser(int id);

}
