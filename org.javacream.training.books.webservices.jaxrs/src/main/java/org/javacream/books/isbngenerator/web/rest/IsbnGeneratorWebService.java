package org.javacream.books.isbngenerator.web.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javacream.application.Context;
import org.javacream.books.isbngenerator.api.IsbnGenerator;

@Path("isbn")
@RequestScoped
public class IsbnGeneratorWebService {

	private IsbnGenerator isbnGenerator = Context.getIsbnGenerator();
	
	@GET @Produces(MediaType.TEXT_PLAIN)
	public String nextKey(){
		return isbnGenerator.next();
	}
}
