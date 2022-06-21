package org.javacream.training.webservices.books;

import java.util.Collection;

import org.javacream.books.warehouse.BookException;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.value.Book;
import org.javacream.util.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebService {
	private BooksService booksService = ApplicationContext.getBooksService();

	public Collection<Book> findAllBooks() {
		return booksService.findAllBooks();
	}

//später...	
	public void deleteBookByIsbn(String arg0) throws BookException {
		booksService.deleteBookByIsbn(arg0);
	}


	public Book findBook(String arg0, boolean arg1) throws BookException {
		return booksService.findBook(arg0, arg1);
	}

	public Book findBook(String arg0) throws BookException {
		return booksService.findBook(arg0);
	}

	public Book findBookByIsbn(String arg0) throws BookException {
		return booksService.findBookByIsbn(arg0);
	}

	public String newBook(String arg0) throws BookException {
		return booksService.newBook(arg0);
	}

	public Book updateBook(Book arg0) throws BookException {
		return booksService.updateBook(arg0);
	}

}
