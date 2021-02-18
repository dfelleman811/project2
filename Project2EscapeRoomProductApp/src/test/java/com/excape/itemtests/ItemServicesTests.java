package com.excape.itemtests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.excape.beans.Item;
import com.excape.repositories.ItemRepo;
import com.excape.services.ItemServicesImpl;

@RunWith(MockitoJUnitRunner.class)
public class ItemServicesTests {

	@InjectMocks
	private ItemServicesImpl itemService;
	
	@Mock
	private ItemRepo itemRepo;
	
	@Test
	public void getAllItemsTest() {
		when(itemRepo.findAll()).thenReturn(Stream.of(new Item(), 
				new Item()).collect(Collectors.toList()));
		assertEquals(2, itemService.getAllItems().size());
	}
	
	
	

}
