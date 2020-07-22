package com.sj.shoppingMall.common.model.service;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.Customer;

public interface CommonService {

	// 아이디 유효성 검사
	int idCheck(String id);

	// 이메일 유효성 검사
	int emailCheck(String email);

	// customer 로그인
	Customer customerSignIn(Member mem);

	// business 로그인
	Business businessSignIn(Member mem);
	
}
