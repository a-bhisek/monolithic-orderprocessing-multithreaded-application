package com.spring.threads;
import java.util.concurrent.Callable;

import com.spring.entity.OrderEntity;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.service.IInventoryService;

public class InventoryThread implements Callable<Boolean> {

	private IInventoryService inventory;
	private OrderEntity order;
	
	public InventoryThread(OrderEntity order, IInventoryService inventory) {
		this.order = order;
		this.inventory = inventory;
	}
	@Override
	public Boolean call() {
		Thread.currentThread().setName("Inventory Thread");
		System.out.println(Thread.currentThread().getName() + " started");
	 	
		
		try {
			Thread.sleep(5000);
			boolean flag = inventory.checkStock(order.getProduct().getProductId(), order.getQuantity());
			if(flag) {
				inventory.reduceStock(order.getProduct().getProductId(), order.getQuantity());
				return true;
			}
		} catch (ProductOutOfStockException e) {
			e.printStackTrace();
		} catch (ProductNotAvailableException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
