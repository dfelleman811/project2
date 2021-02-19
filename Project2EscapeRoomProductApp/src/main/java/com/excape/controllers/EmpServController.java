package com.excape.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excape.beans.ItemOlap;
import com.excape.services.EmployeeServices;

@RestController
@CrossOrigin
public class EmpServController {
	
	@Autowired
	private EmployeeServices es;
	
	@GetMapping(value = "/itemsolapQuantity", produces = "application/json")
	public List<ItemOlap> getMostPurchased() {
		return es.getStats();
	}

	@GetMapping(value = "/itemsolapRevenue", produces = "application/json")
	public List<ItemOlap> getMostRevenue() {
		return es.getRevenue();
	}
	
	@GetMapping(value = "/itemsolapProfit", produces = "application/json")
	public List<ItemOlap> getMostProfit() {
		return es.getProfit();
	}
}
