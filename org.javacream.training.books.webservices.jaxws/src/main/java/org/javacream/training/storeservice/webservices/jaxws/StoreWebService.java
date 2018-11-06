package org.javacream.training.storeservice.webservices.jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.javacream.store.api.StoreService;

@WebService
public class StoreWebService{
	private StoreService storeService;
	@WebMethod(exclude=false, operationName="GetStock")	
	@WebResult(name="Stock") public List<Integer> getStock(@WebParam(name= "Category") String category, @WebParam(name= "ItemIds") List<String> ids) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < ids.size(); i++) {
			result.add(storeService.getStock(category, ids.get(i)));
		}
		return result;
	}

	@WebMethod(exclude=true)
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	
}
