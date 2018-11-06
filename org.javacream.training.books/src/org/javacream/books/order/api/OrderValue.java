package org.javacream.books.order.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderId;
	private boolean status;
	private String customer;
	
	public OrderValue(){
		
	}
	@Override
	public String toString() {
		return "OrderValue [orderId=" + orderId + ", status=" + status
				+ ", customer=" + customer + ", isbn=" + isbn + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + orderId;
		result = prime * result + (status ? 1231 : 1237);
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
		OrderValue other = (OrderValue) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (orderId != other.orderId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	public OrderValue(int orderId, boolean status, String customer, String isbn) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.customer = customer;
		this.isbn = isbn;
	}
	public int getOrderId() {
		return orderId;
	}
	public boolean isStatus() {
		return status;
	}
	public String getCustomer() {
		return customer;
	}
	public String getIsbn() {
		return isbn;
	}
	private String isbn;
}
