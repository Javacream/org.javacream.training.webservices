package org.javacream.training.books.rest;

import io.swagger.annotations.ApiModel;

@ApiModel
public class WebBook {

	
	private String isbn;
	private String title;
	private double price;
	private boolean available;
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	public WebBook() {
		super();
	}
	public WebBook(String isbn, String title, double price, boolean available) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.available = available;
	}
	public boolean isAvailable() {
		return available;
	}
}
