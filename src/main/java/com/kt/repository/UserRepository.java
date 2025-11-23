package com.kt.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kt.domain.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {
	private final JdbcTemplate jdbcTemplate;

	public void save(User user) {
		// 서비스에서 dto를 도메인으로 바꾼다음 전달
		var sql = "INSERT INTO USER (loginId, password, name, birthday) VALUES (?,?,?,?)"; //SQL문법

		jdbcTemplate.update(sql, user.getLoginId(), user.getPassword(), user.getName()
			, user.getBirthday());
	}

	// 회원가입 후 바로 “생성된 id를 클라이언트에게 알려줘야” 할 때
	// DB에서 auto increment를 쓰지 않은 경우
	// 다음 로직에서 가장 최근 사용자 id가 필요할 때
	public Long selectMaxId() {
		var sql = "SELECT MAX(id) FROM USER"; //SQL문법
		var maxId = jdbcTemplate.queryForObject(sql, Long.class);
		return maxId == null ? 0L : maxId;
	}
}

