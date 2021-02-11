package com.excape.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excape.beans.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer>{
	
}
