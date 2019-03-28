package org.javacream.training.books.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.javacream.application.Context;
import org.springframework.stereotype.Component;

@Component
@Path("books")
public class IsbnGeneratorWebService {

	
	@POST @Path("isbn") public String nextIsbn() {
		return Context.getIsbnGenerator().next();
	}
}
