package com.ny.markets.payments.service.impl;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.markets.payments.exception.UserNotFoundException;
import com.ny.markets.payments.model.Book;
import com.ny.markets.payments.persistence.dao.BookRepository;
import com.ny.markets.payments.service.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired BookRepository bookRepository;
	@Override
	public Book saveBook(Book book) {
		 return bookRepository.save(book);
	}
	
	@Override
	public List<Book> removeBook(int bookId) {
		Book bookToDelete;
		try {
			bookToDelete = getBook(bookId);
			bookRepository.delete(bookToDelete);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookRepository.findAll();
	}
	
	@Override
	public Book getBook(int bookId) throws UserNotFoundException {
		Optional<Book> optionalBook=bookRepository.findById(bookId);
		Book book=null;
		if (optionalBook.isPresent()) {
			book= optionalBook.get();
		} else {
			throw new UserNotFoundException("Book Not Found with id: "+bookId);
		}
		return book;
		
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public void removeAllBooks() {
		 bookRepository.deleteAll();
		
	}

}
