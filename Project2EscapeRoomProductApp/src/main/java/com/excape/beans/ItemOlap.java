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
	private BigDecimal totalProfitMade;
	
	@Column(name = "cost_per_unit")
	private BigDecimal costPerUnit;
	
	@Column(name = "retail_per_unit")
	private BigDecimal retailPerUnit;
	
	@Column(name = "name")
	private String name;

	public ItemOlap() {
		super();
	}

	public ItemOlap(int itemId, int totalQuantitySold, BigDecimal totalRetailEarnings, BigDecimal totalProfitMade, BigDecimal costPerUnit, BigDecimal retailPerUnit, String name) {
		super();
		this.itemId = itemId;
		this.totalQuantitySold = totalQuantitySold;
		this.totalRetailEarnings = totalRetailEarnings;
		this.totalProfitMade = totalProfitMade;
		this.costPerUnit = costPerUnit;
		this.retailPerUnit = retailPerUnit;
		this.name = name;
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

	public BigDecimal getTotalProfitMade() {
		return totalProfitMade;
	}

	public void setTotalProfitMade(BigDecimal totalProfitMade) {
		this.totalProfitMade = totalProfitMade;
	}
	
	public BigDecimal getCostPerUnit() {
		return this.costPerUnit;
	}
	
	public void setCostPerUnit(BigDecimal costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	
	public BigDecimal getRetailPerUnit() {
		return this.retailPerUnit;
	}
	
	public void setRetailPerUnit(BigDecimal retailPerUnit) {
		this.retailPerUnit = retailPerUnit;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "ItemOlap [itemId=" + itemId + ", totalQuantitySold=" + totalQuantitySold + ", totalRetailEarnings="
				+ totalRetailEarnings + ", totalProfit=" + totalProfitMade + ", costPerUnit=" + costPerUnit + 
				", retailPerUnit=" + retailPerUnit + ", name=" + name + "]";
	}
	
	

}
