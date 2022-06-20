package org.javacream.training.webservices.store;

import org.javacream.store.StoreService;
import org.javacream.util.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	private StoreService storeService = ApplicationContext.getStoreService();

//	@GetMapping(path="api/store/{cat}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
//	public String getStock(@PathVariable("cat") String category, @PathVariable("item") String item) {
//		return "Stock: " + storeService.getStock(category, item);
//	}

	@GetMapping(path="api/store", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@RequestHeader("cat") String category, @RequestParam("item") String item) {
		return "Stock: " + storeService.getStock(category, item);
	}

}
