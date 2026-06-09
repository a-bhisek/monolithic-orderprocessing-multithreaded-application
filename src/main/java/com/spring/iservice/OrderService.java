package com.spring.iservice;

import com.spring.entity.OrderEntity;
import com.spring.exceptions.ProductNotAvailableException;

public interface OrderService {

	public OrderEntity placeOrder()throws ProductNotAvailableException;
}
