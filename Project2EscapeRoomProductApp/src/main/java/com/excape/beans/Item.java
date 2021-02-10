package com.excape.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Item {
	
	@Id
	@Column(name = "item_id", updatable = false)
	@GeneratedValue(generator = "inventory_item_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "inventory_item_id_seq", sequenceName = "inventory_item_id_seq", allocationSize = 1)
	private int item_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "weight_oz")
	private String weight_oz;
	
	@Column(name = "dimensions_in")
	private String dimensions_in;
	
	@Column(name = "num_stocked")
	private int num_stocked;
	
	@Column(name = "num_ordered")
	private int num_ordered;
	
	@Column(name = "time_to_solve_mins")
	private int time_to_solve_mins;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "retail_price")
	private int retail_price;
	
	@Column(name = "vendor_id")
	private int vendor_id;
	
	// No args constructor
	public Item() {
		super();
	}

	// Contructor - no ID
	public Item(String name, String description, String weight_oz, String dimensions_in, int num_stocked,
			int num_ordered, int time_to_solve_mins, String type, int retail_price, int vendor_id) {
		super();
		this.name = name;
		this.description = description;
		this.weight_oz = weight_oz;
		this.dimensions_in = dimensions_in;
		this.num_stocked = num_stocked;
		this.num_ordered = num_ordered;
		this.time_to_solve_mins = time_to_solve_mins;
		this.type = type;
		this.retail_price = retail_price;
		this.vendor_id = vendor_id;
	}

	// Fully parameterized constructor
	public Item(int item_id, String name, String description, String weight_oz, String dimensions_in, int num_stocked,
			int num_ordered, int time_to_solve_mins, String type, int retail_price, int vendor_id) {
		super();
		this.item_id = item_id;
		this.name = name;
		this.description = description;
		this.weight_oz = weight_oz;
		this.dimensions_in = dimensions_in;
		this.num_stocked = num_stocked;
		this.num_ordered = num_ordered;
		this.time_to_solve_mins = time_to_solve_mins;
		this.type = type;
		this.retail_price = retail_price;
		this.vendor_id = vendor_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeight_oz() {
		return weight_oz;
	}

	public void setWeight_oz(String weight_oz) {
		this.weight_oz = weight_oz;
	}

	public String getDimensions_in() {
		return dimensions_in;
	}

	public void setDimensions_in(String dimensions_in) {
		this.dimensions_in = dimensions_in;
	}

	public int getNum_stocked() {
		return num_stocked;
	}

	public void setNum_stocked(int num_stocked) {
		this.num_stocked = num_stocked;
	}

	public int getNum_ordered() {
		return num_ordered;
	}

	public void setNum_ordered(int num_ordered) {
		this.num_ordered = num_ordered;
	}

	public int getTime_to_solve_mins() {
		return time_to_solve_mins;
	}

	public void setTime_to_solve_mins(int time_to_solve_mins) {
		this.time_to_solve_mins = time_to_solve_mins;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(int retail_price) {
		this.retail_price = retail_price;
	}

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", name=" + name + ", description=" + description + ", weight_oz="
				+ weight_oz + ", dimensions_in=" + dimensions_in + ", num_stocked=" + num_stocked + ", num_ordered="
				+ num_ordered + ", time_to_solve_mins=" + time_to_solve_mins + ", type=" + type + ", retail_price="
				+ retail_price + ", vendor_id=" + vendor_id + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dimensions_in == null) {
			if (other.dimensions_in != null)
				return false;
		} else if (!dimensions_in.equals(other.dimensions_in))
			return false;
		if (item_id != other.item_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num_ordered != other.num_ordered)
			return false;
		if (num_stocked != other.num_stocked)
			return false;
		if (retail_price != other.retail_price)
			return false;
		if (time_to_solve_mins != other.time_to_solve_mins)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vendor_id != other.vendor_id)
			return false;
		if (weight_oz == null) {
			if (other.weight_oz != null)
				return false;
		} else if (!weight_oz.equals(other.weight_oz))
			return false;
		return true;
	}
	
	
	
	
}
