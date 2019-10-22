package org.javacream.training.webservices.books;


public class WebBook {

	
	private String isbn;
	private String title;
	private double price;
	private String keywords;
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
	public WebBook(String isbn, String title, double price, boolean available, String keywords) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.available = available;
		this.keywords = keywords;
	}
	public String getKeywords() {
		return keywords;
	}
	public boolean isAvailable() {
		return available;
	}
}
