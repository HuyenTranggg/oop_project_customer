package com.oopproject.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oopproject.demo.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	@Query("SELECT c FROM Customer c WHERE " +
       "LOWER(c.customerID) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	   "LOWER(c.customerName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	   "LOWER(c.customerEmail) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	   "LOWER(c.customerAddress) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	   "c.customerPhone LIKE CONCAT('%', :keyword, '%')")
	List<Customer> findByKeyword(@Param("keyword") String keyword);
}
