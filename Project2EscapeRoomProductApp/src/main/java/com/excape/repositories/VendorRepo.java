package com.excape.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excape.beans.Vendor;

@Repository
public interface VendorRepo extends CrudRepository<Vendor, Integer> {
	
	public Vendor findByName(String name);

}
