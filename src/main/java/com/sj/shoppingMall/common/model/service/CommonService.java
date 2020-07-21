package com.sj.shoppingMall.common.model.service;

public interface CommonService {

	// 아이디 유효성 검사
	int idCheck(String id);

	// 이메일 유효성 검사
	int emailCheck(String email);
	
}
