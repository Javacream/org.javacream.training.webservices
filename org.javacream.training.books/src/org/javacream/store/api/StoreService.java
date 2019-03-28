package org.javacream.store.api;

public interface StoreService {

	int getStock(String category, String id);
	void setStock(String category, String id, int stock);
	void remove(String category, String id);
	void remove(String category);
	void remove();
	
}
