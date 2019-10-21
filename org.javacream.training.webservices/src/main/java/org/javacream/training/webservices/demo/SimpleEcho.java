package org.javacream.training.webservices.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("api")
public class SimpleEcho {

	@Path("ping")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String pingRespond() {
		System.out.println("RECEIVED PING, RESPONDING PONG...");
		return "PONG";
	}
	@Path("ping")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String pingRespond2() {
		System.out.println("RECEIVED PING, RESPONDING PONG...");
		return "<p>PONG</p>";
	}
}
