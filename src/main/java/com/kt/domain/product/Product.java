package com.kt.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.kt.common.BaseEntity;
import com.kt.domain.order.Order;
import com.kt.domain.orderproduct.OrderProduct;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Product extends BaseEntity {
	private String name;
	private Long price;
	private Long stock;
	@Enumerated(EnumType.STRING)
	private ProductStatus status = ProductStatus.ACTIVATED;

	@OneToMany(mappedBy = "product")
	private List<OrderProduct> orderProducts = new ArrayList<>();

	// 생성
	// 수정
	// 삭제
	// 조회(리스트,단건)
	// 상태변경
	// 재고수량감소
	// 재고수량증가

	// 생성
	public Product(String name, Long price, Long stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	// 수정 - 정보수정, 상태수정

	//정보수정
	public void update(String name, Long price, Long stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
//상태수정
	public void soldOut() {
		this.status = ProductStatus.SOLD_OUT;
	}

	public void inActivate() {
		this.status = ProductStatus.IN_ACTIVATED;
	}

	public void activate() {
		this.status = ProductStatus.ACTIVATED;
	}

	// 삭제(상태수정, 소프트딜리트)
	public void delete(){
		this.status = ProductStatus.DELETED;
	}
	// 조회(리스트,단건)

	// 재고수량감소
	public void decreaseStock(Long quantity){
		this.stock -=quantity;
	}

	// 재고수량증가
	public void increaseStock(Long quantity){
		this.stock +=quantity;
	}
}
