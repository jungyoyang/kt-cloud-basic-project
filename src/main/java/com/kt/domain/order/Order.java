package com.kt.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kt.common.BaseEntity;
import com.kt.domain.orderproduct.OrderProduct;
import com.kt.domain.product.Product;
import com.kt.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="orders")
public class Order extends BaseEntity {
	private String receiverName;
	private String receiverAddress;
	private String receiverMobile;
	//숫자로 DB에저장하는게아닌 STRING으로 저장하기위함
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private LocalDateTime deliveredAt;

	// 연관관계 (주문 <-> 회원)
	// 하나의 주문은 여러명의 회원을 가질 수 있나? 아니요
	// 그 반대는? 네
	// N : 1 => 다대일
	// JPA한테 ManyToOne으로 지정해줘 알려주자

	// 관계를 이을때 어디에 연결을해야할까? FK로 연결을 하게되는데
	// FK는 다대일에서 많은쪽에 생김
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany
	private List<OrderProduct> products = new ArrayList<>();
	//하나의 order는 여러개의 상품을 가질 수 있음
	//1:N
	//하나의 상품은 여러개의 order를 가질 수 있음
	//1:N


	// 주문 생성
	// 주문 상태 변경
	// 주문 생성 완료 재고 차감
	// 배송받는 사람 정보 변경
	// 주문 취소
	// 만들어보기
}
