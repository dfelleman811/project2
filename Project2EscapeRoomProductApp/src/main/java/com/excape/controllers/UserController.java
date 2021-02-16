package com.excape.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.excape.beans.User;
import com.excape.services.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService us;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/users", consumes="application/json", produces="application/json")
	public @ResponseBody User addUser(@RequestBody User u) {
		return us.addUser(u);
	}
	
	@GetMapping(value = "/users/{id}", produces = "application/json")
	public User getUser(@PathVariable("id") int id) {
		return us.getUser(id);
	}
	

	@GetMapping(value ="/usersByEmail/{email}", produces = "application/json")
	public User getUserByEmail(@PathVariable("email") String email) {
		System.out.println(us.getUser(email));
		return us.getUser(email);
	}
	
	@GetMapping(value = "/users", produces = "application/json")
	public List<User> getAllUsers(){
		return us.getAllUsers();
	}
	
	@GetMapping(value = "/users/search")
	public List<User> getUsersByLastName(@RequestParam(required=true) String lastName){
		return us.getUsersByLastName(lastName);
	}
	
	@GetMapping(value = "/users/searchByBusiness")
	public List<User> getUsersByBusinessName(@RequestParam(required=true) String businessName){
		return us.getUsersByBusinessName(businessName);
	}
	
	@PutMapping(value="/users/{id}", consumes="application/json", produces="application/json")
	public User updateUser(@PathVariable("id") int id, @RequestBody User u) {
		u.setUser_id(id);
		return us.updateUser(u);
	}
	
	@DeleteMapping(value="/users/{id}")
	public boolean deleteUser(int id) {
		return us.deleteUser(id);
	}

}
