package com.orderservice.service;

import java.util.List;
import com.orderservice.model.Orders;

public interface OrderService {

	List<Orders> getAllOrders();

	Orders getOrderByCustomerId(String customerId);

	Orders placeOrder(Orders order);

	void deleteOrder(String customerId);



	


}
