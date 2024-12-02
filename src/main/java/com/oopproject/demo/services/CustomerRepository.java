package com.oopproject.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oopproject.demo.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
