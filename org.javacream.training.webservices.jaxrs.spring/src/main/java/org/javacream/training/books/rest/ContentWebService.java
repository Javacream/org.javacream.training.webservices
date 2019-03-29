package org.javacream.training.books.rest;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.javacream.application.Context;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;

@Component
@Path("content")
@Api
public class ContentWebService {

	private BooksService booksService = Context.getBooksService();

	@GET @Path("{isbn}")
	public String getContent(@PathParam("isbn") String isbn) {
		try {
			return new String(booksService.findBookByIsbn(isbn).getContent());
		} catch (Exception e) {
			throw new NotFoundException();
		}
	}
}
