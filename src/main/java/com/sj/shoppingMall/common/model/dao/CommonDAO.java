package com.sj.shoppingMall.common.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("coDAO")
public class CommonDAO {
	
	// 아이디 유효성 검사
	public int idCheck(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.selectOne("commonMapper.idCheck", id);
	}

	// 이메일 유효성 검사
	public int emailCheck(SqlSessionTemplate sqlSession, String email) {
		return sqlSession.selectOne("commonMapper.emailCheck", email);
	}

}
