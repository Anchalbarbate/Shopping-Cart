package com.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="Product")
public class Product {
	 
	
	@Id
	private String productId;
	
	private String productType;
	private String productName;
	private String category;
	private double price;
	
	public Product() {
		super();
	}
	
	public Product(String productId, String productType, String productName, String category, double price) {
		super();
		
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", productName=" + productName
				+ ", category=" + category + ", price=" + price + "]";
	}
	
	

}
