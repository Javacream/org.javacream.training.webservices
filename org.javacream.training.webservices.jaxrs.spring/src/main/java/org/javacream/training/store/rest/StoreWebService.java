package org.javacream.training.store.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.javacream.application.Context;
import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;

@Component
@Path("store")
public class StoreWebService {

	private StoreService storeService = Context.getStoreService();
	
	@GET @Path("{category}/{itemId}")
	public int getStockUsingPathParameter(@PathParam("category") String category, @PathParam("itemId") String itemId) {
		return storeService.getStock(category, itemId);
	}
	@GET @Path("query") 
	public int getStockUsingQueryParameter(@QueryParam("category") String category, @QueryParam("itemId") String itemId) {
		return storeService.getStock(category, itemId);
	}
	@GET @Path("header") 
	public int getStockUsingHeaderParameter(@HeaderParam("category") String category, @HeaderParam("itemId") String itemId) {
		return storeService.getStock(category, itemId);
	}
	
	@POST @Path("{category}/{itemId}") public void setStock(@PathParam("category") String category, @PathParam("itemId") String itemId, @HeaderParam ("stock") int stock) {
		storeService.setStock(category, itemId, stock);
	}

	@DELETE public void remove() {
		storeService.remove();
	}
	@DELETE @Path("{category}") public void removeCategory(@PathParam("category") String category) {
		storeService.remove(category);
	}
	@DELETE @Path("{category}/{itemId}") public void removeItemId(@PathParam("category") String category, @PathParam("itemId") String itemId) {
		storeService.remove(category, itemId);
	}
}
