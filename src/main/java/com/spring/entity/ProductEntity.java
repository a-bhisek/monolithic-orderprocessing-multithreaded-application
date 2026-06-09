package com.spring.entity;

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
@Table(name="PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductEntity {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PRODUCT_SEQ",allocationSize = 1,initialValue = 10001)
	@GeneratedValue(generator = "gen1",strategy=GenerationType.SEQUENCE)
	private Integer productId;
	
	@NonNull
	@Column(length=30)
	private String productName;
	@NonNull
	private Double price;
	@NonNull
	private Integer stock;
	
	
}
