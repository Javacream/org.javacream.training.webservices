package org.javacream.training.webservices.books;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.javacream.books.warehouse.BookException;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.value.Book;
import org.javacream.util.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("api/books2")
public class BooksResponseWebService {

	BooksService booksService = ApplicationContext.getBooksService();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response findAllBooks() {
		List<Book> books = new ArrayList<>(booksService.findAllBooks());
		GenericEntity<List<Book>> genericEntity = new GenericEntity<List<Book>>(books){};
		return Response.ok(genericEntity).build();

	}

	@GET
	@Path("/range")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response findBooksByPriceRange(
			@QueryParam("minPrice") @DefaultValue("0") double minPrice,
			@QueryParam("maxPrice") @DefaultValue("0") double maxPrice) {
		System.out.println("MINPRICE: " + minPrice + ", MAXPRICE:" + maxPrice);
		Collection<Book> allBooks = booksService.findAllBooks();
		ArrayList<Book> result = new ArrayList<>();
		for (Book book : allBooks) {
			double price = book.getPrice();
			if ((minPrice < price) && (maxPrice > price)) {
				result.add(book);
			}
		}
		GenericEntity<List<Book>> genericEntity = new GenericEntity<List<Book>>(result){};
		return Response.ok(genericEntity).build();
	}

	@GET
	@Path("/{isbn}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response findBookByIsbn(@PathParam("isbn") String isbn) {
		try {
			return Response.ok(booksService.findBookByIsbn(isbn)).build();
		} catch (BookException e) {
			e.printStackTrace();
			throw new NotFoundException();
		}

	}

	@DELETE
	@Path("/{isbn}")
	public void deleteBookByIsbn(@PathParam("isbn") String isbn) {
		try {
			booksService.deleteBookByIsbn(isbn);
		} catch (BookException e) {
			e.printStackTrace();
			throw new BadRequestException();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBook(Book book) {
		try {
			booksService.updateBook(book);
		} catch (BookException e) {
			e.printStackTrace();
			throw new BadRequestException();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertBook(Book book) {
		try {
			String isbn = booksService.newBook(book.getTitle());
			book.setIsbn(isbn);
			booksService.updateBook(book);
			try {
				return Response.created(new URI("http://XYZ")).build();
			} catch (URISyntaxException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}

		} catch (BookException e) {
			e.printStackTrace();
			throw new BadRequestException();
		}

	}

}
