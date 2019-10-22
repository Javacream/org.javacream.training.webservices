package org.javacream.books.warehouse.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BooksRestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response result = client.target("http://localhost:8080/api").path("books/ISBN1").request(MediaType.APPLICATION_JSON)
				.get();	
		System.out.println(result.readEntity(String.class));


	}

}
