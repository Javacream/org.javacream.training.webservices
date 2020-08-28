package org.javacream.training.books.warehouse.web;


import org.javacream.ApplicationContext;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebService {
	private BooksService booksService = ApplicationContext.getBooksService();

	@GetMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
		try {
			return booksService.findBookByIsbn(isbn);
		} catch (Exception be) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "api/books/{title}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String newBook(@PathVariable("title") String title) {
		try {
			return booksService.newBook(title);
		} catch (BookException be) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@DeleteMapping(path = "api/books/{isbn}")
	public void deleteBookByIsbn(@PathVariable("isbn") String isbn) {
		try {
			booksService.deleteBookByIsbn(isbn);
		} catch (BookException be) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@PutMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBook(@PathVariable("isbn") String isbn, @RequestBody Book toUpdate) {
		try {
			Book book = booksService.findBookByIsbn(isbn);
			book.setTitle(toUpdate.getTitle());
			book.setPrice(toUpdate.getPrice());
			return booksService.updateBook(book);
		} catch (BookException be) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}