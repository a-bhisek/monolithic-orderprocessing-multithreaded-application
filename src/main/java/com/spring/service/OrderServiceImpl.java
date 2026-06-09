package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.OrderEntity;
import com.spring.entity.ProductEntity;
import com.spring.exceptions.OrderIdNotFoundException;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.repository.OrderRepository;
import com.spring.repository.ProductRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private IInventoryService inventory;

	@Override
	public OrderEntity placeOrder(OrderEntity order) throws ProductNotAvailableException,
	                                                        ProductOutOfStockException {
		inventory.checkStock(order.getProduct().getProductId(), order.getQuantity());
		inventory.reduceStock(order.getProduct().getProductId(), order.getQuantity());
		ProductEntity product = productRepo.findById(order.getProduct().getProductId()).orElseThrow(()-> new ProductNotAvailableException("Invalid Product Id"));;
		double totalPrice = product.getPrice() * order.getQuantity();
		order.setTotalAmount(totalPrice);
		order.setProduct(product);
		return orderRepo.save(order);
	}

	@Override
	public OrderEntity getOrderDetails(int orderId) throws OrderIdNotFoundException {
		
		return orderRepo.findById(orderId)
                .orElseThrow(()->new OrderIdNotFoundException("Order Id Not Found"));
	}

	@Override
	public OrderEntity updateOrderStatus(int orderId, String status) throws OrderIdNotFoundException {
		OrderEntity order = orderRepo.findById(orderId)
                .orElseThrow(()->new OrderIdNotFoundException("Order Id Not Found"));
		order.setStatus(status);
		return orderRepo.save(order);
	}

}
