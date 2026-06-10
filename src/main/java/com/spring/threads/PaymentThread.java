package com.spring.threads;

import com.spring.entity.PaymentEntity;
import com.spring.service.IPaymentService;

public class PaymentThread extends Thread {

	private IPaymentService paymentService;
	
	private PaymentEntity paymentEntity;
	
	public PaymentThread(IPaymentService paymentService, PaymentEntity paymentEntity) {
		this.paymentService = paymentService;
		this.paymentEntity = paymentEntity;
	}
	
	public void run() {
		Thread.currentThread().setName("Payment Thread");
		System.out.println(Thread.currentThread().getName() + " started");
		try {
		Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		paymentService.processPayment(paymentEntity);
	}
}
