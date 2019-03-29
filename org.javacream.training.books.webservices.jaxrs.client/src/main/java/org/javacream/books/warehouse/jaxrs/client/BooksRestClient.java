package org.javacream.books.warehouse.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.javacream.Constants;

public class BooksRestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		ClientWebBook book = client.target(Constants.HOST).path("books/ISBN1").request(MediaType.APPLICATION_JSON)
				.get(ClientWebBook.class);	
		System.out.println(book);


	}

}
