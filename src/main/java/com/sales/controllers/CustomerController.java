package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.services.CustomerService;



public class CustomerController {
	
	private CustomerService customerService;
	
		// Setup our method to display all the customers in the 'customer' table
		@RequestMapping(value = "/listCustomers", method = RequestMethod.GET)	
		public String getShips(Model s)
		{
			ArrayList<Customer> customerList = customerService.listAll();
			
			s.addAttribute("customerList", customerList);
			
			return "listCustomers";
		}
		
		// Setup our GET method to add a new customer to the 'customer' table
		@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)	
		public String getShips(@ModelAttribute("shipAdd") Customer m, HttpServletRequest h)
		{
			return "addCustomer";
		}
		
		// Setup our POST method to add a new ship to the 'ship' table
		@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)	
		public String addCustomer(@Valid @ModelAttribute("customerAdd") Customer m, BindingResult result, HttpServletRequest h, Model s)
		{
				// First, check for errors
			if (result.hasErrors())
			{
				return "addCustomer";
			}		
			else
			{
				customerService.addCustomer(m);
				
				ArrayList<Customer> customerList = customerService.listAll();
				
				s.addAttribute("customerList", customerList);
				
				return "listCustomer";
			}
		}
		
		

}
