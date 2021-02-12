package com.excape.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excape.beans.Vendor;
import com.excape.repositories.VendorRepo;

@Service
public class VendorServicesImpl implements VendorServices {
	
	@Autowired
	public VendorRepo vr;
	
	@Override
	public Vendor getVendor(int vendorId) {
		return vr.findById(vendorId).get();
	}

	@Override
	public Vendor getVendor(String vendorName) {
		return vr.findByName(vendorName);
	}

	@Override
	public List<Vendor> getAllVendors() {
		List<Vendor> vendorList = (List<Vendor>) vr.findAll();
		return vendorList;
	}

	@Override
	public Vendor addVendor(Vendor v) {
		return vr.save(v);
	}

	@Override
	public Vendor updateVendor(Vendor vChange) {
		return vr.save(vChange);
	}

	@Override
	public boolean deleteVendor(int vendorId) {
		
		try {
			vr.delete(vr.findById(vendorId).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
