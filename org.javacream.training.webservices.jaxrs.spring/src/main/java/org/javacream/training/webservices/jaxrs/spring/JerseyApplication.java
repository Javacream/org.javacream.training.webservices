package org.javacream.training.webservices.jaxrs.spring;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyApplication extends ResourceConfig{
	public JerseyApplication() {
		packages("org.javacream.training.webservices.jaxrs", "org.javacream.training.books.rest", "org.javacream.training.store.rest");
	}
}