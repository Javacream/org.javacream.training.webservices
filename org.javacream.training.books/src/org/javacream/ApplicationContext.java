package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.StoreServiceImpl;

public abstract class ApplicationContext {
	public static BooksService getBooksService(){
		MapBooksService mapBooksService = new MapBooksService();
		mapBooksService.setIsbnGenerator(getIsbnGenerator());
		mapBooksService.setStoreService(getStoreService());
		return mapBooksService;
	}
	public static IsbnGenerator getIsbnGenerator(){
		RandomIsbnGenerator randomKeyGenerator = new RandomIsbnGenerator();
		randomKeyGenerator.setPrefix("Integrata:");
		randomKeyGenerator.setSuffix("-de");
		return randomKeyGenerator;
		
	}
	public static StoreService getStoreService(){
		return new StoreServiceImpl();
	}
}
