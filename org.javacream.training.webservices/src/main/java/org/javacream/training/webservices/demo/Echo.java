package org.javacream.training.webservices.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Path("api")
@Component
public class Echo {

	@GET @Path("echo") public String echo() {
		return "Ping";		
	}
}
