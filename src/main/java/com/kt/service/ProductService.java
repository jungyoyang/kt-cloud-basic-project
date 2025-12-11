package com.kt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.domain.product.Product;
import com.kt.repository.ProductRepository;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	//dto로 하는경우와 인자로넣는경우가있는데 지금은 인자로넣는경우를 실습
	public void create(String name, Long price, Long quantity) {
		productRepository.save(
			new Product(
				name,
				price,
				quantity
			)
		);
	}
}
























