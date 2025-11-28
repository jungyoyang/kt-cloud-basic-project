package com.kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.domain.User;

// <T,ID>
// T: Entity 클래스 => User
// ID: Entity 클래스의 PK 타입 = Long
public interface UserRepository extends JpaRepository<User,Long> {
}
// 이러면 CRUD기능이 끝!