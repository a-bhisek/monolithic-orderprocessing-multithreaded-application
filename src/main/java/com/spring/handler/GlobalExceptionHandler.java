package com.spring.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.entity.ErrorDetails;
import com.spring.exceptions.OrderIdNotFoundException;
import com.spring.exceptions.PaymentIdNotFoundException;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;

@RestControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(OrderIdNotFoundException.class)
	public ResponseEntity<ErrorDetails> handelOrderNotFound(OrderIdNotFoundException oex){
		System.out.println("GlobalExceptionHandler.handelOrderNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), oex.getMessage() ,"404 OrderId Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PaymentIdNotFoundException.class)
	public ResponseEntity<ErrorDetails> handelPaymentNotFound(PaymentIdNotFoundException pex){
		System.out.println("GlobalExceptionHandler.handelPaymentNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), pex.getMessage() ,"404 ProductId Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductNotAvailableException.class)
	public ResponseEntity<ErrorDetails> handelProductNotAvailable(ProductNotAvailableException pnex){
		System.out.println("GlobalExceptionHandler.handelOrderNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), pnex.getMessage() ,"404 Product Not Available");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductOutOfStockException.class)
	public ResponseEntity<ErrorDetails> handelProductOutOfStock(ProductOutOfStockException poex){
		System.out.println("GlobalExceptionHandler.handelProductOutOfStock()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), poex.getMessage() ,"404 Product Out Of Stock");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handelAllExceptions(Exception e){
		System.out.println("GlobalExceptionHandler.handelAllExceptions()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "404 Error In  Execution");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
