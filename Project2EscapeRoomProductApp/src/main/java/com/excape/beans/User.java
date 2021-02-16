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
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "business_name")
	private String businessName;
	
	private String email;
	
	private BigDecimal phone;
	
	@Column(name = "address_1")
	private String address1;
	
	@Column(name = "address_2")
	private String address2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int zip;
	
	private String username;
	
	private String password;
	
	private int employee;
	
	
	public User() {
		super();
	}


	public User(String firstName, String lastName, String businessName, String email, BigDecimal phone,
			String address1, String address2, String city, String state, String country, int zip, String username, String password, int employee) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessName = businessName;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.username = username;
		this.password = password;
		this.employee = employee;
	}


	public User(int user_id, String firstName, String lastName, String businessName, String email, BigDecimal phone,
			String address1, String address2, String city, String state, String country, int zip, String username, String password, int employee) {
		super();
		this.userId = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessName = businessName;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.username = username;
		this.password = password;
		this.employee = employee;
	}


	public int getUser_id() {
		return userId;
	}


	public void setUser_id(int user_id) {
		this.userId = user_id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
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
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(int employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Users [user_id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", businessName=" + businessName + ", email=" + email + ", phone=" + phone + ", address_1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip=" + zip + ", password=" + password + "]";
	}
	
	
}
