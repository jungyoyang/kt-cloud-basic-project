package com.kt.domain.product;


import com.kt.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Entity
@Getter
public class Product extends BaseEntity {

	private String name;
	private int price;
	private int stock;
	@Enumerated(EnumType.STRING)
	private ProductStatus status;

	//생성
	//수정
// 	삭제
// 	조회(리스트,단건)
// 상태변경
// 	재고수량감소
// 	재고수량증가

}
