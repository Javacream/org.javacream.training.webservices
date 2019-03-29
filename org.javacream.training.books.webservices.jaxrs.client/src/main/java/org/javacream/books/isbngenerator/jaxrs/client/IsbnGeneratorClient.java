package org.javacream.books.isbngenerator.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.javacream.Constants;


public class IsbnGeneratorClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target(Constants.HOST).path("books/isbn").request("text/plain")
				.post(null);
		String isbn = response.readEntity(String.class);
		System.out.println(isbn);
	}

}