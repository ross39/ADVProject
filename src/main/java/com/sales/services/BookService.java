package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.sales.models.Book;
import com.sales.repositories.BookInterface;
import com.sales.services.BookService;

public class BookService {
	
	@Autowired // This means to get the bean called BookInterface, Which is auto-generated by Spring, we will use it to handle the data
	private BookInterface bookInterface;
	
	public ArrayList<Book> listAll()
	{
		// Find all elements in the 'Book' table and put them in an ArrayList called 'books', then return the book arrayList
		return (ArrayList<Book>) bookInterface.findAll();
	}
	
	public Book addBook(Book ship) 
	{
		return bookInterface.save(ship);
	}

}
