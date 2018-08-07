package org.javacream.training.books.webservices.jaxws;

import javax.xml.ws.Endpoint;

import org.javacream.training.webservices.jaxws.WebServiceContext;

public class Server {

	public static void main(String[] args) {
		System.out.println("Starting services...");
		Endpoint.publish("http://localhost:8888/isbnGenerator", WebServiceContext.getIsbnGeneratorWebService());
		Endpoint.publish("http://localhost:8888/storeService", WebServiceContext.getStoreWebService());
		System.out.println("Starting services done!");
	}

}
