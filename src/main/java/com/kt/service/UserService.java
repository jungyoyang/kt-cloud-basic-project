package com.kt.service;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.kt.domain.User;
import com.kt.dto.UserCreateRequest;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserJDBCRepository userJDBCRepository;
	private final UserRepository userRepository;
	//dto를 받는다
	public void create(UserCreateRequest request){
		System.out.println(request.toString());

		// dto를 실제 도메인(entity)모델로 변환을 하는 과정을 거치고
		var newUser = new User(
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

		//repository로 넘길거임
		userJDBCRepository.save(newUser);
	}
	public boolean isDuplicateLoginId(String loginId) {
		return userJDBCRepository.existsByLoginId(loginId);
	}
}
