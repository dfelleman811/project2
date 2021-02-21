package com.excape.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.excape.beans.Item;
import com.excape.repositories.ItemRepo;

@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class ItemServicesTests {
	
	@MockBean
	ItemRepo ir;
	
	@Autowired
	ItemServices is;

	@Test
	void addItem() {
		Item i = new Item("Name","Description", new BigDecimal(10.00), 
				"dimensions", 10, 10, 5.00, "type", new BigDecimal(19.99), 5);
		
		Mockito.when(ir.save(i)).thenReturn(new Item(0, i.getName(), i.getDescription(), i.getWeight_oz(), i.getDimensions_in(), 
				i.getNum_stocked(), i.getNum_ordered(), i.getTime_to_solve_mins(), i.getType(), i.getRetail_price(), i.getVendor_id()));
		
		Item i2 = is.addItem(i);
		System.out.println(i2.toString());
		Assertions.assertEquals(0, i2.getItem_id());
	}
	
	@Test
	void getItemById() {
		Item i = new Item(1, "Name","Description", new BigDecimal(10.00), 
				"dimensions", 10, 10, 5.00, "type", new BigDecimal(19.99), 5);
		Mockito.when(ir.findById(1)).thenReturn(Optional.of(i));
		
		Item i2 = is.getItem(1);
		
		Assertions.assertEquals(i, i2);
	}
	
	@Test
	void getItemByName() {
		Item i = new Item(1, "Item Name","Description", new BigDecimal(10.00), 
				"dimensions", 10, 10, 5.00, "type", new BigDecimal(19.99), 5);
		
		Mockito.when(ir.findByNameIgnoreCase("Item Name")).thenReturn(i);
		
		Item i2 = is.getItem("Item Name");
		
		Assertions.assertEquals(i, i2);
	}
	
	@Test
	void getAllItems() {
		List<Item> list = new ArrayList<Item>();
		list.add(new Item(1, "Item Name","Description", new BigDecimal(10.00), 
				"dimensions", 10, 10, 5.00, "type", new BigDecimal(19.99), 5));
		list.add(new Item(2, "Item Name","Description", new BigDecimal(15.00), 
				"dimensions", 5, 5, 10.00, "type", new BigDecimal(14.99), 5));
		
		Mockito.when(ir.findAll()).thenReturn(list);
		
		List<Item> list2 = (List<Item>) is.getAllItems();
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void updateItem() {
		Item i = new Item(1, "Item Name","Description", new BigDecimal(10.00), 
				"dimensions", 10, 10, 5.00, "type", new BigDecimal(19.99), 5);
		
		Item change = new Item(1, "Item Name Changed","Description Changed", new BigDecimal(15.00), 
				"dimensions changed", 11, 11, 6.00, "type changed", new BigDecimal(25.99), 6);
		
		Mockito.when(ir.save(change)).thenReturn(i = change);
		
		is.updateItem(change);
		
		Assertions.assertEquals(i, change);
	}
	
	@Test
	void deleteItem() {
		Item i = new Item(1, "Item Name","Description", new BigDecimal(10.00), 
				"dimensions", 10, 10, 5.00, "type", new BigDecimal(19.99), 5);
		Optional<Item> optionalItem = Optional.of(i);
		
		Mockito.when(ir.findById(i.getItem_id())).thenReturn(optionalItem);
		Mockito.doNothing().when(ir).delete(i);
		is.deleteItem(1);
	}

}
