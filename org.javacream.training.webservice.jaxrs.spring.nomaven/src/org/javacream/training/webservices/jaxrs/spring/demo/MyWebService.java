package org.javacream.training.webservices.jaxrs.spring.demo;

import javax.ws.rs.GET;

public class MyWebService {

	@GET
	public String egal() {
		return "OK";
	}
}
