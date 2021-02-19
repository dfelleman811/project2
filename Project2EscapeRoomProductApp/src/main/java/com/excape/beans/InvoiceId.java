package com.excape.beans;

import java.io.Serializable;

public class InvoiceId implements Serializable{
	
	private int transaction_id;
	
	private int item_id;

	public InvoiceId() {
		super();
	}

	public InvoiceId(int transaction_id, int item_id) {
		super();
		this.transaction_id = transaction_id;
		this.item_id = item_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item_id;
		result = prime * result + transaction_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceId other = (InvoiceId) obj;
		if (item_id != other.item_id)
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		return true;
	}
	
	
	
	
	
}
