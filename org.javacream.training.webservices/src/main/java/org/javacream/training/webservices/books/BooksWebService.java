package org.javacream.training.webservices.books;

import java.util.Collection;
import java.util.stream.Collectors;

import org.javacream.books.warehouse.BookException;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.value.Book;
import org.javacream.util.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebService {
	private BooksService booksService = ApplicationContext.getBooksService();

//	@GetMapping(path="api/books", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Collection<Book> findAllBooks() {
//		return booksService.findAllBooks();
//	}

	@GetMapping(path="api/books/isbns", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<String> findAllIsbns() {
		return booksService.findAllBooks().stream().map((book) -> book.getIsbn()).collect(Collectors.toList());
	}
	@GetMapping(path="api/books/infos", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<BookInfo> findAllBookInfos() {
		return booksService.findAllBooks().stream().map((book) -> new BookInfo(book.getIsbn(), book.getTitle())).collect(Collectors.toList());
	}

	@PostMapping(path = "api/books", produces = MediaType.TEXT_PLAIN_VALUE)
	public String newBook(@RequestHeader("title") String title) throws BookException {
		return booksService.newBook(title);
	}

	@GetMapping(path="api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBookByIsbn(@PathVariable("isbn") String isbn) throws BookException {
		return booksService.findBookByIsbn(isbn);
	}

	@DeleteMapping(path="api/books/{isbn}")
	public void deleteBookByIsbn(@PathVariable("isbn") String isbn) throws BookException {
		booksService.deleteBookByIsbn(isbn);
	}

	
//später...	


	public Book findBook(String arg0, boolean arg1) throws BookException {
		return booksService.findBook(arg0, arg1);
	}

	public Book findBook(String arg0) throws BookException {
		return booksService.findBook(arg0);
	}



	public Book updateBook(Book arg0) throws BookException {
		return booksService.updateBook(arg0);
	}

}
