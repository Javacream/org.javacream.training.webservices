package org.javacream.application;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.OrderServiceImpl;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.StoreServiceImpl;

public abstract class Context {
	private static BooksService booksService;
	private static IsbnGenerator isbnGenerator;
	private static StoreService storeService;
	private static OrderService orderService;
	
	static {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		StoreServiceImpl storeServiceImpl = new StoreServiceImpl();
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(storeServiceImpl);
		randomIsbnGenerator.setPrefix("ISBN:");
		randomIsbnGenerator.setSuffix("-de");
		
		booksService = mapBooksService;
		isbnGenerator = randomIsbnGenerator;
		storeService = storeServiceImpl;
		orderService = orderServiceImpl;
	}

	public static BooksService getBooksService() {
		return booksService;
	}

	public static IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}

	public static StoreService getStoreService() {
		return storeService;
	}

	public static OrderService getOrderService() {
		return orderService;
	}
}
