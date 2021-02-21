package com.excape.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.excape.beans.Invoice;
import com.excape.repositories.InvoiceRepo;

@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class InvoiceServicesTests {
	
	@MockBean InvoiceRepo ir;
	
	@Autowired
	InvoiceServices is;

	@Test
	void getInvoice() {
		Invoice inv = new Invoice(1, 1, 1, "customer", "Item Name",
				"Item Description", new BigDecimal(10.99), new Date(1613934531036L), new Date(1613934531036L));
		Mockito.when(ir.findById(1)).thenReturn(Optional.of(inv));
		
		Invoice inv2 = is.getInvoice(1);
		
		Assertions.assertEquals(inv, inv2);
		
	}
	
	@Test
	void getAllInvoices() {
		List<Invoice> list = new ArrayList<Invoice>();
		list.add(new Invoice(1, 1, 1, "customer", "Item Name",
				"Item Description", new BigDecimal(10.99), new Date(1613934531036L), new Date(1613934531036L)));
		list.add(new Invoice(2, 2, 2, "customer", "Item Name",
				"Item Description", new BigDecimal(10.99), new Date(1613934531036L), new Date(1613934531036L)));
		
		Mockito.when(ir.findAll()).thenReturn(list);
		
		List<Invoice> list2 = (List<Invoice>) is.getAllInvoices();
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void addInvoice() {
		Invoice inv = new Invoice(1, 1, 1, "customer", "Item Name",
				"Item Description", new BigDecimal(10.99), new Date(1613934531036L), new Date(1613934531036L));
		
		Mockito.when(ir.save(inv)).thenReturn(new Invoice(1, inv.getItem_id(), inv.getUser_id(), inv.getItem_quantity(), inv.getUser_type(), inv.getItem_name(),
				inv.getItem_description(), inv.getRetail_price(), inv.getPurchase_date(), inv.getDelivery_date()));
		
		inv = is.addInvoice(inv);
		Assertions.assertEquals(1, inv.getTransaction_id());
	}
	
	@Test
	void updateInvoice() {
		Invoice inv = new Invoice(1, 1, 1, 1, "customer", "Item Name",
				"Item Description", new BigDecimal(10.99), new Date(1613934531036L), new Date(1613934531036L));
		
		Invoice change = new Invoice(1, 2, 2, 2, "customer", "Item Name",
				"Item Description", new BigDecimal(10.99), new Date(1613934531036L), new Date(1613934531036L));
		
		Mockito.when(ir.save(change)).thenReturn(inv = change);
		
		is.updateInvoice(change);
		
		Assertions.assertEquals(2, inv.getItem_quantity());
	}
	
	@Test
	void deleteInvoice() {
		Invoice inv = new Invoice(1, 1, 1, 1, "customer", "Item Name",
				"Item Description", new BigDecimal(10.99), new Date(1613934531036L), new Date(1613934531036L));
		Optional<Invoice> optionI = Optional.of(inv);
		
		Mockito.when(ir.findById(inv.getTransaction_id())).thenReturn(optionI);
		Mockito.doNothing().when(ir).delete(inv);
		is.deleteInvoice(1);
	}

}
