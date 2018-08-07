package org.javacream.books.order.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javacream.books.order.OrderService;
import org.javacream.books.order.OrderValue;
public class OrderServiceImpl implements OrderService{

	private Random random;
	private List<OrderValue> orderValues;
	{
		
		
		random = new Random(System.currentTimeMillis() + this.hashCode());
		orderValues = new ArrayList<OrderValue>();
		boolean status = true;
		for (int i = 0; i < 10; i++){
			status = !status;
			OrderValue orderValue = new OrderValue(i, status, "Sawitzki", "ISBN" + i);
			orderValues.add(orderValue);
		}
		
	}
	@Override
	public OrderValue create(String customer, String isbn) {
		OrderValue orderValue = new OrderValue(random.nextInt(), true, customer, isbn);
		orderValues.add(orderValue);
		return orderValue;
	}

	@Override
	public List<OrderValue> find(String customer) {
		ArrayList<OrderValue> result = new ArrayList<OrderValue>();
		for (OrderValue order: orderValues){
			if (order.getCustomer().equals(customer)){
				result.add(order);
			}
		}
		return result;
	}

	@Override
	public List<OrderValue> find(String customer, boolean status) {
		ArrayList<OrderValue> result = new ArrayList<OrderValue>();
		for (OrderValue order: orderValues){
			if (order.getCustomer().equals(customer) && order.isStatus() == status){
				result.add(order);
			}
		}
		return result;
	}

}
