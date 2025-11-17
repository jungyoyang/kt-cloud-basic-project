package com.kt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public void login(String loginId, String password){
		var user = userRepository.findByLoginId(loginId)
			.orElseThrow(()-> new CustomException(ErrorCode.FAIL_LOGIN));
// Bcrypt로 암호화된 정보 -> 단방향 해시암호화 - > 기본 5번 해시알고리즘을 돌림
		//요청 들어온 password를 또 해시알고리즘돌려서 맞는지를 비교
		//비밀번호가 일치하는지 반드시
		Preconditions.validate(passwordEncoder.mathches(password, user.getPassword()), ErrorCode.FAIL_LOGIN);

		//로그인성공처리 - >JWT 토큰을 발급
		//
	}
}
