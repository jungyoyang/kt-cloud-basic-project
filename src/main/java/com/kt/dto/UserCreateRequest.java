package com.kt.dto;
import java.time.LocalDate;

import com.kt.domain.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserCreateRequest(
	@NotBlank
	String loginId,
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^])[A-Za-z\\d!@#$%^]{8,}$")
	String password,
	@NotBlank
	String name,
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
	String email,
	@NotBlank
	@Pattern(regexp = "^(0\\d{1,2})-(\\d{3,4})-(\\d{4})$")
	String mobile,
	@NotNull
	Gender gender,
	@NotNull
	LocalDate birthday){

}

// DTO 유효성 검사는 왜 하는데?
// 	✔ 결론:
// “프론트 → 백엔드로 들어오는 요청 값이 이상하면 그대로 저장하면 안 되기 때문.”
// 즉, 비어 있는 값, 잘못된 형식의 값, 숫자여야 하는데 문자가 들어온 값
// 이메일 형식이 아닌 값, 너무 짧은/긴 값
// 이런 것들을 서버에서 걸러내기 위해 하는 게 DTO 유효성 검사야.