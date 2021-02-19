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
import org.springframework.web.bind.annotation.RestController;

import com.excape.beans.Invoice;
import com.excape.services.InvoiceServices;

@RestController
@CrossOrigin
public class InvoiceController {

	@Autowired
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
	public void addInvoice(@RequestBody List<Invoice> invoiceList) {
		int id = invs.incrementSequence();
		for(int i = 0; i < invoiceList.size(); i++) {
//			Invoice currInvoice = new Invoice();
			Invoice currInvoice = invoiceList.get(i);
			currInvoice.setTransaction_id(id);
			invs.addInvoice(currInvoice);
			System.err.println("--------------");
			System.out.println("Current invoice: " + currInvoice);
			System.out.println("Current value of i = " + i);
			System.out.println("invoiceList.size() = " + invoiceList.size());
		}
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
