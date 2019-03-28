package com.sales.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Book;
import com.sales.services.BookService;


public class BookController {
	
	private BookService bookservice;
	
	@RequestMapping(value = "/showBooks", method = RequestMethod.GET)	
	public String getShips(Model s)
	{
		ArrayList<Book> shipList = bookservice.listAll();
		
		s.addAttribute("shipList", shipList);
		
		return "showShips";
	}

}
