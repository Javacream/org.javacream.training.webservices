package org.javacream.training.books.warehouse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ReadingStoreService {
	@Autowired
	@Qualifier("store")
	private RestTemplate restTemplate;

	@GetMapping(path = "api/store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(String category, String id) {
		return restTemplate.getForObject("http://localhost:9091/api/store/" + category + "/" + id, String.class);

	}
}
