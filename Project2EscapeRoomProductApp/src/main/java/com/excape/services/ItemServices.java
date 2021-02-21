package com.excape.services;

import java.util.List;

import com.excape.beans.Item;

public interface ItemServices {

	public Item getItem(int itemId);
	
	public Item getItem(String itemName);

	public List<Item> getAllItems();
	
	public Item addItem(Item i);
	
	public Item updateItem(Item iChange);
	
	public boolean deleteItem(int itemId);
}
