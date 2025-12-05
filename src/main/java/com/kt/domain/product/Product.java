package com.kt.domain.product;


import com.kt.common.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Product extends BaseEntity {

	private String name;
	private int price;
	private int stock;
	private ProductStatus status;


}
