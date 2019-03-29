package org.javacream.training.webservices.springmvc.spring.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoWebService {

	@GetMapping(path="spring_echo/ping")
	public String ping() {
		return "peng";
	}
}
