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

import com.excape.beans.Vendor;
import com.excape.repositories.VendorRepo;

@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class VendorServicesTests {
	
	@MockBean
	VendorRepo vr;
	
	@Autowired
	VendorServices vs;

	@Test
	void getVendorById() {
		Vendor v = new Vendor(1, "name", "contact", "email", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city", "state", 55555, "notes");
		
		Mockito.when(vr.findById(1)).thenReturn(Optional.of(v));
		Vendor v2 = vs.getVendor(1);
		
		Assertions.assertEquals(v, v2);
	}
	
	@Test
	void getVendorByName() {
		Vendor v = new Vendor(1, "name", "contact", "email", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city", "state", 55555, "notes");
		
		Mockito.when(vr.findByName("name")).thenReturn(v);
		Vendor v2 = vs.getVendor("name");
		
		Assertions.assertEquals(v, v2);
	}
	
	@Test
	void getAllVendors() {
		List<Vendor> list = new ArrayList<Vendor>();
		list.add(new Vendor(1, "name", "contact", "email", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city", "state", 55555, "notes"));
		list.add(new Vendor(2, "name2", "contact2", "email2", new BigDecimal(1234567890L), "website2", "address_12",
				"address_22", "city2", "state2", 12345, "notes2"));
		
		Mockito.when(vr.findAll()).thenReturn(list);
		
		List<Vendor> list2 = vs.getAllVendors();
		
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void addVendor() {
		Vendor v = new Vendor("name", "contact", "email", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city", "state", 55555, "notes");
		
		Mockito.when(vr.save(v)).thenReturn(new Vendor(1, "name", "contact", "email", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city", "state", 55555, "notes"));
		
		Vendor v2 = vs.addVendor(v);
		Assertions.assertEquals(1, v2.getVendor_id());
	}
	
	@Test
	void updateVendor() {
		Vendor v = new Vendor(1, "name", "contact", "email", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city", "state", 55555, "notes");
		Vendor change = new Vendor(1, "name2", "contact2", "email2", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city2", "state", 55555, "notes2");
		
		Mockito.when(vr.save(change)).thenReturn(v = change);
		
		vs.updateVendor(change);
		Assertions.assertEquals(v, change);
	}
	
	@Test
	void deleteVendor() {
		Vendor v = new Vendor(1, "name", "contact", "email", new BigDecimal(5555555555L), "website", "address_1",
				"address_2", "city", "state", 55555, "notes");
		Optional<Vendor> optional = Optional.of(v);
		
		Mockito.when(vr.findById(v.getVendor_id())).thenReturn(optional);
		Mockito.doNothing().when(vr).delete(v);
		
		vs.deleteVendor(1);
	}

}
