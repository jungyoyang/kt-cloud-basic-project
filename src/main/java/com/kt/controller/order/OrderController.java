package com.kt.controller.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.common.ApiResult;

@RestController
@RequestMapping("/orders")
public class OrderController {

	//주문생성
	@PostMapping
	public ApiResult<Void> create(){
		return ApiResult.ok();
	}
}
