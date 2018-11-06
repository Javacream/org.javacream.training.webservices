package org.javacream.training.books.webservices.jaxws.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javacream.training.storeservice.webservices.jaxws.client.StoreWebService;
import org.javacream.training.storeservice.webservices.jaxws.client.StoreWebServiceService;

public class StoreWebServiceDemo {

	public static void main(String[] args) {
		StoreWebService storeWebService = new StoreWebServiceService().getStoreWebServicePort();
		System.out.println(storeWebService.getStock("books", Arrays.asList(new String[] {"ISBN1"})));
		System.out.println(storeWebService.getClass().getName());
		System.out.println(Arrays.asList(storeWebService.getClass().getInterfaces()));
		long start = System.currentTimeMillis();
		List<String> isbns = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			isbns.add("ISBN" + i);
		}
		storeWebService.getStock("books", isbns);
		System.out.println("Retrieving 100 stocks took " + (System.currentTimeMillis() - start));
	}

}
