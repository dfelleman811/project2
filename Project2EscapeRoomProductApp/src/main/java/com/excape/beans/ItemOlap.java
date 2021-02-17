package com.excape.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_olap")
public class ItemOlap {
	
	@Id
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "total_quantity_sold")
	private int totalQuantitySold;
	
	@Column(name = "total_retail_earnings")
	private BigDecimal totalRetailEarnings;
	
	@Column(name = "total_profit_made")
	private BigDecimal totalProfit;

	public ItemOlap() {
		super();
	}

	public ItemOlap(int itemId, int totalQuantitySold, BigDecimal totalRetailEarnings, BigDecimal totalProfit) {
		super();
		this.itemId = itemId;
		this.totalQuantitySold = totalQuantitySold;
		this.totalRetailEarnings = totalRetailEarnings;
		this.totalProfit = totalProfit;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getTotalQuantitySold() {
		return totalQuantitySold;
	}

	public void setTotalQuantitySold(int totalQuantitySold) {
		this.totalQuantitySold = totalQuantitySold;
	}

	public BigDecimal getTotalRetailEarnings() {
		return totalRetailEarnings;
	}

	public void setTotalRetailEarnings(BigDecimal totalRetailEarnings) {
		this.totalRetailEarnings = totalRetailEarnings;
	}

	public BigDecimal getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

	@Override
	public String toString() {
		return "ItemOlap [itemId=" + itemId + ", totalQuantitySold=" + totalQuantitySold + ", totalRetailEarnings="
				+ totalRetailEarnings + ", totalProfit=" + totalProfit + "]";
	}
	
	

}
