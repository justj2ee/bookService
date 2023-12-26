package com.ny.markets.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ny.markets.payments.model.Book;
import com.ny.markets.payments.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/book")
@Api(value = "Book Service", description="My Local Book Service")
public class BookController {
	@Autowired BookService bookService;
	@PostMapping("/save")
	@ApiOperation(value = "Save a book to the inventory",
	notes ="Add a new book to the inventory list.",
	response = Book.class)
	public String saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping ("/search/{book_id}")
	@ApiOperation(value = "Finds Books by ID",
				notes ="Provide an id to look up specific book information.",
				response = Book.class)
	public Book getBook(@ApiParam(value = "book_id value for the book to retrieve from inventory", required=true) @PathVariable int book_id) {
		return bookService.getBook(book_id);
	}
	
	@DeleteMapping("/remove/{book_id}")
	@ApiOperation(value = "Delete a book using the books id. Returns a list of the remaining books",
	notes ="Provide an id to delete a book from the inventory of books.",
	response = Book.class)
	public List<Book> deleteBook( @ApiParam(value = "book_id value for the book to delete from inventory", required=true) @PathVariable int book_id) {
		return bookService.removeBook(book_id);
	}
	
	@GetMapping ("/search/")
	@ApiOperation(value = "Will return a list of the current book inventory",
	notes ="Return an inventory of books.",
	response = Book.class)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

}
