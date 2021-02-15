package com.excape.beans;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@Column(name = "transaction_id", updatable = false)
//	@GeneratedValue(generator = "transactions_transaction_id_seq", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "transactions_transaction_id_seq", sequenceName = "transactions_transaction_id_seq", allocationSize = 1)
	private int transaction_id;
	
	private Date date;
	
	private int user_id;
	
	private BigDecimal sale_price;
	
	
	// TODO Need to add in 'join table' - not sure how.... do I add a Class here as a field? Or maybe I do this in the 
	// bean that actually will be the join table - invoices?
	
	// One Transaction can have many items
	@OneToMany
	@JoinTable(name = "invoices", joinColumns = @JoinColumn(name = "transaction_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items; 
	
	

	public Transaction() {
		super();
	}

	public Transaction(Date date, int user_id, BigDecimal sale_price) {
		super();
		this.date = date;
		this.user_id = user_id;
		this.sale_price = sale_price;
	}

	public Transaction(int transaction_id, Date date, int user_id, BigDecimal sale_price) {
		super();
		this.transaction_id = transaction_id;
		this.date = date;
		this.user_id = user_id;
		this.sale_price = sale_price;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public BigDecimal getSale_price() {
		return sale_price;
	}

	public void setSale_price(BigDecimal sale_price) {
		this.sale_price = sale_price;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", date=" + date + ", user_id=" + user_id
				+ ", sale_price=" + sale_price + "]";
	}
	

	

}
