package com.sj.shoppingMall.common.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.shoppingMall.common.model.dao.CommonDAO;

@Service("coService")
public class CommonServiceImpl implements CommonService {

	// DAO 의존성 주입
	@Autowired
	private CommonDAO coDAO;
	
	// database 의존성 주입
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 아이디 유효성 검사
	@Override
	public int idCheck(String id) {
		return coDAO.idCheck(sqlSession, id);
	}

	// 이메일 유효성 검사
	@Override
	public int emailCheck(String email) {
		return coDAO.emailCheck(sqlSession, email);
	}
	
}
