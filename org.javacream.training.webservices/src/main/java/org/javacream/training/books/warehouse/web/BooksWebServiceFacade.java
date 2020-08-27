package org.javacream.training.books.warehouse.web;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.javacream.ApplicationContext;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;

@Path("api/books/nontrivial")
public class BooksWebServiceFacade {
	private BooksService booksService = ApplicationContext.getBooksService();

	@GET
	@Path("{isbn}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public WebBook findBookByIsbn(@PathParam("isbn") String isbn) {
		try {
			return assemble(booksService.findBookByIsbn(isbn));
		} catch (BookException be) {
			throw new NotFoundException(be);
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<String> findAllIsbns(@QueryParam("maxSize") @DefaultValue("-1") Integer maxSize) {
		try {
			if (maxSize == -1) {
				return booksService.findAllBooks().stream().map((book) -> book.getIsbn())
						.collect(Collectors.toList());
			}else {
				return booksService.findAllBooks().stream().limit(maxSize).map((book) -> book.getIsbn())
						.collect(Collectors.toList());
				
			}
		} catch (Exception be) {
			throw new NotFoundException(be);
		}
	}

	private WebBook assemble(Book book) {
		return new WebBook(book.getIsbn(), book.getTitle(), book.getPrice(), book.isAvailable(),
				book.getKeywords().toString());
	}

}
