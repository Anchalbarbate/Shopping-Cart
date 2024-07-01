package com.cartservice.exception;

public class CartNotFoundException extends RuntimeException{
	public CartNotFoundException(String msg) {
		super(msg);
	}

}
