package org.javacream.training.webservices.demo.greeter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

@Component
@Path("api/greeter")
public class Greeter {

	//http://localhost:8080/api/greeter/Sawitzki
	@Path("{name}")
	@GET
	@Produces("text/plain")
	public String greetWithPathParam(@PathParam("name") String personName) {
		return "Hello " + personName;
	}

	//http://localhost:8080/api/greeter?name=Sawitzki
	@GET
	@Produces("text/plain")
	public String greetWithQueryParam(@QueryParam("name") String personName) {
		return "Hello " + personName;
	}

}
