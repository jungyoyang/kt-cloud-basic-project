package com.kt.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private HttpStatus status;
	private String message;

	public static ResponseEntity<String> error(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(message);
	}
}