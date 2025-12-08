package com.kt.domain.order;

import java.time.LocalDateTime;

import com.kt.common.BaseEntity;
import com.kt.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="orders")
public class Order extends BaseEntity {
	private String receiverName;
	private String receiverAddress;
	private String receiverMobile;
	@Enumerated(EnumType.STRING) //숫자로 DB에저장하는게아닌 STRING으로 저장하기위함
	private OrderStatus status;
	private LocalDateTime deliveredAt;

	//연관관계
	//주문 <-> 회원
	// N : 1 => 다대일
	// ManyToOne
	// FK => 다쪽, 많은쪽에 자동으로 생김


	@ManyToOne
	private User user;
	// 하나의 주문은 여러명의 회원을 가질 수 있나? 아니요


}
