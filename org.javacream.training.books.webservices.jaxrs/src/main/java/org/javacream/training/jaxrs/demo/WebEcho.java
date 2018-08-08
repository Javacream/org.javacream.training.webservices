package org.javacream.training.jaxrs.demo;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("demo")
public class WebEcho {

	//Diese Methode soll aufgerufen werden bei einem GET-Request und Plain-Text liefern
	//Path für die Anwendung: "ping"
	//Aufruf-URL: GET http://localhost:8080/jee/rest/demo/ping
	
	@GET @Path("ping")
	public String ping() {
		return "pong";
	}
	@DELETE @Path("ping")
	public void pingDelete() {
		System.out.println("deleting");
	}

	//Aufruf-URL: GET http://localhost:8080/jee/rest/demo/echo/freitext
	
	@GET @Path("echo/{messageParam}") @Produces(MediaType.TEXT_PLAIN)
	public String echo(@PathParam("messageParam")String message) {
		System.out.println("echoing " + message);
		return new StringBuilder(message).reverse().toString();
	}
}
