package com.kt.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 에러를 공통된 응답으로 처리하는 방식
// Spring 에서는 RestcontrollerAdvice
@RestControllerAdvice
public class ApiAdvice {
	// 어떤 예외를 처리할 것인지 정의
	// MethodArgumentNotValidException 이 익셉션을 처리하도록
	// @ExceptionHandler(MethodArgumentNotValidException.class)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		//예외처리 로직 작성
		return ErrorResponse.error(HttpStatus.BAD_REQUEST,"에러임");
	}
}
