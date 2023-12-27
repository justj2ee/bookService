package com.ny.markets.payments.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@Entity
@Table(name = "BOOK")
@ApiModel(description = "Details about the Book")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -447629735502043812L;
	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "The unique identifier of the book")
	private int book_id;
	@ApiModelProperty(notes = "The name of the book")
	private String book_name;
	@ApiModelProperty(notes = "The book's Author")
	@NotNull(message = "The author's name is required.")
	@NotEmpty(message = "The author's name must be entered.")
	private String author;
	@ApiModelProperty(notes = "The price of the book Author")
	private double price;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", author=" + author + ", price=" + price
				+ "]";
	}
	
}