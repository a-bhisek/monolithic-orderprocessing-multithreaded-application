package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
