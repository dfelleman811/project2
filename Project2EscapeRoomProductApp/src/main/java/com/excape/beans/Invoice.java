package com.excape.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(InvoiceId.class)
@Table(name = "invoices")
public class Invoice{
	
	@Id
//	@Column(name = "transaction_id", updatable = false)
//	@GeneratedValue(generator = "invoices_transaction_id_seq", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "invoices_transaction_id_seq", sequenceName = "invoices_transaction_id_seq", allocationSize = 1)
	private int transaction_id;
	
	@Id
	private int item_id;
	
	private int user_id;
	
	private int item_quantity;
	
	private String user_type;
	
	private String item_name;
	
	private String item_description;
	
	private BigDecimal retail_price;
	
	private Date purchase_date;
	
	private Date delivery_date;

	
	public Invoice() {
		super();
	}


	public Invoice(int item_id, int user_id, int item_quantity, String user_type, String item_name,
			String item_description, BigDecimal retail_price, Date purchase_date, Date delivery_date) {
		super();
		this.item_id = item_id;
		this.user_id = user_id;
		this.item_quantity = item_quantity;
		this.user_type = user_type;
		this.item_name = item_name;
		this.item_description = item_description;
		this.retail_price = retail_price;
		this.purchase_date = purchase_date;
		this.delivery_date = delivery_date;
	}


	public Invoice(int transaction_id, int item_id, int user_id, int item_quantity, String user_type, String item_name,
			String item_description, BigDecimal retail_price, Date purchase_date, Date delivery_date) {
		super();
		this.transaction_id = transaction_id;
		this.item_id = item_id;
		this.user_id = user_id;
		this.item_quantity = item_quantity;
		this.user_type = user_type;
		this.item_name = item_name;
		this.item_description = item_description;
		this.retail_price = retail_price;
		this.purchase_date = purchase_date;
		this.delivery_date = delivery_date;
	}


	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public int getItem_id() {
		return item_id;
	}


	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getItem_quantity() {
		return item_quantity;
	}


	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}


	public String getUser_type() {
		return user_type;
	}


	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getItem_description() {
		return item_description;
	}


	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}


	public BigDecimal getRetail_price() {
		return retail_price;
	}


	public void setRetail_price(BigDecimal retail_price) {
		this.retail_price = retail_price;
	}


	public Date getPurchase_date() {
		return purchase_date;
	}


	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}


	public Date getDelivery_date() {
		return delivery_date;
	}


	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}


	@Override
	public String toString() {
		return "Invoice [transaction_id=" + transaction_id + ", item_id=" + item_id + ", user_id=" + user_id
				+ ", item_quantity=" + item_quantity + ", user_type=" + user_type + ", item_name=" + item_name
				+ ", item_description=" + item_description + ", retail_price=" + retail_price + ", purchase_date="
				+ purchase_date + ", delivery_date=" + delivery_date + "]";
	}
	
	
	
	
	

}
