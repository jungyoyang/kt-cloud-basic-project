package com.kt.common;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	NOT_FOUND_PRODUCT(HttpStatus.BAD_REQUEST, "상품을 찾을수 없습니다."),
	NOT_FOUND_USER(HttpStatus.BAD_REQUEST, "존재하지않는 회원입니다"),
	DOES_NOT_MATCH_OLD_PASSWORD(HttpStatus.BAD_REQUEST, "기존 비밀번호가 일치하지 않습니다"),
	CAN_NOT_ALLOWED_SAME_PASSWORD(HttpStatus.BAD_REQUEST, "존재하지 않는 회원입니다.");

	private final HttpStatus status;
	private final String message;
	}
