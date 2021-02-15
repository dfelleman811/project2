package com.excape.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excape.beans.Invoice;
import com.excape.services.InvoiceServices;

@RestController
@CrossOrigin
public class InvoiceController {
	
	private InvoiceServices invs;
	
	@GetMapping(value = "/invoices/{id}", produces = "application/json")
	public Invoice getInvoice(@PathVariable("id") int transaction_id) {
		return invs.getInvoice(transaction_id);
	}
	
	
	@GetMapping(value = "/invoices", produces = "application/json")
	public List<Invoice> getAllInvoices() {
		List<Invoice> invList = invs.getAllInvoices();
		return invList;
	}
	
	
	@PostMapping(value = "/invoices", consumes = "application/json", produces = "application/json")
	public Invoice addInvoice(@RequestBody Invoice i) {
		return invs.addInvoice(i);
	}
	
	
	@PutMapping(value = "/invoices/{id}")
	public Invoice updateInvoice(@PathVariable int id, @RequestBody Invoice invChange) {
		invChange.setTransaction_id(id);
		return invs.updateInvoice(invChange);
	}
	
	
	@DeleteMapping(value = "invoices/{id}")
	public boolean deleteInvoice(int transaction_id) {
		return invs.deleteInvoice(transaction_id);
	}
	

}
