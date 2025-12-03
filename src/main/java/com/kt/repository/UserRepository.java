package com.kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.domain.User;

// <T,ID>
// T: Entity 클래스 => User
// ID: Entity 클래스의 PK 타입 = Long
public interface UserRepository extends JpaRepository<User,Long> {

// 이러면 CRUD기능이 끝!

//근데 쿼리를 또 작성해줘야
//JPA에서는 쿼리를 작성하는 3가지 방법이 존재
//1. 네이티브 쿼리 작성 (3순위)
//2. JPQL작성 -> 네이티브 쿼리랑 같은데 Entity 기반(2순위) - 너무 길어진 메서드이름을 그냥 쿼리작성해서 숨김
//3. querymethod 작성 -> 메서드 이름을 쿼리 처럼 작성 (1순위) - 길어지면 상당히 이상해보임
// 찾는다 : findByXX, 존재하냐? existsByXX, 삭제 : deleteByXX

Boolean existsByLoginId(String loginId);

}