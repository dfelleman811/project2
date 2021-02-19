package com.excape.services;

import java.util.List;

import com.excape.beans.Invoice;

public interface InvoiceServices {
	
	
	public Invoice getInvoice(int transaction_id);
	
	public List<Invoice> getAllInvoices();
	
	public Invoice addInvoice(Invoice inv);
	
	public Invoice updateInvoice(Invoice invChange);
	
	public boolean deleteInvoice(int transaction_id);
	
	public int incrementSequence();

}
