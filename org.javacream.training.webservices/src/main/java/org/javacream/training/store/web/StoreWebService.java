package org.javacream.training.store.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.javacream.ApplicationContext;
import org.javacream.store.api.StoreService;

@Path("api/store")
public class StoreWebService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{category}")
	public List<Integer> getStocks(@PathParam("category") String category, @QueryParam("ids") List<String> ids) {
		System.out.println("retrieving stock for category" + category + " and ids" + ids);
		StoreService storeService = ApplicationContext.getStoreService();
		return ids.stream().map((id) -> storeService.getStock(category, id)).collect(Collectors.toList());
	}
}
