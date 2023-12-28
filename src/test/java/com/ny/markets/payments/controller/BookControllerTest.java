package com.ny.markets.payments.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ny.markets.payments.DemoApplication;
import com.ny.markets.payments.model.Book;
import com.ny.markets.payments.persistence.dao.BookRepository;
import com.ny.markets.payments.service.BookService;
@TestPropertySource("/application.properties")
@AutoConfigureMockMvc
@SpringBootTest(classes=DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Transactional
public class BookControllerTest {
	
	private static MockHttpServletRequest httpRequest;
	public static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired BookService bookService;
	@Autowired BookRepository bookRepository;
	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;
	

	
	@BeforeAll
	public static  void setup() {
		httpRequest = new MockHttpServletRequest();
	}
	
	@Test
	public void testDeleteBook() throws Exception {
		assertTrue(bookRepository.findById(1).isPresent());
		mockMvc.perform(delete("/book/remove/{book_id}",1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", hasSize(10)));
		assertFalse(bookRepository.findById(1).isPresent());
	}
	
	@Test
	public void testGetBookById() throws Exception {
		assertTrue(bookRepository.findById(1).isPresent());
		System.out.println("====================>"+bookRepository.findById(1));
		mockMvc.perform(get("/book/search/{book_id}",1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.book_id", is(1)))
		.andExpect(jsonPath("$.book_name", is("The Great Gatsby")))
		.andExpect(jsonPath("$.author", is("Herbert Melville")));
		
	}
	
	@Test
	public void testSaveBook() throws Exception {
		
			Book book = new Book();
			book.setAuthor("Thomas Epps");
			book.setBook_name("Wuthering Heights");
			book.setPrice(20.15d);
			
			mockMvc.perform(post("/book/save")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(book)))						//generates a json string of the book object
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.book_id").exists());
		}
		
	
}
