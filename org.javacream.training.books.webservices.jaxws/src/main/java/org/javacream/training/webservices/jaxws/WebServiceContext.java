package org.javacream.training.webservices.jaxws;

import org.javacream.application.Context;
import org.javacream.training.books.isbngenerator.webservices.jaxws.IsbnGeneratorWebService;
import org.javacream.training.books.warehouse.webservices.jaxws.BooksWebService;
import org.javacream.training.storeservice.webservices.jaxws.StoreWebService;

public abstract class WebServiceContext {
	private static IsbnGeneratorWebService isbnGeneratorWebService;
	private static StoreWebService storeWebService;
	private static BooksWebService booksWebService;
	static {
		isbnGeneratorWebService = new IsbnGeneratorWebService();
		storeWebService = new StoreWebService();
		booksWebService = new BooksWebService();
		
		isbnGeneratorWebService.setIsbnGenerator(Context.getIsbnGenerator());
		storeWebService.setStoreService(Context.getStoreService());
		booksWebService.setBooksService(Context.getBooksService());
	}

	public static BooksWebService getBooksWebService() {
		return booksWebService;
	}

	public static IsbnGeneratorWebService getIsbnGeneratorWebService() {
		return isbnGeneratorWebService;
	}

	public static StoreWebService getStoreWebService() {
		return storeWebService;
	}
	
}
