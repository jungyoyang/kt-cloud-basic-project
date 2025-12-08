package com.kt.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
	ORDERED("주문됨"),
	DELIVERED("배송됨"),
	PAID("결제됨");

	private final	String description;
}
