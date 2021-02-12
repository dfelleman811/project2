package com.excape.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {

	@Id
	@Column(name = "vendor_id", updatable = false)
	@GeneratedValue(generator = "vendors_vendor_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "vendors_vendor_id_seq", sequenceName = "vendors_vendor_id_seq", allocationSize = 1)
	private int vendor_id;
	
	private String name;
	
	private String contact;
	
	private String email;
	
	private BigDecimal phone;
	
	private String website;
	
	private String address_1;
	
	private String address_2;
	
	private String city;
	
	private String state;
	
	private int zip;
	
	private String notes;

	
	public Vendor() {
		super();
	}


	public Vendor(String name, String contact, String email, BigDecimal phone, String website, String address_1,
			String address_2, String city, String state, int zip, String notes) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.notes = notes;
	}


	public Vendor(int vendor_id, String name, String contact, String email, BigDecimal phone, String website,
			String address_1, String address_2, String city, String state, int zip, String notes) {
		super();
		this.vendor_id = vendor_id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.notes = notes;
	}


	public int getVendor_id() {
		return vendor_id;
	}


	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public BigDecimal getPhone() {
		return phone;
	}


	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getAddress_1() {
		return address_1;
	}


	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}


	public String getAddress_2() {
		return address_2;
	}


	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	@Override
	public String toString() {
		return "Vendor [vendor_id=" + vendor_id + ", name=" + name + ", contact=" + contact + ", email=" + email
				+ ", phone=" + phone + ", website=" + website + ", address_1=" + address_1 + ", address_2=" + address_2
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", notes=" + notes + "]";
	}
	
	
	
	
	
	
	
}
