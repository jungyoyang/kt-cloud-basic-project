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

	public static ResponseEntity<ErrorData> error(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(ErrorData.of(status.series().name(),message));
	}

	@Getter
	@AllArgsConstructor
	//Api Result를 안쓰는 이유는 에러와 성공케이스를 분리하기위해
	public static class ErrorData {
		private String code;
		private String message;

		public static ErrorData of(String code, String message){
			return new ErrorData(code,message);
		}
	}
}