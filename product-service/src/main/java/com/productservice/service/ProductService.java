package com.productservice.service;

import java.util.List;
import com.productservice.model.Product;

public interface ProductService {

	Product addproduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(String productId);	

	Product updateProduct(String productId, Product newproduct);

	Product removeProductById(String productId);


}
	
