package org.javacream.util;

import org.javacream.books.order.OrderService;
import org.javacream.books.order.business.OrderServiceImpl;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.business.MapBooksService;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.isbngenerator.business.RandomIsbnGenerator;
import org.javacream.store.StoreService;
import org.javacream.store.business.StoreServiceImpl;

public abstract class Context {
	public static BooksService getBooksService(){
		MapBooksService mapBooksService = new MapBooksService();
		mapBooksService.setIsbnGenerator(getKeyGenerator());
		mapBooksService.setStoreService(getStoreService());
		return mapBooksService;
	}
	public static IsbnGenerator getKeyGenerator(){
		RandomIsbnGenerator randomKeyGenerator = new RandomIsbnGenerator();
		randomKeyGenerator.setPrefix("Integrata:");
		randomKeyGenerator.setSuffix("-de");
		return randomKeyGenerator;
		
	}
	public static StoreService getStoreService(){
		return new StoreServiceImpl();
	}
	public static OrderService getOrderService(){
		return new OrderServiceImpl();
	}
}
