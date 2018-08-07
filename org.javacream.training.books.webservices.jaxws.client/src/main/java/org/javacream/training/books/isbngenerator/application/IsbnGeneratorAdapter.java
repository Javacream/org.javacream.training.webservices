package org.javacream.training.books.isbngenerator.application;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.training.books.isbngenerator.webservices.jaxws.client.IsbnGeneratorWebService;

public class IsbnGeneratorAdapter implements IsbnGenerator{

	private IsbnGeneratorWebService isbnGeneratorWebService;

	public void setIsbnGeneratorWebService(IsbnGeneratorWebService isbnGeneratorWebService) {
		this.isbnGeneratorWebService = isbnGeneratorWebService;
	}

	@Override
	public String next() {
		return isbnGeneratorWebService.next();
	};
	
	
}
