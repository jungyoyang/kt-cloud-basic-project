package com.kt.domain.order;

import com.kt.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="orders")
public class Order extends BaseEntity {
	private String receiverName;
	private String receiverAddress;
	private String receiverMobile;
	private Localdatetime deliveredAt;

}
