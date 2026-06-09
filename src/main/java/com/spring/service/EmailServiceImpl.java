package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

	@Override
	public void sendOrderConfirmation() {
		System.out.println("Order placed");
	}

	@Override
	public void sendPaymentConfirmation() {
		System.out.println("Payment Successful");
		
	}

	
}
