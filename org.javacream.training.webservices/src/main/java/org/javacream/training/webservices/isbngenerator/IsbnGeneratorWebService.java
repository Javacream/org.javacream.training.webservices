package org.javacream.training.webservices.isbngenerator;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.util.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("api")
public class IsbnGeneratorWebService {

	//@Inject //CDI
	//@Autowired //Spring
	//@EJB //JEE
	private IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
	
	@POST
	@Path("isbn")
	@Produces(MediaType.TEXT_PLAIN)
	public String nextIsbn() {
		return isbnGenerator.next();	
	}
}
