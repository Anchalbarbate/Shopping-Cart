package com.cartservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cartservice.exception.CartNotFoundException;
import com.cartservice.model.Cart;
import com.cartservice.model.Items;
import com.cartservice.repository.CartRepository;
import com.cartservice.service.CartServiceImpl;



@SpringBootTest
class CartServiceApplicationTests {

	//mock the ProductRepository
		 @Mock
		 private CartRepository cartRepository;
		 
		//to inject mock
		 @InjectMocks
		 private CartServiceImpl cartService;
		 

	   @Test
	   public void testgetAllCarts(){
		   Cart mockCart1=new Cart();
		   Cart mockCart2=new Cart();
	       List<Cart>list=new ArrayList<>();
	       list.add(mockCart1);
	       list.add(mockCart2);
	       
	        when(cartRepository.findAll()).thenReturn(list);		
			List<Cart>list2=cartService.getAllCarts();		
			assertEquals(2, list2.size());
		   
	   }
	   
	   @Test
	   public void testgetCartById() {
		   Cart cart=new Cart();
		   cart.setCartId("cart123");
		   
		   when(cartRepository.findBycartId("cart123")).thenReturn(cart);
		   //Cart cartfound=cartService.getCartById("cart123");
		  // assertEquals("cart123",cartfound.getCartId());
		   assertThrows(CartNotFoundException.class,()->{
			   cartService.getCartById("cart456");});
		   
		   verify(cartRepository.findBycartId("cart456"));
	   }

}
