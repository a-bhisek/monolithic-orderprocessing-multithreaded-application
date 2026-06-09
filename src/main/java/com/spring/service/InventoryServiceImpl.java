package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ProductEntity;
import com.spring.exceptions.ProductNotAvailableException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.repository.ProductRepository;

@Service
public class InventoryServiceImpl implements IInventoryService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public boolean checkStock(int productId, int quantity) throws ProductOutOfStockException, ProductNotAvailableException {
		ProductEntity prod = productRepo.findById(productId)
                .orElseThrow(()-> new ProductNotAvailableException("Invalid Product Id"));
       if(prod.getStock() < quantity)throw new ProductOutOfStockException("Product is Out Of Stock");
		return true;
	}

	@Override
	public void reduceStock(int productId, int quantity) throws ProductOutOfStockException, ProductNotAvailableException {
		ProductEntity prod = productRepo.findById(productId)
                .orElseThrow(()-> new ProductNotAvailableException("Invalid Product Id"));
		Integer newStock = prod.getStock() - quantity;
		prod.setStock(newStock);
		productRepo.save(prod);
		
	}

}
