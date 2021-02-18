package com.excape.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excape.beans.ItemOlap;
import com.excape.repositories.ItemOlapRepo;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
	
	@Autowired
	private ItemOlapRepo ior;

	@Override
	public List<ItemOlap> getStats() {
		return ior.findByOrderByTotalQuantitySoldDesc();
		
	}

	@Override
	public List<ItemOlap> getRevenue() {
		return ior.findByOrderByTotalRetailEarningsDesc();
	}

	@Override
	public List<ItemOlap> getProfit() {
		return ior.findByOrderByTotalProfitMadeDesc();
	}
	
	

}
