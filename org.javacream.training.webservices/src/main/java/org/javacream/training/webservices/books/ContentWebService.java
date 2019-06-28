package org.javacream.training.webservices.books;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.javacream.books.warehouse.BooksService;
import org.javacream.util.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
@Path("api/content")
public class ContentWebService {

	private BooksService booksService = ApplicationContext.getBooksService();

	@GET @Path("{isbn}")
	public String getContent(@PathParam("isbn") String isbn) {
		try {
			return new String(booksService.findBookByIsbn(isbn).getContent());
		} catch (Exception e) {
			throw new NotFoundException();
		}
	}
}