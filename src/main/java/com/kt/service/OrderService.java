package com.kt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.common.ErrorCode;
import com.kt.domain.order.Order;
import com.kt.domain.order.Receiver;
import com.kt.repository.ProductRepository;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
	private final UserRepository userRepository;
	private final ProductRepository productRepository;

	//주문생성
	public void create(
		Long userId,
		String receiverName,
		String receiverAddress,
		String receiverMobile
	) {
		var user = userRepository.findByIdOrThrow(userId, ErrorCode.NOT_FOUND_USER);
		var receiver = new Receiver(
			receiverName,
			receiverAddress,
			receiverMobile
		);
		new Order();
	}
}
