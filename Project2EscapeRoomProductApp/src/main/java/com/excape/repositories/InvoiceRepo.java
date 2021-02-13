package com.excape.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excape.beans.Invoice;

@Repository
public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {
	

}
