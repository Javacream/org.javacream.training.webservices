package org.javacream.training.books.warehouse.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WebBook {

	
	private String title;
	private double price;
	private boolean available;
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	public boolean isAvailable() {
		return available;
	}
	public WebBook(String title, double price, boolean available) {
		super();
		this.title = title;
		this.price = price;
		this.available = available;
	}
	@Override
	public String toString() {
		return "WebBook [title=" + title + ", price=" + price + ", available=" + available + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebBook other = (WebBook) obj;
		if (available != other.available)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
