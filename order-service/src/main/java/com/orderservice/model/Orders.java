package com.orderservice.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Document("Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String orderId;
	private LocalDate orderDate;
	private String customerId;
	private List<Items> items;
	private double ammountpaid;
	private String modeOfPayment;
	private String orderStatus;

	
	
	public Orders() {
		super();
	}

	public Orders(String orderId, LocalDate orderDate, String customerId,List<Items> items, double ammountpaid, String modeOfPayment,
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.items=items;
		this.ammountpaid = ammountpaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getAmmountpaid() {
		return ammountpaid;
	}

	public void setAmmountpaid(double ammountpaid) {
		this.ammountpaid = ammountpaid;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId + ", items="
				+ items + ", ammountpaid=" + ammountpaid + ", modeOfPayment=" + modeOfPayment + ", orderStatus="
				+ orderStatus + "]";
	}

	

	
	
	
}
