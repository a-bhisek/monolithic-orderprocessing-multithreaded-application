package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.OrderEntity;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.service.IOrderService;

@RestController
@RequestMapping("/order-api")
public class OrderProcessingRestController {

	@Autowired
	private IOrderService orderService;

	@PostMapping("/placeOrder")
	public ResponseEntity<OrderEntity> placeOrder(@RequestBody OrderEntity order) throws ProductNotAvailableException, ProductOutOfStockException, InterruptedException{
		OrderEntity order1 = orderService.placeOrder(order);
		return new ResponseEntity<OrderEntity>(order1,HttpStatus.CREATED);
	}
}
