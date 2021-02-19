package com.excape.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.excape.beans.Invoice;
import com.excape.repositories.InvoiceRepo;

@Service
public class InvoiceServicesImpl implements InvoiceServices {

	@Autowired
	private InvoiceRepo invr;
	
	
	@Override
	public Invoice getInvoice(int transaction_id) {
		return invr.findById(transaction_id).get();
	}

	@Override
	public List<Invoice> getAllInvoices() {
		List<Invoice> invList = (List<Invoice>) invr.findAll();
		return invList;
	}

//	@Override
//	public void addInvoice(Invoice inv) {
//		//invr.customAdd(inv.getItem_id(), inv.getUser_id(), inv.getItem_quantity(), inv.getUser_type(), inv.getItem_name(), inv.getItem_description(), inv.getRetail_price(), inv.getPurchase_date(), inv.getDelivery_date());
//	}
	
	@Override
	public Invoice addInvoice(Invoice inv) {
		return invr.save(inv);
	}

	@Override
	public Invoice updateInvoice(Invoice invChange) {
		return invr.save(invChange);
	}

	@Override
	public boolean deleteInvoice(int transaction_id) {
		try {
			invr.delete(invr.findById(transaction_id).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public int incrementSequence() {
		return invr.incrementSequence();
	}
	


}
