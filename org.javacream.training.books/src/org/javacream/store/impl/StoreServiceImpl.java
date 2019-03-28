package org.javacream.store.impl;

import java.util.HashMap;
import java.util.Map;

import org.javacream.store.api.StoreService;

public class StoreServiceImpl implements StoreService{

	private Map<String, Map<String, Integer>> stockMap;
	
	{
		stockMap = new HashMap<>();
	}
	public int getStock(String category, String id) {
		Map<String, Integer> ids = stockMap.get(category);
		if (ids == null) {
			return 0;
		}
		Integer stock = ids.get(id);
		if (id == null) {
			return 0;
		}
		return stock;
	}
	@Override
	public void setStock(String category, String id, int stock) {
		Map<String, Integer> ids = stockMap.get(category);
		if (ids == null) {
			ids = new HashMap<>();
			stockMap.put(category, ids);
		}
		ids.put(id, stock);
		
	}
	@Override
	public void remove(String category, String id) {
		Map<String, Integer> ids = stockMap.get(category);
		if (ids != null) {
			stockMap.remove(id);
		}
	}
	@Override
	public void remove(String category) {
		stockMap.remove(category);
	}
	@Override
	public void remove() {
		stockMap.clear();
		
	}

}
