package org.javacream.books.store.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class StoreServiceClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		String stock = client.target("http://localhost:8080/jee/rest").path("store").path("books").path("ISBN1")
				.request("text/plain").get(String.class);
		System.out.println(stock);
	}

}
