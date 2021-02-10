package com.excape.beans;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {
	

	// a transaction can have many items
	// an item can be on many transactions
	// This is a Many to Many relationship
	
	
	private Transaction transaction;
	
	
	private Item item;
	
	
	
}
