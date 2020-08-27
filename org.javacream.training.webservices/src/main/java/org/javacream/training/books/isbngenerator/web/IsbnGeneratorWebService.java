package org.javacream.training.books.isbngenerator.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javacream.ApplicationContext;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.stereotype.Component;

@Component
@Path("api")
public class IsbnGeneratorWebService {

	@POST
	@Path("isbn")
	@Produces(MediaType.TEXT_PLAIN)
	public String nextIsbn() {
		IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
		return isbnGenerator.next();
	}
}
