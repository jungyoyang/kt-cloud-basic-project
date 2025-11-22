package com.kt.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;                 // DB에서 생성되는 PK
	private String loginId;          // 로그인 아이디
	private String password;         // 암호화된 비밀번호
	private String name;             // 유저 이름
	private String email;            // 이메일
	private String mobile;           // 전화번호
	private Gender gender;           // 성별 (Enum)
	private LocalDate birthday;      // 생일
	private LocalDateTime createdAt; // 생성일
	private LocalDateTime updatedAt; // 수정일
}
