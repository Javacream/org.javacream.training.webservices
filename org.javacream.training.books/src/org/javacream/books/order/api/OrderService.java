package org.javacream.books.order;

import java.util.List;

public interface OrderService {

	OrderValue create(String customer, String isbn);
	List<OrderValue> find(String customer);
	List<OrderValue> find(String customer, boolean status);
}
