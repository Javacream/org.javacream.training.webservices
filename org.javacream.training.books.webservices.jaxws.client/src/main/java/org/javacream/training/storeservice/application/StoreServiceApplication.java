package org.javacream.training.storeservice.application;

import org.javacream.application.Context;

public class StoreServiceApplication {

	public static void main(String[] args) {
		StoreServiceActor actor = new StoreServiceActor();
		actor.setStoreService(Context.getStoreService());
		actor.act();
	}
}
