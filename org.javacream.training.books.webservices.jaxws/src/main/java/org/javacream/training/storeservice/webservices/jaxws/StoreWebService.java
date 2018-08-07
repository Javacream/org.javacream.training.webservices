package org.javacream.training.storeservice.webservices.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.javacream.store.api.StoreService;

@WebService
public class StoreWebService {
	private StoreService storeService;
	@WebMethod(exclude=false, operationName="GetStock")	
	@WebResult(name="Stock") public int getStock(@WebParam(name= "Category") String category, @WebParam(name= "ItemId") String id) {
		return storeService.getStock(category, id);
	}

	@WebMethod(exclude=true)
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	
}
