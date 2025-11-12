package com.kt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	// 트랜잭션 처리
	// PSA (Portable Service Abstraction)
	// 환경설정을 살짝 바꿔서 일관된 서비스를 제공하는 것
public void create(UserRequest.Create request){
	var newUser = User.normalUser(
		request.loginId(),
		request.password(),
		request.name(),
		request.email(),
		request.mobile(),
		request.gender(),
		request.birthday(),
		LocalDateTime.now(),
		LocalDateTime.now()
	);
}
}
