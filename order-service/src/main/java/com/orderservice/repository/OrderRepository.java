package com.orderservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.Orders;

@Repository
public interface OrderRepository extends MongoRepository<Orders,String>{

	Optional<Orders> findBycustomerId(String customerId);

	void deleteBycustomerId(String cartId);


}
