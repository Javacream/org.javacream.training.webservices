package org.javacream.training.books.webservices.jaxws.client;

import org.javacream.training.books.warehouse.webservices.jaxws.client.BooksWebService;
import org.javacream.training.books.warehouse.webservices.jaxws.client.BooksWebServiceService;
import org.javacream.training.books.warehouse.webservices.jaxws.client.WebServiceBookException_Exception;

public class BooksServiceDemo {

	public static void main(String[] args) {
		BooksWebService booksWebService = new BooksWebServiceService().getBooksWebServicePort();
		try {
			booksWebService.createBook("From Java Client 2");
		} catch (WebServiceBookException_Exception e) {
			e.printStackTrace();
		}
		
	}

}
