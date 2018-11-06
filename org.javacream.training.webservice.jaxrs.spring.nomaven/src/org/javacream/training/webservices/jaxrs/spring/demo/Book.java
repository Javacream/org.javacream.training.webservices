package org.javacream.training.webservices.jaxrs.spring.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private String isbn;
	private String title;
}