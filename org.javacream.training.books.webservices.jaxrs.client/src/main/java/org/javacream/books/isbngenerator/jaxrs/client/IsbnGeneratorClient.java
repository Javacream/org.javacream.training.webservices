package org.javacream.books.isbngenerator.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class IsbnGeneratorClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		String isbn = client.target("http://localhost:8080/jee/rest").path("isbn").request("text/plain")
				.get(String.class);
		System.out.println(isbn);
	}

}
