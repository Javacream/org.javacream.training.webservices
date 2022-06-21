package org.javacream.training.webservices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoWebService {

	@GetMapping(path = "ping", produces = MediaType.TEXT_PLAIN_VALUE)
	public String ping() {
		return "pong";
	}
	
	@GetMapping(path="echo/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String echo(@PathVariable("m") String message) {
		System.out.println("receiving message "+ message);
		return message;
	}

	@PostMapping(path="greet/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String greet(@PathVariable("name") String name) {
		return "Hello " + name;
	}

	@GetMapping(path = "alternative_ping")
	public ResponseEntity<String> alternativePing() {
		return ResponseEntity.ok().header("this", "that").body("pong");
	}
	@GetMapping(path = "alternative2_ping")
	public void alternative2Ping(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getParameter("HUGO");
		response.setHeader("this", "that");
		response.setStatus(200);
		response.getWriter().println("pong");
	}

	@GetMapping(path = "ping", produces = "javacream/hugo")
	public String pingWithCustomMediatType() {
		return "pong";
	}

	
}
