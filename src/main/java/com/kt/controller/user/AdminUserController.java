package com.kt.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kt.common.ApiResult;
import com.kt.common.Paging;
import com.kt.dto.user.UserResponse;
import com.kt.dto.user.UserUpdateRequest;
import com.kt.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {
	private final UserService userService;

	//TODO 여기 유저 리스트 조회가 이해가안감

	// 유저 리스트 조회
	// ?key=value&page=1&keyword=asdasd
	// 이름에
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ApiResult<Page<UserResponse.Search>> search(
		Paging paging,
		@RequestParam(required = false) String keyword
	) {
		var search = userService.search(paging.toPageable(), keyword)
			.map(user-> new UserResponse.Search(
				user.getId(),
				user.getName(),
				user.getCreatedAt()
				));
		return ApiResult.ok(search);
	}

	// 유저 상세 조회
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ApiResult<UserResponse.Detail> detail(@PathVariable Long id) {
		var user = userService.detail(id);

		return ApiResult.ok(new UserResponse.Detail(
			user.getId(),
			user.getName(),
			user.getEmail()
		));
	}

	// 유저 정보 수정
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ApiResult<Void> update(@PathVariable Long id, @RequestBody @Valid UserUpdateRequest request) {
		userService.update(id, request.name(), request.email(), request.mobile());

	return ApiResult.ok();
	}
	// 유저 삭제
	// DELETE FROM MEMBER WHERE id = ?
	// 유저 비밀번호 초기화
}
