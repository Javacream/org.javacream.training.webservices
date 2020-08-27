package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.StoreServiceImpl;

public abstract class ApplicationContext {
	private static BooksService booksService;
	private static IsbnGenerator isbnGenerator;
	private static StoreService storeService;
	
	public static BooksService getBooksService(){
		return booksService;
	}
	static {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(new StoreServiceImpl());
		randomIsbnGenerator.setPrefix("Integrata:");
		randomIsbnGenerator.setSuffix("-de");
	}
	public static IsbnGenerator getIsbnGenerator(){
		return isbnGenerator;
		
	}
	public static StoreService getStoreService(){
		return storeService;
	}
}
