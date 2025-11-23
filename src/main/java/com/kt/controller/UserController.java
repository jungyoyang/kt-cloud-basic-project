package com.kt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kt.dto.UserCreateRequest;
import com.kt.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
	// usersrvice를 di받아야함
	// di받는 방식이 생성자 주입 씀 -> 재할당을 금지함

	private final UserService userService;

	// loginId, password, name, birthday
	// json형태의 body에 담겨서 post요청으로 /users로 들어오면
	// @RequestBody를보고 jacksonObjectMapper가 동작해서 json을 읽어서 dto로 변환
	public void create(@Valid @RequestBody UserCreateRequest request)
	{
		userService.create(request);
		}
}