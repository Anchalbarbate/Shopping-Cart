package com.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.exception.OrderNotFoundException;
import com.orderservice.model.Orders;
import com.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	Logger log=LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository repo;

	@Override
	public List<Orders> getAllOrders() throws OrderNotFoundException{
		log.info("getAllOrders method started");
		List<Orders>orders=new ArrayList<>();	
		orders=repo.findAll();				
		if(orders.isEmpty()) {
			log.error("OrderNotFoundException Occurs: No order Found");
			throw new OrderNotFoundException("No order Found") ;
		}
		log.info("getAllOrders method ended");
		return orders; 
	}

	@Override
	public Orders getOrderByCustomerId(String customerId)throws OrderNotFoundException{
		log.info("getOrderByCustomerId method started");
		Optional<Orders> oporder=repo.findBycustomerId(customerId);
		Orders order=oporder.get();
		if(order.getItems().isEmpty()) {
			log.error("OrderNotFoundException Occurs: No Items Available");
			throw new OrderNotFoundException("No Items Available");
		}
		log.info("getOrderByCustomerId method ended");
		return order;
	}

	@Override
	public Orders placeOrder(Orders order) {
		log.info("placeOrder method started");
		Orders neworder=repo.save(order);
		log.info("placeOrder method ended");
		return neworder;
	}

	

	@Override
	public void deleteOrder(String customerId) {
		repo.deleteBycustomerId(customerId);
		
	}
	
	
	

}
