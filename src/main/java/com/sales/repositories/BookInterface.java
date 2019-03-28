package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sales.models.Book;

public interface BookInterface extends CrudRepository<Book, Long> {

}
