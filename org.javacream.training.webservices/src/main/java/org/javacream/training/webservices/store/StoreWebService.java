package org.javacream.training.webservices.store;

import org.javacream.store.StoreService;
import org.javacream.util.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {
	
	private StoreService storeService = ApplicationContext.getStoreService();

	public String getStock(String category, String item) {
		return "Stock: " + storeService.getStock(category, item);
	}
	
	

}
