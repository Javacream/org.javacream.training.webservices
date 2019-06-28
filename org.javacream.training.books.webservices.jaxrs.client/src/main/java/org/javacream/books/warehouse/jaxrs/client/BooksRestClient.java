package org.javacream.books.warehouse.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.javacream.books.warehouse.value.Book;

public class BooksRestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Book book = client.target("http://localhost:8080/jee/rest").path("books/ISBN1").request(MediaType.APPLICATION_JSON)
				.get(Book.class);	
		System.out.println(book);

		String simple = client.target("http://localhost:8080/jee/rest").path("books/ISBN1").request("text/simple")
				.get(String.class);	
		System.out.println(simple);

		book.setTitle("CHANGED");
		Book book2 = client.target("http://localhost:8080/jee/rest").path("books").request(MediaType.APPLICATION_JSON)
				.put(Entity.json(book), Book.class);
		System.out.println(book2);

	}

}
