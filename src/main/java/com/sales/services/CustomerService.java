package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.repositories.CustomerInterface;

public class CustomerService {
	
	@Autowired
	private CustomerInterface customerInterface;
	
	public ArrayList<Customer> listAll()
	{
		
		// Find all elements in the 'Book' table and put them in an ArrayList and return them
		return (ArrayList<Customer>) customerInterface.findAll();
		
	}
	
	public Customer addCustomer(Customer customer)
	{
		return customerInterface.save(customer);
	}
	

}
