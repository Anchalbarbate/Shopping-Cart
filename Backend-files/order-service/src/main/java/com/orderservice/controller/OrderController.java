package com.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderservice.model.Cart;
import com.orderservice.model.Orders;
import com.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders() {
		return service.getAllOrders();
	}
	
	@GetMapping("/getOrderById/{customerId}")
	public Orders getOrderByCustomerId(@PathVariable("customerId") String customerId) {
		return service.getOrderByCustomerId(customerId);
	}
	
	@PostMapping("/placeOrder/{cartId}")
	public ResponseEntity<Orders> placeOrder(@PathVariable("cartId") String cartId) {
		ResponseEntity<Cart> opcart=restTemplate.getForEntity("http://localhost:8100/cart/"+ cartId,Cart.class);
		Orders order=new Orders();
		if(opcart.getStatusCode()== HttpStatus.FOUND) {
			Cart cart=opcart.getBody();
			order.setCustomerId(cart.getCartId());
			order.setAmmountpaid(cart.getTotalPrice());
			order.setItems(cart.getItems());
			order.setOrderStatus("Ordered");
			order.setModeOfPayment("Online");
			order.setOrderDate(order.getOrderDate());
			Orders saveorder= service.placeOrder(order);
			return new ResponseEntity<Orders>(saveorder,HttpStatus.CREATED); 
		}
		else {
			return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	 @DeleteMapping("/cancelOrder/{customerId}")
     public void deleteOrder(@PathVariable("customerId") String customerId) {
    	service.deleteOrder(customerId);
      }

}
