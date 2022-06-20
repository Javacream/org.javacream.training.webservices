package org.javacream.training.webservices.books;

import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.util.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebIsbnGenerator {

	private IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
	
	@PostMapping(path="api/isbn", produces=MediaType.TEXT_PLAIN_VALUE)
	public String next() {
		return isbnGenerator.next();
	}
}
