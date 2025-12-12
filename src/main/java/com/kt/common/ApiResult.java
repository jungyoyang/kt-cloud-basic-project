package com.kt.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//API 응답을 표준화하기 위한 클래스
// Spring에서는 Http응답을 처리해주는 객체가 존재함
// ResponseEntity
public class ApiResult {
	public static ResponseEntity<String> ok(){
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}
}
