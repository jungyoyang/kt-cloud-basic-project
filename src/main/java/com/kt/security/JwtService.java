package com.kt.security;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtService {
	// Key는 저희가 설정한 어떤 임의의 값을 통해서 Key를 생성함\
	public void issue(Long id){
		// id 값은 jwt의 식별자 같은 개념 -> User의 id값
		// claims -> jwt안에 들어갈 정보를 Map형태로 넣는데 id, 1
		Jwts.builder()
			.subject("kt-cloud-shopping")
			.issuer("roy")
			.issuedAt(new Date())
			.id(id.toString())
			.expiration(new Date())
			.signWith(Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes()))
			.compact();

		//액세스 토큰과 리프레스 토큰을 발급해서 보내줘야한다
		return jwtService.issue(user.getId());
	}
}
