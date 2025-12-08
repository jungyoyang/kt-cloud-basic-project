package com.kt.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
	PENDING("결제대기"),
	COMPLETED("결제완료"),
	CANCELLED("주문취소"),
	SHIPPED("배송중"),
	DELIVERED("배송완료"),
	CONFIRMED("구매확정");

	private final String description;

	//연관관계
	//주문 <-> 회원
	// N : 1 => 다대일
	// FK => 다쪽, 많은쪽에 자동으로 생김

	// 하나의 주문은 여러명의 회원을 가질 수 있나? 아니요

}
