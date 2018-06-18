package com.springwebapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.springwebapp.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create querry
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", 
															Customer.class);
		
		//get the lsit of customers from query 
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theId){
			
		//get current HIB seession
		Session currentSession = sessionFactory.getCurrentSession();
		//read from DB using ID
		Customer theCustomer = currentSession.get(Customer.class, theId);
				
		return theCustomer;
	}

}
