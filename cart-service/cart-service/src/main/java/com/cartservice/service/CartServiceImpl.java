package com.cartservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartservice.exception.CartNotFoundException;
import com.cartservice.model.Cart;
import com.cartservice.model.Items;
import com.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	Logger logger=LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	private CartRepository repo;
	
	@Override
	public List<Cart> getAllCarts() {
		
		List<Cart> cartlist=new ArrayList<>();
		logger.info("getAllCarts method in service class started");
		cartlist=repo.findAll();
		if(cartlist.isEmpty()) {
			logger.error("Exception in findAll method in service class");
			throw new CartNotFoundException("Cart is Empty");
		}
		logger.info("getAllCarts method in service class ended");
		return cartlist;
	}

	@Override
	public Cart createCart(String cartId) {	 
		logger.info("addCart method in service class started");
		Cart newcart=new Cart();
		newcart.setCartId(cartId);
		logger.info("addCart method in service class ended");
		return repo.save(newcart);
	}

	@Override
	public Cart getCartById(String cartId) {
		logger.info("getCartById method in service class started");
		Cart cart=null;
		if(repo.existsBycartId(cartId)) {	 
		 cart=repo.findBycartId(cartId);
		}
		else {
			logger.error("Exception in getCartByIdt method in service class");
			throw new CartNotFoundException("Cart does not exist");
		}
		logger.info("getCartById method in service class ended");
		return cart;
	}

	@Override
	public Cart addItemToCart(String cartId, Items item) {
		// TODO Auto-generated method stub
		logger.info("addItemToCart method in service class started");
		Cart cart=repo.findBycartId(cartId);
		if(cart!=null) {
			List<Items> items=cart.getItems();
			for(Items existingtItem:items) {
				if(existingtItem.getProductId().equals(item.getProductId())) {
					existingtItem.setQuantity(existingtItem.getQuantity()+item.getQuantity());
					cart.setTotalPrice(cart.getTotalPrice()+item.getPrice());
					logger.info("addItemToCart method in service class ended");
					return repo.save(cart);
				}
				
			}
			
			cart.getItems().add(item);
			cart.setTotalPrice(cart.getTotalPrice()+item.getPrice());
			logger.info("addItemToCart method in service class ended");
			return repo.save(cart);
		}
		logger.info("addItemToCart method in service class ended");
		return null;
		}

	@Override
	public Cart removeCartById(String cartId) {
		// TODO Auto-generated method stub
		logger.info("removeCartById method in service class started");
		Cart cart=repo.deleteBycartId(cartId);
		logger.info("removeCartById method in service class ended");
		return cart;
	}

	@Override
	public void removeItemFromCart(String cartId, String productId) {
		// TODO Auto-generated method stub
		logger.info("removeItemFromCart method in service class started");
		Items item=null;
		Cart cart=repo.findBycartId(cartId);
		List <Items>items=cart.getItems();
		for(Items deleteItem:items) {
			if(deleteItem.getProductId().equals(productId)) {				
				item=deleteItem;
			}
		}
		cart.getItems().remove(item);
		cart.setTotalPrice(cart.getTotalPrice()-(item.getPrice()*item.getQuantity()));
		
		repo.save(cart);
		logger.info("removeItemFromCart method in service class ended");
	}

		

}
