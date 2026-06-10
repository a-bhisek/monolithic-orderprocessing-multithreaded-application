package com.spring.threads;
import com.spring.entity.OrderEntity;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.service.IInventoryService;

public class InventoryThread extends Thread {

	private IInventoryService inventory;
	private OrderEntity order;
	
	public InventoryThread(OrderEntity order, IInventoryService inventory) {
		this.order = order;
		this.inventory = inventory;
	}
	
	public void run() {
		Thread.currentThread().setName("Inventory Thread");
		System.out.println(Thread.currentThread().getName() + " started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			inventory.checkStock(order.getProduct().getProductId(), order.getQuantity());
		} catch (ProductOutOfStockException e) {
			e.printStackTrace();
		} catch (ProductNotAvailableException e) {
			e.printStackTrace();
		}
		try {
			inventory.reduceStock(order.getProduct().getProductId(), order.getQuantity());
		} catch (ProductOutOfStockException e) {
			e.printStackTrace();
		} catch (ProductNotAvailableException e) {
			e.printStackTrace();
		}
	}
}
