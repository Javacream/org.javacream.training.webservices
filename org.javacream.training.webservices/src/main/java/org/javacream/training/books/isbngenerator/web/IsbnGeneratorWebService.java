package org.javacream.training.books.isbngenerator.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.javacream.ApplicationContext;
import org.javacream.books.isbngenerator.api.IsbnGenerator;

@Path("api")
public class IsbnGeneratorWebService {

	@POST
	@Path("isbn")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> nextIsbn(@QueryParam("fetchSize") int fetchSize) {
		IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
		List<String> isbns = new ArrayList<>(fetchSize);
		for (int i = 0; i < fetchSize; i++) {
			isbns.add(isbnGenerator.next());
		}
		return isbns;
	}
}
