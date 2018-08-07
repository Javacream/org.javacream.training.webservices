package org.javacream.training.books.webservices.jaxws.client;

import org.javacream.training.books.isbngenerator.webservices.jaxws.client.IsbnGeneratorWebService;
import org.javacream.training.books.isbngenerator.webservices.jaxws.client.IsbnGeneratorWebServiceService;

public class IsbnGeneratorDemo {

	public static void main(String[] args) {
		IsbnGeneratorWebService service = new IsbnGeneratorWebServiceService().getIsbnGeneratorWebServicePort();
		System.out.println(service.next());
	
	}

}
