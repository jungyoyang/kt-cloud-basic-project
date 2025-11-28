package com.kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.domain.User;

// <T,ID>
// T: Entity 클래스
// ID: Entity 클래스의 PK 타입
public interface UserRepository extends JpaRepository<User,Long> {
}
