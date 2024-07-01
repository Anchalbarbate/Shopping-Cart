package com.productservice.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productservice.exception.InvalidProductIDException;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService{
	
	Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
	private ProductRepository repo;
	
	@Override
	public Product addproduct(Product product){
		logger.info("addproduct method  in service class started");
		if(repo.existsByproductId(product.getProductId())) {		
			logger.error("Exception in addproduct in service class");
			throw new InvalidProductIDException("Product already exist");
		}
		
		else {
			logger.info("addproduct method  in service class ended");
			return repo.save(product);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product>productlist=new ArrayList<>();	
		
			logger.info("getAllProducts method  in service class started");
			productlist=repo.findAll();
			if(productlist.isEmpty()) {
				logger.error("Exception in getAllProducts in service class");
				throw new InvalidProductIDException("No Product Found");
			
		}			
		logger.info("getAllProducts method  in service class ended");
		return productlist;
	}
	
	
	@Override
	public Product getProductById(String productId) throws InvalidProductIDException{
		
		Product product=null;
		if(repo.existsByproductId(productId)) {
			logger.info("getProductById method  in service class started");
			 product=repo.findByproductId(productId);
			 logger.info("getProductById method  in service class ended");
			 return product;
		}
		else {
			logger.error("Exception in getProductById in service class");
			throw new InvalidProductIDException("Product is out of stock");
		}
		
	}
		

	@Override
	public Product updateProduct(String productId,Product newproduct)throws InvalidProductIDException{
		Product product=null;
		if(!repo.existsByproductId(productId)) {
			logger.error("Exception in updateProduct in service class");
			throw new InvalidProductIDException("Product not found");
		}
		else {
			logger.info("updateProduct method  in service class started");
			newproduct.setProductId(productId);
			product=repo.save(newproduct);
		}		
		logger.info("updateProduct method  in service class ended");
		return product;
	}

	@Override
	public Product removeProductById(String productId) {
		if(repo.existsByproductId(productId)) {
			logger.info("removeProductById method  in service class started");
			Product product=repo.deleteByproductId(productId);
			logger.info("removeProductById method  in service class ended");
			return product;
		}
		else {
			logger.error("Exception in removeProductById in service class");
			throw new InvalidProductIDException("Product not found");
		}
		
		
	}
	
	
	

}
