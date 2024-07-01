package com.orderservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("carts")
public class Cart {
	
	@Id
	private String cartId;	
    
	private double totalPrice;
	private List<Items>items;
	
	public Cart() {		
		this.items=new ArrayList<>(); 
	}
	
    
	
	public Cart(String cartId, double totalPrice, List<Items> items) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.items = items;
	}



	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalPrice=" + totalPrice + ", items=" + items + "]";
	}

	

	
	
	
	

}
