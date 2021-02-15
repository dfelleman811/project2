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

import com.excape.beans.Vendor;
import com.excape.services.VendorServices;

@RestController
@CrossOrigin
public class VendorController {

	@Autowired
	private VendorServices vs;
	
	
	@GetMapping(value = "/vendors/{id}", produces = "application/json")
	public Vendor getVendor(@PathVariable("id") int id) {
		return vs.getVendor(id);
	}
	
	
	@GetMapping(value = "/vendors/search", produces = "application/json")
	public Vendor getVendor(@RequestParam(required = true) String name) {
		return vs.getVendor(name);
	}
	
	
	@GetMapping(value = "/vendors", produces = "application/json")
	public List<Vendor> getAllVendors() {
		List<Vendor> vendorList = vs.getAllVendors();
		return vendorList;
	}
	
	
	@PostMapping(value = "/vendors", consumes = "application/json", produces = "application/json")
	public Vendor addVendor(@RequestBody Vendor v) {
		return vs.addVendor(v);
	}
	
	
	@PutMapping(value = "/vendors/{id}", consumes = "application/json", produces = "application/json")
	public Vendor updateVendor(@PathVariable("id") int id, @RequestBody Vendor vChange) {
		vChange.setVendor_id(id);
		return vs.updateVendor(vChange);
	}
	
	@DeleteMapping(value = "vendors/{id}")
	public boolean deleteVendor(@PathVariable("id") int id) {
		return vs.deleteVendor(id);
	}
	
	
}
