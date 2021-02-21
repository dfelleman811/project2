package com.excape.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.excape.beans.ItemOlap;
import com.excape.repositories.ItemOlapRepo;

@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class EmployeeServicesTests {

	@MockBean
	ItemOlapRepo ior;
	
	@Autowired
	EmployeeServices es;
	
	@Test
	void getStats() {
		List<ItemOlap> list = new ArrayList<ItemOlap>();
		list.add(new ItemOlap(4,2, new BigDecimal(25.99), new BigDecimal(50.00), new BigDecimal(14.01), new BigDecimal(10.00),"Item Name 1"));
		list.add(new ItemOlap(7,3, new BigDecimal(11.99), new BigDecimal(48.65), new BigDecimal(12.01), new BigDecimal(5.00),"Item Name 2"));
		
		Mockito.when(ior.findByOrderByTotalQuantitySoldDesc()).thenReturn(list);
		
		List<ItemOlap> list2 = es.getStats();
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void getRevenue() {
		List<ItemOlap> list = new ArrayList<ItemOlap>();
		list.add(new ItemOlap(4,2, new BigDecimal(25.99), new BigDecimal(50.00), new BigDecimal(14.01), new BigDecimal(10.00),"Item Name 1"));
		list.add(new ItemOlap(7,3, new BigDecimal(11.99), new BigDecimal(48.65), new BigDecimal(12.01), new BigDecimal(5.00),"Item Name 2"));
		
		Mockito.when(ior.findByOrderByTotalRetailEarningsDesc()).thenReturn(list);
		
		List<ItemOlap> list2 = es.getRevenue();
		Assertions.assertEquals(list, list2);
		
	}
	
	@Test
	void getProfit() {
		List<ItemOlap> list = new ArrayList<ItemOlap>();
		list.add(new ItemOlap(4,2, new BigDecimal(25.99), new BigDecimal(50.00), new BigDecimal(14.01), new BigDecimal(10.00),"Item Name 1"));
		list.add(new ItemOlap(7,3, new BigDecimal(11.99), new BigDecimal(48.65), new BigDecimal(12.01), new BigDecimal(5.00),"Item Name 2"));
		
		Mockito.when(ior.findByOrderByTotalProfitMadeDesc()).thenReturn(list);
		
		List<ItemOlap> list2 = es.getProfit();
		Assertions.assertEquals(list, list2);
	}

}
