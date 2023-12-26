package com.ny.markets.payments.service.impl;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.markets.payments.model.Book;
import com.ny.markets.payments.persistence.dao.BookRepository;
import com.ny.markets.payments.service.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired BookRepository bookRepository;
	@Override
	public String saveBook(Book book) {
		// TODO Auto-generated method stub
		 bookRepository.save(book);
		 return "book save with id: "+book.getBook_id();
	}
	
	@Override
	public List<Book> removeBook(int bookId) {
		Book bookToDelete=getBook(bookId);
		bookRepository.delete(bookToDelete);
		return bookRepository.findAll();
	}
	
	@Override
	public Book getBook(int bookId) {
		Optional<Book> optionalBook=bookRepository.findById(bookId);
		Book book=null;
		if (optionalBook.isPresent())
			book= optionalBook.get();
		
		return book;
		
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

}
