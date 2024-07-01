package com.cartservice.service;

import java.util.List;

import com.cartservice.model.Cart;
import com.cartservice.model.Items;

public interface CartService {

	List<Cart> getAllCarts();
	
	Cart getCartById(String cartId);

	Cart createCart(String cartId);

	Cart addItemToCart(String cartId, Items item);

	Cart removeCartById(String cartId);

	void removeItemFromCart(String cartId, String productId);

	
}
