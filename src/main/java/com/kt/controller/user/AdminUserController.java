package com.kt.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.service.UserService;

import lombok.RequiredArgsConstructor;

// API 문서화는 크게 2가지의 방식이 존재
// 1. Swagger -> 장점 UI가 이쁘다, 어노테이션 기반이라서 작성이 쉽다.
//	단점: 프로덕션코드에 Swagger관련 어노테이션이 존재
//	코드가 더러워지고 길어지고 그래서 유지보수가 힘듬
// 2. RestDocs
// 1번이랑 정반대
// 장점 : 프로덕션 코드에 침범이 없다, 신뢰할 수 있음
// 단점 : UI가 안이쁘다. 그리고 문서작성하는데 테스트코드 기반이라 시간이 걸림.
@Tag(name="User") //스프링 Swagger(OpenAPI) 에서 사용하는 어노테이션
@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController extends SwaggerAssistance{
	private final UserService userService;
	// 유저 리스트 조회

	//?key=value&page=1&keyword=asdasd
}
