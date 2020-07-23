package com.sj.shoppingMall.business.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.shoppingMall.business.model.dao.BusinessDAO;
import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.business.model.vo.Product;
import com.sj.shoppingMall.common.model.vo.Member;

@Service("buService")
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessDAO buDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// business 회원가입
	@Override
	public int insertBusiness(Member mem, Business b) {
		return buDAO.insertBusiness(sqlSession, mem, b);
	}

	// 제품 등록
	@Override
	public int productInsert(Product p) {
		return buDAO.productInsert(sqlSession, p);
	}

	// 등록한 제품 불러오기
	@Override
	public ArrayList<Product> myProductList(int memberNo) {
		return buDAO.myProductList(sqlSession, memberNo);
	}

	// 제품 수정을 위한 하나의 제품 가져오기
	@Override
	public Product getProduct(Integer productNo) {
		return buDAO.getProduct(sqlSession, productNo);
	}

	// 제품 사이즈 가져오기
	@Override
	public ArrayList<Map<String, Integer>> getProductSize(Integer productNo) {
		return buDAO.getProductSize(sqlSession,productNo);
	}

	// 제품 수정하기
	@Override
	public int productUpdate(Product p) {
		return buDAO.productUpdate(sqlSession, p);
	}

}
