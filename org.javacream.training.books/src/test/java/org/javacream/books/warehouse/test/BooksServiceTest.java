package org.javacream.books.warehouse.test;

import org.javacream.ApplicationContext;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.Test;

public class BooksServiceTest {

	@Test public void testBusinessObjects() {
		doTest(ApplicationContext.getBooksService());
	}
	private void doTest(BooksService booksService) {
		TestActor.doTest(booksService);
		
	}
}
