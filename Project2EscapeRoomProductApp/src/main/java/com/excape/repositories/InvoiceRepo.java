package com.excape.repositories;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.excape.beans.Invoice;

@Repository
public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {
	
	@Query(value = "select nextval('invoices_transaction_id_seq')", nativeQuery = true)
	public int incrementSequence();
	
	@Query(
			value = 
			"insert into invoices(transaction_id, item_id, user_id, item_quantity, user_type, item_name, item_description, retail_price, purchase_date, delivery_date) "
			+ "values(currval('invoices_transaction_id_seq'), :item_id, :user_id, :item_quantity, :user_type, :item_name, :item_description, :retail_price, :purchase_date, :delivery_date)", nativeQuery = true)
	public void customAdd(@Param("item_id") int item_id, @Param("user_id") int user_id, @Param("item_quantity") int item_quantity, @Param("user_type") String user_type, @Param("item_name") String item_name, @Param("item_description") String item_description, @Param("retail_price") BigDecimal retail_price, @Param("purchase_date") Date purchase_date, @Param("delivery_date") Date delivery_date);
}
