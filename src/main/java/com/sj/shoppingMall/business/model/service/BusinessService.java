package com.sj.shoppingMall.business.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.business.model.vo.Product;
import com.sj.shoppingMall.common.model.vo.Member;

public interface BusinessService {
	
	// business 회원가입
	int insertBusiness(Member mem, Business b);

	// 제품 등록
	int productInsert(Product p);

	// 등록한 제품 불러오기
	ArrayList<Product> myProductList(int memberNo);

	// 제품 수정을 위한 하나의 제품 가져오기
	Product getProduct(Integer productNo);

	// 제품 사이즈 가져오기
	ArrayList<Map<String, Integer>> getProductSize(Integer productNo);

	// 제품 수정하기
	int productUpdate(Product p);


}
