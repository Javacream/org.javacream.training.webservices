package org.javacream.training.webservices;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		packages("org.javacream.training.webservices");
	}
}