/**
 * 
 */
package com.springwebapp.dao;

import java.util.List;
import com.springwebapp.entity.Customer;

/**
 * @author Paweł
 *
 */
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
	
}
