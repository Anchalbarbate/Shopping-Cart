package com.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cartservice.model.Cart;
import com.cartservice.model.Items;
import com.cartservice.model.Product;
import com.cartservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CartService service;
	
	@GetMapping("/getcart")
	public List<Cart> getAllCarts() {
		return service.getAllCarts();
	}
	
	@PostMapping("/newcart/{cartId}")
	public ResponseEntity<Cart> creatCart(@PathVariable String cartId) {	
	     Cart newcart=service.createCart(cartId);
	     return new ResponseEntity<>(newcart,HttpStatus.CREATED);
	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable("cartId") String cartId) {
		Cart cart= service.getCartById(cartId);
		return new ResponseEntity<Cart>(cart,HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/removecart/{cartId}")
	public ResponseEntity<Cart> removeCartById(@PathVariable("cartId") String cartId) {
		service.removeCartById(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PostMapping("/addItem/{cartId}/product/{productId}")
	public ResponseEntity<Cart> addItemToCart(@PathVariable("cartId") String cartId,@PathVariable("productId") String productId){
		ResponseEntity<Product>responseEntity=restTemplate.getForEntity("http://localhost:8000/product/"+ productId,Product.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			Product  producttoAdd=responseEntity.getBody();
			Items item=new Items();
			item.setProductId(producttoAdd.getProductId());
			item.setProductName(producttoAdd.getProductName());
			item.setPrice(producttoAdd.getPrice());
			item.setQuantity(1);
			Cart updatedCart= service.addItemToCart(cartId,item);
			return new ResponseEntity<Cart>(updatedCart,HttpStatus.OK);
		}
		
		else{
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
	}
		
	@DeleteMapping("/{cartId}/removeItem/{productId}")
	public ResponseEntity<Cart> removeItemFromCart(@PathVariable("cartId")String cartId,@PathVariable("productId")String productId) {
		service.removeItemFromCart(cartId,productId);
		return new ResponseEntity<>(HttpStatus.OK);

	}
		

	
}
