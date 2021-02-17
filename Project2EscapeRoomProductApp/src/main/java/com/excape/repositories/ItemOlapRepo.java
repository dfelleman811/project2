package com.excape.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excape.beans.ItemOlap;

@Repository
public interface ItemOlapRepo extends CrudRepository<ItemOlap, Integer> {
	
	public List<ItemOlap> findByOrderByTotalQuantitySoldDesc();

}
