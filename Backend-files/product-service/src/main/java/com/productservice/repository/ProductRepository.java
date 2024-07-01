package com.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.productservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String>{

	boolean existsByproductId(String string);

	Product findByproductId(String productId);

	Product deleteByproductId(String productId);

	



	



}
