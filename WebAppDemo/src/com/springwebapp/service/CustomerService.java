package com.springwebapp.service;

import java.util.List;

import com.springwebapp.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
