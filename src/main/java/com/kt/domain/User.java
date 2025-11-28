package com.kt.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter; //service 나 controller에서는 엔티티의 값을 읽어야하기 때문에, getter가있으면 편하다.
import lombok.NoArgsConstructor; //jpa가 reflection이라느 기술을 쓸때 사용

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	//Persistent entity 'User' should have primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private LocalDate birthday;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
