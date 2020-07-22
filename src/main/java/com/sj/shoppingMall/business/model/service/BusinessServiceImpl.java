package com.sj.shoppingMall.business.model.service;

import org.apache.ibatis.session.SqlSession;
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

}
