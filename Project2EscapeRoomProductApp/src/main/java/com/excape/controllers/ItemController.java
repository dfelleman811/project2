package com.excape.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excape.beans.Item;
import com.excape.services.ItemServices;

@RestController
@CrossOrigin
public class ItemController {
	
	@Autowired
	private ItemServices is;
	
	
	@GetMapping(value = "/items/{id}", produces = "application/json")
	public Item getItem(@PathVariable("id") int id) {
		return is.getItem(id);
	}
	
	
	@GetMapping(value = "items/search", produces = "application/json")
	public Item getItem(@RequestParam(required = true) String name) {
		Item item = is.getItem(name);
		return item;
	}
	
	
	@GetMapping(value = "/items", produces = "application/json")
	public List<Item> getAllItems() {
		List<Item> itemList = is.getAllItems();
		return itemList;
	}
	
	
	@PostMapping(value = "/items", consumes = "application/json", produces = "application/json")
	public Item addItem(@RequestBody Item i) {
		
		return is.addItem(i);
	}

	
	@PutMapping(value = "/items/{id}", consumes = "application/json", produces = "application/json")
	public Item updateItem(@PathVariable("id") int id, @RequestBody Item iChange) {
		iChange.setItem_id(id);
		return is.updateItem(iChange);
	}
	
	
	@DeleteMapping(value = "/items/{id}")
	public boolean deleteItem(@PathVariable("id") int id) {
		return is.deleteItem(id);
	}
	
}
