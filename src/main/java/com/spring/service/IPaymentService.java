package com.spring.service;

import com.spring.entity.PaymentEntity;
import com.spring.exceptions.PaymentIdNotFoundException;

public interface IPaymentService {

	public PaymentEntity processPayment(PaymentEntity payment);
	public PaymentEntity getPaymentDetails(int paymentId) throws PaymentIdNotFoundException;
}
