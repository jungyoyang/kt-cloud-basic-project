package com.kt.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter; //service 나 controller에서는 엔티티의 값을 읽어야하기 때문에, getter가있으면 편하다.
import lombok.NoArgsConstructor; //jpa가 reflection이라느 기술을 쓸때 사용

@Getter
@NoArgsConstructor
@Entity //spring bean은 아님! 사용할때 new user로 제어해줘야함
public class User {
	//Persistent entity 'User' should have primary key
	@Id// jakarta로 써야한다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private Gender gender;
	private LocalDate birthday;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public User(String loginId, String password, String name, String email, String mobile, Gender gender,
		LocalDate birthday, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.birthday = birthday;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}

