package com.kt.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.domain.User;
import com.kt.dto.CustomPage;
import com.kt.dto.UserCreateRequest;
import com.kt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
	private final UserRepository userRepository;

	// 트랜잭션 처리해줘
	// PSA - Portable Service Abstraction
	// 환결설정을 살짝 바꿔서 일관된 서비스를 제공하는 것

	public void create(UserCreateRequest request) {
		System.out.println(request.toString());

		// dto => entity , dto를 실제 도메인(entity)모델로 변환을 하는 과정을 거치고
		var newUser = new User(
			request.loginId(),
		/*
		record가 자동으로 getter 메서드를 만들어준다.
		String loginId; 가 있으면 record는 자동으로 아래 메서드를 생성한다:

		public String loginId() {
				return this.loginId;
		}
		*/
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
		userRepository.save(newUser);
	}

	public boolean isDuplicateLoginId(String loginId) {
		return userRepository.existsByLoginId(loginId);
	}

	public void changePassword(Long id, String oldPassword, String password) {
		var user = userRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

		if (!user.getPassword().equals(oldPassword)) {
			throw new IllegalArgumentException("기존 비밀번호가 일치하지 않습니다.");
		}

		if (oldPassword.equals(password)) {
			throw new IllegalArgumentException("기존 비밀번호와 동일한 비밀번호로 변경할 수 없습니다")
		}

		user.changePassword(password);
	}

	public void serach(int page, int size) {

		var paging = userRepository.selectAll
		var pages = (int)Math.ceil((double)totalElements / size);

		return new CustomPage(
			users,
			size,
			page,
			pages,
			totalElements
		);
	}
}
