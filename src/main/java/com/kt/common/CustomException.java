package com.kt.common;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	private HttpStatus status;
	private String message;
	// 에러의 코드들을 사용
	public CustomException(String message) {
		super(message);
	}

	public CustomException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.status = errorCode.getStatus();
		this.message = errorCode.getMessage();
	}
}
