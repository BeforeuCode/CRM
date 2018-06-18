package com.springwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springwebapp.dao.CustomerDAO;
import com.springwebapp.entity.Customer;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//incject tthe customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
	
		//get customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//add the mcustomer to spring mvc model
		theModel.addAttribute("customers", theCustomers);
		
		
		
	return "list-customers";
	}
}
