package org.javacream.training.books.rest;

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
import javax.ws.rs.core.MediaType;

import org.javacream.application.Context;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;

import io.swagger.annotations.Api;

@Path("books")
@Api
public class BooksWebService {
	private BooksService booksService = Context.getBooksService();
	
	
	@GET @Path("{isbn}") @Produces({MediaType.TEXT_PLAIN, "text/simple"})
	public WebBook findBookByIsbn(@PathParam ("isbn")String isbn){
		try{
			return assemble(booksService.findBookByIsbn(isbn));
		}
		catch(BookException be){
			throw new NotFoundException(be);
		}
	}

	@GET @Path("{isbn}") @Produces(MediaType.APPLICATION_JSON)
	public WebBook findBookByIsbnAsJson(@PathParam ("isbn")String isbn){
		try{
			return assemble(booksService.findBookByIsbn(isbn));
		}
		catch(BookException be){
			throw new NotFoundException(be);
		}
	}

	
	@GET  @Produces(MediaType.APPLICATION_JSON)
	public Collection<WebBook> findAll(){
		return booksService.findAllBooks().stream().map((book) -> assemble(book)).collect(Collectors.toList());
	}

	@POST @Path("{title}") @Produces(MediaType.TEXT_PLAIN)
	public String newBook(@PathParam ("title")String title){
		try{
			return booksService.newBook(title);
		}
		catch(BookException be){
			throw new RuntimeException(be);
		}
	}
	
	@DELETE @Path("{isbn}")
	public void deleteBookByIsbn(@PathParam ("isbn")String isbn){
		try{
			booksService.deleteBookByIsbn(isbn);
		}
		catch(BookException be){
			throw new RuntimeException(be);
		}
	}

	@PUT @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON) @Path("{isbn}") 
	public WebBook updateBook(@PathParam ("isbn") String isbn, WebBook toUpdate){
		try{
			Book book = booksService.findBookByIsbn(isbn);
			book.setTitle(toUpdate.getTitle());
			book.setPrice(toUpdate.getPrice());
			return assemble(booksService.updateBook(book));
		}
		catch(BookException be){
			throw new RuntimeException(be);
		}
	}

	
	private WebBook assemble(Book book) {
		return new WebBook(book.getIsbn(), book.getTitle(), book.getPrice(), book.isAvailable());
	}
	
}