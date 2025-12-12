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
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(("존재하지 않는 상품입니다."))
			);

			product.update(name, price, quantity);
	}

	public void soldOut(Long id) {
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(("존재하지 않는 상품입니다."))
			);

			product.soldOut();
	}

	public void inActivate(Long id) {
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(("존재하지 않는 상품입니다."))
			);


			product.inActivate();
	}

	public void activate(Long id) {
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(("존재하지 않는 상품입니다."))
			);

			product.activate();
	}

	public void delete(Long id) {
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(("존재하지 않는 상품입니다."))
			);

			product.delete();
	}

	public void decreaseStock(Long id, Long quantity){
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(("존재하지 않는 상품입니다."))
			);

			product.decreaseStock(quantity);

	}

	public void increaseStock(Long id, Long quantity){
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(("존재하지 않는 상품입니다."))
			);

		product.increaseStock(quantity);

	}
}
























