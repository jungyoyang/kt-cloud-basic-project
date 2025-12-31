package com.kt.service;


import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.common.ErrorCode;
import com.kt.common.Preconditions;
import com.kt.domain.user.User;
import com.kt.dto.user.UserCreateRequest;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// 구현체가 두개 이상 필요로해야 인터페이스가 의미가있지않나?
// 인터터페이스 :  구현체가 1:1인데 다나눠야하나?
// 관레를 지키려고 추상화를 굳이 하는것을 관습적추상화 라고한다.
// 인터페이스로 굳이 나눴을때 불편한점 : 유지보수성
// 우리는 관습적 추상화를 하지않기로하자

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
	//private final UserJDBCRepository userJDBCRepository;
	private final UserRepository userRepository;


	public void create(UserCreateRequest request) {
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
		userRepository.save(newUser);
	}

	public boolean isDuplicateLoginId(String loginId) {
		return userRepository.existsByLoginId(loginId);
	}

	public void changePassword(Long id, String oldPassword, String password) {
		var user = userRepository.findByIdOrThrow(id, ErrorCode.NOT_FOUND_USER);


		//검증 작업 (무엇이 해피한 상황일까?)
		// 긍정적인 상황만 생각하자 -> 패스워드가 이전것과 달라야 => 해피한
		// 패스워드가 같으면 안되는데 => 해피하지 않은 상황
		// 그래서 !를 씀
		Preconditions.validate(user.getPassword().equals(oldPassword),ErrorCode.DOES_NOT_MATCH_OLD_PASSWORD);
		Preconditions.validate(!oldPassword.equals(password),ErrorCode.CAN_NOT_ALLOWED_SAME_PASSWORD);
		user.changePassword(password);
	}

	// Pageable 인터페이스
	public Page<User> search(Pageable pageable, String keyword) {
		return userRepository.findAllByNameContaining(keyword, pageable);
	}

	public User detail(Long id) {
		return userRepository.findByIdOrThrow(id, ErrorCode.NOT_FOUND_USER);
	}

	public void update(Long id, String name, String email, String mobile) {
		var user = userRepository.findByIdOrThrow(id, ErrorCode.NOT_FOUND_USER);

		user.update(name, email, mobile);
	}

	public void delete(Long id){
		userRepository.deleteById(id);
	}
}