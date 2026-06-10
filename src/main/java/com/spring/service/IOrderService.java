package com.spring.service;

import java.util.concurrent.ExecutionException;

import com.spring.entity.OrderEntity;
import com.spring.exceptions.OrderIdNotFoundException;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;

public interface IOrderService {

	public OrderEntity placeOrder(OrderEntity order)throws ProductNotAvailableException, ProductOutOfStockException, InterruptedException, ExecutionException;
	public OrderEntity getOrderDetails(int orderId) throws OrderIdNotFoundException;
	public OrderEntity updateOrderStatus(int orderId, String status) throws OrderIdNotFoundException;
}