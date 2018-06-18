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
	
}
