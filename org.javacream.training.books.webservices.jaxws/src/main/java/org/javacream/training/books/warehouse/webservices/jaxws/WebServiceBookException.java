package org.javacream.training.books.warehouse.webservices.jaxws;

import javax.xml.ws.WebFault;

@WebFault
public class WebServiceBookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	private String type;

	public WebServiceBookException(String message, String type) {
		super();
		this.message = message;
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public String getType() {
		return type;
	}
}
