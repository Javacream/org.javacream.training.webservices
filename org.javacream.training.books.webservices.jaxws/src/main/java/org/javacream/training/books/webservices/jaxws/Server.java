package org.javacream.training.books.webservices.jaxws;

import javax.xml.ws.Endpoint;

import org.javacream.training.isbngenerator.webservices.jaxws.IsbnGeneratorWebService;
import org.javacream.util.Context;

public class Server {

	public static void main(String[] args) {
		System.out.println("Starting services...");
		IsbnGeneratorWebService isbnGeneratorWebService = new IsbnGeneratorWebService();
		isbnGeneratorWebService.setIsbnGenerator(Context.getKeyGenerator());
		Endpoint.publish("http://localhost:8888/isbnGenerator", isbnGeneratorWebService);
		System.out.println("Starting services done!");
	}

}
