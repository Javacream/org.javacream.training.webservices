package org.javacream.training.webservices.books;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.javacream.books.warehouse.BookException;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.value.Book;
import org.javacream.util.ApplicationContext;

@Path("api/books")
public class BooksWebService {
	private BooksService booksService = ApplicationContext.getBooksService();

	@GET
	@Path("{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public WebBook findBookByIsbn(@PathParam("isbn") String isbn) {
		try {
			return assemble(booksService.findBookByIsbn(isbn));
		} catch (BookException be) {
			throw new NotFoundException(be);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<WebBook> findAll() {
		try {
			return booksService.findAllBooks().stream().map((book) -> assemble(book)).collect(Collectors.toList());
		} catch (Exception be) {
			throw new NotFoundException(be);
		}
	}

	@POST
	@Path("{title}")
	@Produces(MediaType.TEXT_PLAIN)
	public String newBook(@PathParam("title") String title) {
		try {
			return booksService.newBook(title);
		} catch (BookException be) {
			throw new WebApplicationException(422);
		}
	}

	@DELETE
	@Path("{isbn}")
	public void deleteBookByIsbn(@PathParam("isbn") String isbn) {
		try {
			booksService.deleteBookByIsbn(isbn);
		} catch (BookException be) {
			throw new WebApplicationException(409);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{isbn}")
	public WebBook updateBook(@PathParam("isbn") String isbn, WebBook toUpdate) {
		try {
			Book book = booksService.findBookByIsbn(isbn);
			book.setTitle(toUpdate.getTitle());
			book.setPrice(toUpdate.getPrice());
			return assemble(booksService.updateBook(book));
		} catch (BookException be) {
			throw new WebApplicationException(422);
		}
	}

	private WebBook assemble(Book book) {
		return new WebBook(book.getIsbn(), book.getTitle(), book.getPrice(), book.isAvailable());
	}

}