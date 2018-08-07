package org.javacream.training.books.webservices.jaxws;

import org.javacream.books.warehouse.BookException;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.value.Book;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.store.StoreService;
import org.javacream.util.Context;

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
			IsbnGenerator isbnGenerator = Context.getKeyGenerator();
			System.out.println(isbnGenerator.next());
		} catch (BookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
