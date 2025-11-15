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
public class UserController extends SwaggerAssistance {
	//생성자주입을 쓰고 재할당을 금지하자
	private final UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	// loginId, password, name, birthday
	// json형태의 body에 담겨서 post요청으로 /users로 들어오면
	// @RequestBody를 보고 jacksonObjectMapper가 동작해서 json을 읽어서 dto로 변환
public ApiResult<Void> create(@Valid @RequestBody UserRequest.Create request) {
		userService.create(request);
		return ApiResult.ok();
	}
	// /users/duplicate-login-id?loginId=ktuser
	// IllegalArgumentException 발생 시 400에러
	// GET에서 쓰는 queryString
	// @RequestParam의 속성은 기본이 required = true
	@GetMapping("duplicate-login-id")
	@ResponseStatus(HttpStatus.OK)
	public ApiResult<Boolean> isDuplicateLoginId(@RequestParam String loginId) {
		var result = userService.isDuplicateLoginId(loginId);

		return ApiResult.ok(result);
	}
	//uri는 식별이 가능해야한다.
	// 유저들x , 어떤 유저?
	// /users/update-password
	// body => json으로 넣어서 보내고

	// 1. 바디에 id값을 같이 받는다
	// 2. uri에 id값을 넣는다. /users/{id}/update-password
	// 3. 인증/인가 객체에서 id값을 꺼낸다. (V)
	@PutMapping("/{id}/update-password")
	@ResponseStatus(HttpStatus.OK)
	public ApiResult<Void> updatePassword(
		@PathVariable Long id,
		@RequestBody @Valid UserUpdatePasswordRequest request
	){
		userService.changePassword(id, request.oldPassword(),request.newPassword());
		return ApiResult.ok();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ApiResult<Void> delte(@PathVariable Long id){
		userService.delete(id);
		return ApiResult.ok();
	}
}
