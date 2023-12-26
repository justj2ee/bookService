package com.ny.markets.payments.service;

import java.util.List;
import java.util.Optional;

import com.ny.markets.payments.model.Book;

public interface BookService {
	
	public String saveBook(Book book);
	public Book getBook(int bookId);
	public List<Book> removeBook(int bookId);
	public List<Book> getAllBooks();

}
