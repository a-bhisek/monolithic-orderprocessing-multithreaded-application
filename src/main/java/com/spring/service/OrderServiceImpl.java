package com.spring.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.OrderEntity;
import com.spring.entity.PaymentEntity;
import com.spring.entity.ProductEntity;
import com.spring.exceptions.OrderIdNotFoundException;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.repository.OrderRepository;
import com.spring.repository.ProductRepository;
import com.spring.threads.EmailThread;
import com.spring.threads.InventoryThread;
import com.spring.threads.PaymentThread;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private IInventoryService inventory;
	
	@Autowired
	private IEmailService emailService;
	
	@Autowired
	private IPaymentService paymentService;

	@Override
	public OrderEntity placeOrder(OrderEntity order) throws ProductNotAvailableException,
	                                                        ProductOutOfStockException, InterruptedException, ExecutionException {
		InventoryThread inventoryThread = new InventoryThread(order, inventory);
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<Boolean> f = service.submit(inventoryThread);
		if(f.get()) {		
		ProductEntity product = productRepo.findById(order.getProduct().getProductId()).orElseThrow(()-> new ProductNotAvailableException("Invalid Product Id"));;
		double totalPrice = product.getPrice() * order.getQuantity();
		order.setTotalAmount(totalPrice);
		order.setProduct(product);
		EmailThread emailThread = new EmailThread(emailService);
		emailThread.start();
		
		emailThread.join();
		
		OrderEntity savedOrder = orderRepo.save(order);
		
		PaymentEntity payment = new PaymentEntity(totalPrice, savedOrder.getStatus(), "UPI", savedOrder);
		PaymentThread paymentThread = new PaymentThread(paymentService, payment);
		paymentThread.start();
		
		
		paymentThread.join();
		return savedOrder;
		}
		service.shutdown();
		 throw new  ProductOutOfStockException("Product Out Of Stock");
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
