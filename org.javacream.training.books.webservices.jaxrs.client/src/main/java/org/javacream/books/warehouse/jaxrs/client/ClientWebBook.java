package org.javacream.books.warehouse.jaxrs.client;

public class ClientWebBook {

	
	private String isbn;
	private String title;
	private double price;
	@Override
	public String toString() {
		return "ClientWebBook [isbn=" + isbn + ", title=" + title + ", price=" + price + ", available=" + available
				+ "]";
	}
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
	public ClientWebBook() {
		super();
	}
	public ClientWebBook(String isbn, String title, double price, boolean available) {
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
