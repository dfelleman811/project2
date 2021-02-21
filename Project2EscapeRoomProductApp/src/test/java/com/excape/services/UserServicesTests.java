package com.excape.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.excape.beans.User;
import com.excape.repositories.UserRepo;

@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class UserServicesTests {
	
	@MockBean
	UserRepo ur;
	
	@Autowired
	UserService us;

	@Test
	void addUser() {
		User u = new User("firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1);
		
		Mockito.when(ur.save(u)).thenReturn(new User(0, "firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1));
		
		u = us.addUser(u);
		Assertions.assertEquals(0, u.getUser_id());
	}
	
	@Test
	void getUserByEmail() {
		User u = new User("firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1);
		
		Mockito.when(ur.findByEmail("email")).thenReturn(u);
		
		User u2 = us.getUser("email");
		
		Assertions.assertEquals(u, u2);
	}
	
	@Test
	void getAllUsers() {
		List<User> list = new ArrayList<User>();
		list.add(new User("firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1));
		list.add(new User("firstName2", "lastName2", "businessName2", "email2", new BigDecimal(1234567890L),
				"address12", "address22", "city2", "state2", "country2", 12345, "username2", "password2", 1));
		
		Mockito.when(ur.findAll()).thenReturn(list);
		
		List<User> list2 = us.getAllUsers();
		
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void getUserById() {
		User u = new User(1, "firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1);
		
		Mockito.when(ur.findById(1)).thenReturn(Optional.of(u));
		
		User u2 = us.getUser(1);
		
		Assertions.assertEquals(u, u2);
	}
	
	@Test
	void getUsersByLastName() {
		List<User> list = new ArrayList<User>();
		list.add(new User("firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1));
		list.add(new User("firstName2", "lastName", "businessName2", "email2", new BigDecimal(1234567890L),
				"address12", "address22", "city2", "state2", "country2", 12345, "username2", "password2", 1));
		
		Mockito.when(ur.findByLastNameIgnoreCase("lastName")).thenReturn(list);
		
		List<User> list2 = us.getUsersByLastName("lastName");
		
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void getUsersByBusinessName() {
		List<User> list = new ArrayList<User>();
		list.add(new User("firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1));
		list.add(new User("firstName2", "lastName2", "businessName", "email2", new BigDecimal(1234567890L),
				"address12", "address22", "city2", "state2", "country2", 12345, "username2", "password2", 1));
		
		Mockito.when(ur.findByBusinessNameIgnoreCase("businessName")).thenReturn(list);
		
		List<User> list2 = us.getUsersByBusinessName("businessName");
		
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void updateUser() {
		User u = new User(1, "firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1);
		
		User change = new User(1, "firstName2", "lastName", "businessName2", "email2", new BigDecimal(1234567890L),
				"address12", "address22", "city2", "state2", "country2", 12345, "username2", "password2", 1);
		
		Mockito.when(ur.save(change)).thenReturn(u = change);
		
		us.updateUser(change);
		
		Assertions.assertEquals(u, change);
	}
	
	@Test
	void deleteUser() {
		User u = new User(1, "firstName", "lastName", "businessName", "email", new BigDecimal(5555555555L),
				"address1", "address2", "city", "state", "country", 55555, "username", "password", 1);
		Optional<User> optional = Optional.of(u);
		
		Mockito.when(ur.findById(u.getUser_id())).thenReturn(optional);
		Mockito.doNothing().when(ur).delete(u);
		us.deleteUser(1);
	}

}
