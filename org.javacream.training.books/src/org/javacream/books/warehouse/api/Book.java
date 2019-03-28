/*
 * Created on 20.04.2004
 */
package org.javacream.books.warehouse.api;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto training@rainer-sawitzki.de
 * 
 * ValueObject für die Books-Anwendung
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable {
	public Book() {
		super();
	}

	public Book(String isbn, String title, double price, boolean available,
			List<String> keywords) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.available = available;
		this.keywords = keywords;
	}

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name="bookIsbnNumber")
	private String isbn;

	@XmlElement(name="titleOfBook")
	private String title;

	private double price;

	@XmlAttribute
	private boolean available;

	//@XmlTransient
	private List<String> keywords;
	
	public List<String> getKeywords() {
		return keywords;
	}
	
	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (available != other.available)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Book [available=" + available + ", isbn=" + isbn
				+ ", keywords=" + keywords + ", price=" + price + ", title="
				+ title + ", toString()=" + super.toString() + "]";
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	

}
