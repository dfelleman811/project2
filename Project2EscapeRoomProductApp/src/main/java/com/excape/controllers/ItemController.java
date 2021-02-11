package com.excape.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excape.beans.Item;
import com.excape.services.ItemServices;

@RestController
public class ItemController {
	
	@Autowired
	private ItemServices is;
	
	@PostMapping(value = "/items", consumes = "application/json", produces = "application/json")
	public Item addItem(@RequestBody Item i) {
		
		return is.addItem(i);
	}

}
