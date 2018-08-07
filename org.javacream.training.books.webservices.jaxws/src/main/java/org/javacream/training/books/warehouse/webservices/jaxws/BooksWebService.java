package org.javacream.training.books.warehouse.webservices.jaxws;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;

@WebService
public class BooksWebService {

	private BooksService booksService;

	@WebMethod(exclude = false, operationName = "CreateBook")
	public @WebResult(name = "GeneratedIsbn") String newBook(@WebParam(name = "BookTitle") String title)
			throws WebServiceBookException {
		try {
			return booksService.newBook(title);
		} catch (BookException e) {

			WebServiceBookException webServiceBookException = new WebServiceBookException(e.getMessage(),
					e.type.getMessageType());
			throw webServiceBookException;
		}
	}

	@WebMethod(exclude = false, operationName = "FindBookByIsbn")
	public @WebResult(name = "Book") WebServiceBook findBookByIsbn(@WebParam(name = "SearchIsbn") String isbn)
			throws WebServiceBookException {
		Book book;
		try {
			book = booksService.findBookByIsbn(isbn);
			WebServiceBook webServiceBook = new WebServiceBook(book.getIsbn(), book.getTitle(), book.getPrice(),
					book.isAvailable());
			return webServiceBook;
		} catch (BookException e) {

			WebServiceBookException webServiceBookException = new WebServiceBookException(e.getMessage(),
					e.type.getMessageType());
			throw webServiceBookException;
		}
	}

	@WebMethod(exclude = false, operationName = "FindAll")
	public @WebResult(name = "BookInfos") Collection<WebServiceBookInfo> findAllBooks() {
		Collection<Book> books = booksService.findAllBooks();
		Collection<WebServiceBookInfo> bookInfos = books.stream().map((book) -> {
			return new WebServiceBookInfo(book.getIsbn(), book.getTitle());
		}).collect(Collectors.toList());
		return bookInfos;
	}

	@WebMethod(exclude = true)
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

}
