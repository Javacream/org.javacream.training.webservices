package org.javacream.books.isbngenerator.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

public class IsbnGeneratorClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		String isbn = client.target("http://localhost:8080/api").path("isbn").request("text/plain")
				.post(Entity.json("")).readEntity(String.class);
		System.out.println(isbn);
	}

}
