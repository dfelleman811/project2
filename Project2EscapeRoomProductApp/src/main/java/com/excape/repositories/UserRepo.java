package com.excape.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excape.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User,Integer>{

	List<User> findByLastNameIgnoreCase(String lastName);
	List<User> findByBusinessNameIgnoreCase(String businessName);
	User findByEmail(String email);
}
