package com.excape.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excape.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User,Integer>{

	List<User> findByLastName(String lastName);
	List<User> findByBusinessName(String businessName);
}
