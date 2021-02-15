package com.excape.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excape.beans.User;
import com.excape.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo ur;
	
	@Override
	public User addUser(User u) {
		ur.save(u);
		return u;
	}
	
	@Override
	public User getUser(String email) {
		return ur.findByEmail(email);
	}
	
	
	@Override
	public List<User> getAllUsers(){
		return (List<User>) ur.findAll();
	}

	@Override
	public User getUser(int id) {
		return ur.findById(id).get();
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		return (List<User>) ur.findByLastNameIgnoreCase(lastName);
	}

	@Override
	public List<User> getUsersByBusinessName(String businessName) {
		return (List<User>) ur.findByBusinessNameIgnoreCase(businessName);
	}

	@Override
	public User updateUser(User u) {
		return ur.save(u);
	}

	@Override
	public boolean deleteUser(int id) {
		ur.delete(ur.findById(id).get());
		return true;
	}

	
	

}
