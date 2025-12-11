package com.kt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kt.dto.product.ProductRequest;

import jakarta.validation.Valid;

public class ProductController {
	@PostMapping
	public void create(@RequestBody @Valid ProductRequest.Create)
}
