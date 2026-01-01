package com.kt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.domain.order.Order;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
	private final UserRepository userRepository;
	//주문생성
	public void create(Long userId){

		new Order();
	}
}
