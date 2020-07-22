package com.sj.shoppingMall.common.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.Customer;

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

	// customer 로그인
	public Customer customerSignIn(SqlSessionTemplate sqlSession, Member mem) {
		return sqlSession.selectOne("commonMapper.customerSignIn", mem);
	}

	public Business businessSignIn(SqlSessionTemplate sqlSession, Member mem) {
		return sqlSession.selectOne("commonMapper.businessSignIn", mem);
	}

}
