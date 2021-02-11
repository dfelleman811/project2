package com.excape.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excape.beans.Item;
import com.excape.repositories.ItemRepo;

@Service
public class ItemServicesImpl implements ItemServices {

	@Autowired
	ItemRepo ir;
	
	@Override
	public Item addItem(Item i) {
		ir.save(i);
		return i;
	}

}
