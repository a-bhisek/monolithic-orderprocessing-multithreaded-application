package com.spring.exceptions;

@SuppressWarnings("serial")
public class ProductNotAvailableException extends Exception {

	public ProductNotAvailableException(String msg) {
		super(msg);
	}
}
