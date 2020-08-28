package org.javacream.training.books.isbngenerator.web;

import org.javacream.ApplicationContext;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

	@PostMapping(path = "api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
	public String nextIsbn() {
		IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
		return isbnGenerator.next();
	}
}
