package com.ny.markets.payments.service;

import java.util.List;
import java.util.Optional;

import com.ny.markets.payments.exception.UserNotFoundException;
import com.ny.markets.payments.model.Book;

public interface BookService {
	
	public Book saveBook(Book book);
	public Book getBook(int bookId) throws UserNotFoundException;
	public List<Book> removeBook(int bookId);
	public List<Book> getAllBooks();
	public void removeAllBooks();

}
