package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.PaymentEntity;
import com.spring.exceptions.PaymentIdNotFoundException;
import com.spring.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Override
	public PaymentEntity processPayment(PaymentEntity payment) {
		return paymentRepo.save(payment);
	}

	@Override
	public PaymentEntity getPaymentDetails(int paymentId) throws PaymentIdNotFoundException {
		
		return paymentRepo.findById(paymentId)
				           .orElseThrow(()-> new PaymentIdNotFoundException("Invalid Payment Id"));
	}

}
