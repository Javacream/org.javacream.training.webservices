package org.javacream;


import java.util.Collection;

import org.javacream.books.warehouse.BookException;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.value.Book;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.store.StoreService;
import org.javacream.util.ApplicationContext;
import org.junit.Assert;
import org.junit.Test;

public class AllTests {

	@Test public void testStoreService() {
		StoreService storeService = ApplicationContext.getStoreService();
		Assert.assertEquals(42, storeService.getStock("books", "id"));
	}
	@Test public void testIsbnGenerator() {
		IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
		String isbn1 = isbnGenerator.next();
		Assert.assertTrue(isbn1.startsWith("ISBN:"));
		Assert.assertTrue(isbn1.endsWith("-de"));
		String isbn2 = isbnGenerator.next();
		Assert.assertTrue(isbn2.startsWith("ISBN:"));
		Assert.assertTrue(isbn2.endsWith("-de"));
		Assert.assertFalse(isbn2.equals(isbn1));
	}
	
	@Test public void testBookService() {
		BooksService booksService = ApplicationContext.getBooksService();
		try {
			Collection<Book> books = booksService.findAllBooks();
			final int startSize = books.size();
			String j2eeTitle = "Spring";
			String isbn = booksService.newBook(j2eeTitle);
			books = booksService.findAllBooks();
			final int endSize = books.size();
			Assert.assertTrue(endSize == startSize + 1);
			Assert.assertNotNull(isbn);
			Assert.assertNotNull(booksService.findBookByIsbn(isbn));

			try {
				booksService.findBookByIsbn("ISBN-3");
				Assert.fail("BookException must be thrown!");
			} catch (BookException e) {
				// OK
			}
			booksService.deleteBookByIsbn(isbn);
			Assert.assertTrue(startSize == booksService.findAllBooks().size());
			try {
				booksService.deleteBookByIsbn(isbn);
				Assert.fail("BookException must be thrown!");
			} catch (BookException e) {
				// OK
			}

		} catch (BookException bookException) {
			bookException.printStackTrace();
			Assert.fail(bookException.getMessage());
		}

}
}
