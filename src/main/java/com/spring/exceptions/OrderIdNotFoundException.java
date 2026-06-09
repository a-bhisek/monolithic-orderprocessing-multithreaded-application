package com.spring.exceptions;

@SuppressWarnings("serial")
public class OrderIdNotFoundException extends Exception {

	public OrderIdNotFoundException(String msg) {
		super(msg);
	}
}
