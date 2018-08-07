package org.javacream.training.storeservice.application;

import org.javacream.store.api.StoreService;

public class StoreServiceActor {

	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	public void act() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			storeService.getStock("books", "ISBN" + i);
		}
		System.out.println("Retrieving 100 stocks took " + (System.currentTimeMillis() - start));

		
		
	}
}
