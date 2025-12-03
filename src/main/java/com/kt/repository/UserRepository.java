package com.kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.domain.User;
import com.kt.dto.CustomPage;

// <T,ID>
// T: Entity 클래스 => User
// ID: Entity 클래스의 PK 타입 = Long
public interface UserRepository extends JpaRepository<User, Long> {

	// 이러면 CRUD기능이 끝!

	//근데 쿼리를 또 작성해줘야
	//JPA에서는 쿼리를 작성하는 3가지 방법이 존재
	//1. 네이티브 쿼리 작성 (3순위)
	//2. JPQL작성 -> 네이티브 쿼리랑 같은데 Entity 기반(2순위) - 너무 길어진 메서드이름을 그냥 쿼리작성해서 숨김
	//3. querymethod 작성 -> 메서드 이름을 쿼리 처럼 작성 (1순위) - 길어지면 상당히 이상해보임
	// 찾는다 : findByXX, 존재하냐? existsByXX, 삭제 : deleteByXX

	Boolean existsByLoginId(String loginId);

	public CustomPage selectAll(int page, int size) {
		// paging의 구조
		// 백엔드 입장에서 필요한 것
		// 한화면에 몇개 보여줄것인가? => limit
		// 내가 몇번째 페이지를 보고있나? => offset (몇개를 건너뛸것인가?)
		// 보고있는 페이지 - 1 * limit
		var sql = "SELECT * FROM MEMBER LIMIT ? OFFSET ?";

		var users = jdbcTemplate.query(sql, rowMapper(), page, size);

		var countSql = "SELECT COUNT(*) FROM MEMBER";
		var totalElements = jdbcTemplate.queryForObject(countSql, Long.class);

	return Pair
	}

}