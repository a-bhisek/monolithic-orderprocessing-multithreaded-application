package com.spring.service;

import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;

public interface IInventoryService {

	public boolean checkStock(int productId, int quantity)throws ProductOutOfStockException, ProductNotAvailableException;
	public void reduceStock(int productId, int quantity) throws ProductOutOfStockException, ProductNotAvailableException;
}
