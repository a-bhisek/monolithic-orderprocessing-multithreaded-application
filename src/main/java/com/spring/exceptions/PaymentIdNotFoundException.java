package com.spring.exceptions;

@SuppressWarnings("serial")
public class PaymentIdNotFoundException extends Exception {

	public PaymentIdNotFoundException(String msg) {
		super(msg);
	}
}
