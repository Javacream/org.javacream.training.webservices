package org.javacream.training.webservices.jaxws;

import org.javacream.application.Context;
import org.javacream.training.books.isbngenerator.webservices.jaxws.IsbnGeneratorWebService;
import org.javacream.training.storeservice.webservices.jaxws.StoreWebService;

public abstract class WebServiceContext {
	private static IsbnGeneratorWebService isbnGeneratorWebService;
	private static StoreWebService storeWebService;
	
	static {
		isbnGeneratorWebService = new IsbnGeneratorWebService();
		storeWebService = new StoreWebService();
	
		isbnGeneratorWebService.setIsbnGenerator(Context.getIsbnGenerator());
		storeWebService.setStoreService(Context.getStoreService());
	}

	public static IsbnGeneratorWebService getIsbnGeneratorWebService() {
		return isbnGeneratorWebService;
	}

	public static StoreWebService getStoreWebService() {
		return storeWebService;
	}
	
}
