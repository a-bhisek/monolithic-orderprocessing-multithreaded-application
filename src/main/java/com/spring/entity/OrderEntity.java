package com.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ORDERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderEntity {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "ORDERS_SEQ",allocationSize = 1,initialValue = 1001)
	@GeneratedValue(generator = "gen1",strategy=GenerationType.SEQUENCE)
	private Integer orderId;

	@NonNull
	private Integer quantity;
	@NonNull
	private Double totalAmount;
	@Column(length=30)
	private String status = "PROCESSING";
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "productId")
	private ProductEntity product;
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime orderPlacedTime;
	@UpdateTimestamp
	@Column(updatable = true)
	private LocalDateTime orderUpdatedTime;
	
}
