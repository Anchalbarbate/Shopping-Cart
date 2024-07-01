package com.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cartservice.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,String>{

	Cart findBycartId(String cartId);

	boolean existsBycartId(String cartId);

	Cart deleteBycartId(String cartId);

}
