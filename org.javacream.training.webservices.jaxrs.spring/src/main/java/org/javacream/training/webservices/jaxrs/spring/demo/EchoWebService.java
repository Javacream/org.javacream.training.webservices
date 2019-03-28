package org.javacream.training.webservices.jaxrs.spring.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("echo")
public class EchoWebService {

	@GET @Path("ping")
	public String ping() {
		return "peng";
	}
}
