package com.kt.domain.order;

import java.time.LocalDateTime;

import com.kt.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private Status status;
	private LocalDateTime deliveredAt;

}
