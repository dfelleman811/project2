package com.excape.services;

import java.util.List;

import com.excape.beans.Vendor;

public interface VendorServices {
	
	public Vendor getVendor(int vendorId);
	
	public Vendor getVendor(String vendorName);
	
	public List<Vendor> getAllVendors();
	
	public Vendor addVendor(Vendor v);
	
	public Vendor updateVendor(Vendor vChange);
	
	public boolean deleteVendor(int vendorId);

}
