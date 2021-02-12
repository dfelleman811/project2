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
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String businessName;
	
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
		this.firstName = first_name;
		this.lastName = last_name;
		this.businessName = business_name;
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
		this.userId = user_id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.businessName = business_name;
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
		return userId;
	}


	public void setUser_id(int user_id) {
		this.userId = user_id;
	}


	public String getFirst_name() {
		return firstName;
	}


	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}


	public String getLast_name() {
		return lastName;
	}


	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}


	public String getBusiness_name() {
		return businessName;
	}


	public void setBusiness_name(String business_name) {
		this.businessName = business_name;
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
		return "Users [user_id=" + userId + ", first_name=" + firstName + ", last_name=" + lastName
				+ ", business_name=" + businessName + ", email=" + email + ", phone=" + phone + ", address_1="
				+ address_1 + ", address_2=" + address_2 + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip=" + zip + "]";
	}
	
	
}
