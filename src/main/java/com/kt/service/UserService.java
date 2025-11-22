package com.kt.service;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.kt.domain.User;
import com.kt.dto.UserCreateRequest;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	//dto를 받는다
	public void create(UserCreateRequest request){
		System.out.println(request.toString());

		//실제 도메인 모델로 변환을 하는 과정을 거치고
		var newUser = new User(
		request.loginId(),
		request.password(),
		request.name(),
		request.birthday()
		);

		//repository로 넘길거임
		userRepository.save(newUser);
	}

}
