package com.sj.shoppingMall.business.model.service;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.business.model.vo.Product;
import com.sj.shoppingMall.common.model.vo.Member;

public interface BusinessService {
	
	// business 회원가입
	int insertBusiness(Member mem, Business b);

	// 제품 등록
	int productInsert(Product p);

}
