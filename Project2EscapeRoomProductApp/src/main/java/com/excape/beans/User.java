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
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id", updatable = false)
	@GeneratedValue(generator = "users_user_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "users_user_id_seq", sequenceName = "users_user_id_seq", allocationSize = 1)
	private int user_id;
	
	private String first_name;
	
	private String last_name;
	
	private String business_name;
	
	private String email;
	
	private BigDecimal phone;
	
	private String address_1;
	
	private String address_2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int zip;
	
	
	public User() {
		super();
	}


	public User(String first_name, String last_name, String business_name, String email, BigDecimal phone,
			String address_1, String address_2, String city, String state, String country, int zip) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.business_name = business_name;
		this.email = email;
		this.phone = phone;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}


	public User(int user_id, String first_name, String last_name, String business_name, String email, BigDecimal phone,
			String address_1, String address_2, String city, String state, String country, int zip) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.business_name = business_name;
		this.email = email;
		this.phone = phone;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getBusiness_name() {
		return business_name;
	}


	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public java.math.BigDecimal getPhone() {
		return phone;
	}


	public void setPhone(java.math.BigDecimal phone) {
		this.phone = phone;
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


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", business_name=" + business_name + ", email=" + email + ", phone=" + phone + ", address_1="
				+ address_1 + ", address_2=" + address_2 + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip=" + zip + "]";
	}
	
	
}
