package com.excape.services;

import java.util.List;

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

	@Override
	public Item getItem(int itemId) {
		return ir.findById(itemId).get();
	}
	
	@Override
	public Item getItem(String itemName) {
		return ir.findByNameIgnoreCase(itemName);
	}

	@Override
	public List<Item> getAllItems() {
		return (List<Item>) ir.findAll();
	}

	@Override
	public Item updateItem(Item iChange) {
		return ir.save(iChange);
	}

	@Override
	public boolean deleteItem(int itemId) {
		try {	
			ir.delete(ir.findById(itemId).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
