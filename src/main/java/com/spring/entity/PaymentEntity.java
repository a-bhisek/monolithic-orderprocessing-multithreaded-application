package com.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="PAYMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PaymentEntity {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PAYMENT_SEQ",allocationSize = 1,initialValue = 1001)
	@GeneratedValue(generator = "gen1",strategy=GenerationType.SEQUENCE)
	private Integer paymentId;
	@NonNull
	private Integer orderId;
	@NonNull
	private Double amount;
	@NonNull
	@Column(length=30)
	private String paymentStatus;
	@NonNull
	@Column(length=30)
	private String paymentMode;
	
	@CreationTimestamp
	private LocalDateTime paymentTime;
}
