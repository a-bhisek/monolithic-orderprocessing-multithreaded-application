package com.spring.exceptions;

@SuppressWarnings("serial")
public class ProductOutOfStockException extends Exception {

	public ProductOutOfStockException(String msg){
		super(msg);
	}
}
