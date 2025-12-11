package com.kt.domain.payment;

import java.time.LocalDateTime;

import com.kt.common.BaseEntity;
import com.kt.domain.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Payment extends BaseEntity {

	private Long totalprice;
	private Long delieveryfee;
	@Enumerated(EnumType.STRING)
	private PaymentType type;


	@OneToOne
	private Order order;
}