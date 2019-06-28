package org.javacream.training.webservices.isbngenerator;

import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.util.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebServiceSpringMvc {

	//@Inject //CDI
	//@Autowired //Spring
	//@EJB //JEE
	private IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
	

	@PostMapping(path="/api/spring/isbn")
	public String nextIsbn() {
		return isbnGenerator.next();	
	}
}
