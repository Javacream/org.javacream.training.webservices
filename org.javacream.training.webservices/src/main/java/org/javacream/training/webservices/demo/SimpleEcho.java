package org.javacream.training.webservices.demo;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

	@GET
	@Path("echo/{part1}-{part2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String echoWithPathParam(@PathParam("part1") String pathMessage, @PathParam("part2") boolean b) {
		System.out.println("Echoing message " + pathMessage);
		return "Back from server: " + pathMessage;
	}
	@GET
	@Path("echo")
	@Produces(MediaType.TEXT_PLAIN)
	public String echoWithQueryParam(@QueryParam("message") String queryMessage) {
		System.out.println("Echoing message " + queryMessage);
		return "Back from server: " + queryMessage;
	}
	@GET
	@Path("echo/header")
	@Produces(MediaType.TEXT_PLAIN)
	public String echoWithHeaderParam(@HeaderParam("message") String headerMessage) {
		System.out.println("Echoing message " + headerMessage);
		return "Back from server: " + headerMessage;
	}

	@GET
	@Path("echo/body")
	@Produces(MediaType.TEXT_PLAIN)
	public String echoWithBodyParam(String bodyMessage) {
		System.out.println("Echoing message " + bodyMessage);
		return "Back from server: " + bodyMessage;
	}

}
