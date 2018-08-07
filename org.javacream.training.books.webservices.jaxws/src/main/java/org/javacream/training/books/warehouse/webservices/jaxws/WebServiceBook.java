package org.javacream.training.books.warehouse.webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WebServiceBook {

	public WebServiceBook() {
	}
	@XmlAttribute
	private String isbn;
	public WebServiceBook(String isbn, String title, double price, boolean available) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.available = available;
	}
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
	public boolean isAvailable() {
		return available;
	}
}
