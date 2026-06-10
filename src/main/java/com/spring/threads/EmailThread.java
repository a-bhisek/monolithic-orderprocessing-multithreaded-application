package com.spring.threads;

import com.spring.service.IEmailService;

public class EmailThread extends Thread {

	private IEmailService emailService;
	
	public EmailThread(IEmailService emailService) {
		this.emailService = emailService;
	}
	
	public void run() {
		Thread.currentThread().setName("Email Thread");
		System.out.println(Thread.currentThread().getName() + " started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emailService.sendOrderConfirmation();
		emailService.sendPaymentConfirmation();
	}
}
