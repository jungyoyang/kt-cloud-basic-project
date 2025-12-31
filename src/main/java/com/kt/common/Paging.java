package com.kt.common;

import org.springframework.data.domain.PageRequest;

public record Paging(
	int page,
	int size
	//todo : 정령 기능도 추가
) {
	public PageRequest toPageable() {
		return PageRequest.of(page - 1, size);
	}
}
