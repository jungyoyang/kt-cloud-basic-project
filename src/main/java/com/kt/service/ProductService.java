package com.kt.service;

import static com.kt.common.ErrorCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.common.CustomException;
import com.kt.common.ErrorCode;
import com.kt.domain.product.Product;
import com.kt.repository.ProductRepository;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	// dto로 하는경우와 인자로넣는경우가있는데 지금은 인자로넣는경우를 실습
	// productCreateRequest가 service단까지오는게 이상한것같다 라고하면 이렇게하는거
	// 서비스에서는 이 dto를 알지 않게하고 풀어서쓰는 방법
	public void create(String name, Long price, Long quantity) {
		productRepository.save(
			new Product(
				name,
				price,
				quantity
			)
		);
	}

	public void update(Long id, String name, Long price, Long quantity) {
		var product = productRepository.findByIdOrThrow(id);

			product.update(name, price, quantity);
	}

	public void soldOut(Long id) {
		var product = productRepository.findByIdOrThrow(id);

			product.soldOut();
	}
	public void inActivate(Long id) {
		var product = productRepository.findByIdOrThrow(id);

			product.inActivate();
	}

	public void activate(Long id) {
		var product = productRepository.findByIdOrThrow(id);

			product.activate();
	}

	public void delete(Long id) {
		var product = productRepository.findByIdOrThrow(id);

			product.delete();
	}

	public void decreaseStock(Long id, Long quantity){
		var product = productRepository.findByIdOrThrow(id);

			product.decreaseStock(quantity);

	}

	public void increaseStock(Long id, Long quantity){
		var product = productRepository.findByIdOrThrow(id);

		product.increaseStock(quantity);

	}
}
























