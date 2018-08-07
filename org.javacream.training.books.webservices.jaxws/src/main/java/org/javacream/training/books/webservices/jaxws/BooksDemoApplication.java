package org.javacream.training.books.webservices.jaxws;

import org.javacream.application.Context;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;

public class BooksDemoApplication {

	public static void main(String[] args) {
		BooksService booksService = Context.getBooksService();
		try {
			String isbn = booksService.newBook("Web Services");
			System.out.println(isbn);
			Book book = booksService.findBook(isbn);
			System.out.println(book);
			//...
			StoreService storeService = Context.getStoreService();
			System.out.println(storeService.getStock("books", "EGAL"));
			
			//..
			IsbnGenerator isbnGenerator = Context.getIsbnGenerator();
			System.out.println(isbnGenerator.next());
		} catch (BookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
