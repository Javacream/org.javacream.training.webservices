package org.javacream.training.webservices.jaxrs.spring.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

@Component
@Path("echo")
public class EchoWebService {

	@GET
	@Path("ping")
	public String ping() {
		return "pong";
	}

	// URL: http://localhost:8080/echo/echo/Hello
	@GET
	@Path("echo/{m}")
	public String echo(@PathParam("m") String message) {
		return message;
	}

	// URL: http://localhost:8080/echo/echo?m=Hello
	@GET @Path("echo")
	public String echoWithQuery(@QueryParam("m") String message) {
		return message;
	}

	// URL: http://localhost:8080/echo/echo/Hello/true
	@GET @Path("echo/{m}/{friendly}")
	public String echoFriendly(@PathParam("m") String message, @PathParam("friendly")Boolean isFriendly) {
		if (isFriendly) {
			return "Hello my friend " + message;
		}else {
			return message;
		}
	}

}
