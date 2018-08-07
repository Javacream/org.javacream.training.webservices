package org.javacream.training.books.webservices.jaxws;

import javax.xml.ws.Endpoint;

import org.javacream.training.isbngenerator.webservices.jaxws.IsbnGeneratorWebService;
import org.javacream.training.storeservice.webservices.jaxws.StoreWebService;
import org.javacream.util.Context;

public class Server {

	public static void main(String[] args) {
		System.out.println("Starting services...");
		IsbnGeneratorWebService isbnGeneratorWebService = new IsbnGeneratorWebService();
		isbnGeneratorWebService.setIsbnGenerator(Context.getKeyGenerator());
		StoreWebService storeWebService = new StoreWebService();
		storeWebService.setStoreService(Context.getStoreService());
		Endpoint.publish("http://localhost:8888/isbnGenerator", isbnGeneratorWebService);
		Endpoint.publish("http://localhost:8888/storeService", storeWebService);
		System.out.println("Starting services done!");
	}

}
