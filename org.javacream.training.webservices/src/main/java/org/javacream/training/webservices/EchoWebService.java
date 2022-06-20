package org.javacream.training.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoWebService {

	@GetMapping(path = "ping")
	public String ping() {
		return "pong";
	}
}
