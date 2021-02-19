package com.excape.services;

import java.util.List;

import com.excape.beans.Item;
import com.excape.beans.ItemOlap;

/**
 * Interface for Employee Services.
 * 
 * In order to populate the most purchased items, we need to compile a few different services.
 * Items and Invoices. 
 * 
 * @author DanielFelleman
 *
 */
public interface EmployeeServices {
	
	// Most popular items
	public List<ItemOlap> getStats();
	
	
	// Highest Revenue
	public List<ItemOlap> getRevenue();
	
	// Highest Profit
	public List<ItemOlap> getProfit();
}
