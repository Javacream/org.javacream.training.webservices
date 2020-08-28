package org.javacream.training.store.web;

import org.javacream.ApplicationContext;
import org.javacream.store.api.StoreService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	private StoreService storeService = ApplicationContext.getStoreService();

	@GetMapping(path = "api/store2/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public int getStockPlain(@PathVariable("category") String cat, @PathVariable("item") String id) {
		return storeService.getStock(cat, id);
	}
	@GetMapping(path = "api/store/{category}/{item}", produces = MediaType.TEXT_HTML_VALUE)
	public String getStockHtml(@PathVariable("category") String cat, @PathVariable("item") String id) {
		return "<p>"+storeService.getStock(cat, id)+"<p>";
	}
}
