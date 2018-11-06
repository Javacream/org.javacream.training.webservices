package org.javacream.training.webservices.jaxrs.spring.demo;

import javax.inject.Inject;

public class BookController {

	@Inject private BookRepository br;
	
	public void save(String title) {
		Book book = new Book();
		br.save(book);
	}
}
