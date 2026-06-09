package com.spring.service;

import com.spring.entity.OrderEntity;
import com.spring.exceptions.OrderIdNotFoundException;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;

public interface IOrderService {

	public OrderEntity placeOrder(OrderEntity order)throws ProductNotAvailableException, ProductOutOfStockException;
	public OrderEntity getOrderDetails(int orderId) throws OrderIdNotFoundException;
	public OrderEntity updateOrderStatus(int orderId, String status) throws OrderIdNotFoundException;
}