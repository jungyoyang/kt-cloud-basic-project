package com.kt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.dto.product.ProductRequest;
import com.kt.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@PostMapping
	public void create(@RequestBody @Valid ProductRequest.Create request){
productService.create();
	}
}
