package com.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.productservice.model.Product;
import com.productservice.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	
	public ProductController(ProductService productService) {
		// TODO Auto-generated constructor stub
		this.service=productService;
	}

	@PostMapping("/add")
	public ResponseEntity<Product> addproduct(@RequestBody Product product){ 
		Product addedProduct=service.addproduct(product);
		if(addedProduct!=null) {
			return new ResponseEntity<Product>(addedProduct,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
				
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>>  getAllProducts() {
		List<Product>products=service.getAllProducts();
		if(!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") String productId) {
		 Product product=service.getProductById(productId);  
		 if(product!=null) {
			 return new ResponseEntity<>(product,HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}
	
	
    @DeleteMapping("remove/{productId}")
    public ResponseEntity<Product> removeProductById(@PathVariable String productId)  {
    	Product removeProduct=service.removeProductById(productId);
		if(removeProduct!=null) {
			return new ResponseEntity<Product>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
				
    }
    
    @PutMapping("/update/{productId}")
    public ResponseEntity<Product>  updateProduct(@PathVariable("productId") String productId,@RequestBody Product newproduct) {
    	Product product=service.updateProduct(productId, newproduct);
    	if(product!=null) {
			return new ResponseEntity<Product>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}



}

