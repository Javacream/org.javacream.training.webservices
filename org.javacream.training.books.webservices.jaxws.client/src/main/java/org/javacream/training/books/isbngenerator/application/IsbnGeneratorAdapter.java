package org.javacream.training.books.isbngenerator.application;

import java.util.LinkedList;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.training.books.isbngenerator.webservices.jaxws.client.IsbnGeneratorWebService;

public class IsbnGeneratorAdapter implements IsbnGenerator{
	private LinkedList<String> cache = new LinkedList<>();
	private IsbnGeneratorWebService isbnGeneratorWebService;

	public void setIsbnGeneratorWebService(IsbnGeneratorWebService isbnGeneratorWebService) {
		this.isbnGeneratorWebService = isbnGeneratorWebService;
	}

	@Override
	public String next() {
		if (cache.size() == 0) {
			cache = new LinkedList(isbnGeneratorWebService.next(100));
		}
		return cache.removeFirst();
	};
	
	
}
