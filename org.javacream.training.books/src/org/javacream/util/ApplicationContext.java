package org.javacream.util;

import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.business.MapBooksService;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.isbngenerator.business.RandomIsbnGenerator;
import org.javacream.store.StoreService;
import org.javacream.store.business.StoreServiceImpl;

public abstract class ApplicationContext {
	
	private static StoreService storeService;
	private static BooksService booksService;
	private static IsbnGenerator isbnGenerator;

	static {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		StoreServiceImpl storeServiceImpl = new StoreServiceImpl();
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(storeServiceImpl);
		randomIsbnGenerator.setPrefix("ISBN:");
		randomIsbnGenerator.setSuffix("-de");
		storeService = storeServiceImpl;
		booksService = mapBooksService;
		isbnGenerator = randomIsbnGenerator;
		
	}

	public static StoreService getStoreService() {
		return storeService;
	}

	public static BooksService getBooksService() {
		return booksService;
	}

	public static IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}
}
