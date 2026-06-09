package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer>{

}
