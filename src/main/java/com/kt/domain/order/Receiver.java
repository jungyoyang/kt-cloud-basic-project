package com.kt.domain.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Receiver {
	// receiver_name,
	// 원래 jpa가 알아서 recieverName(카멜)을 스네이크로 변환해주지만
	// 여기서는 이렇게 해줘야한다
	@Column(name = "receiver_name")
	private String name;
	// receiver_address
	@Column(name = "receiver_address")
	private String address;
	//receiver_mobile
	@Column(name = "receiver_mobile")
	private String mobile;
}
