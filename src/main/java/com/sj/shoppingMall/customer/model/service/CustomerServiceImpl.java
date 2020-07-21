package com.sj.shoppingMall.customer.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.dao.CustomerDAO;
import com.sj.shoppingMall.customer.model.vo.Customer;

@Service("cuService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO cuDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	// customer 회원가입
	@Override
	public int insertCustomer(Member mem, Customer c) {
		return cuDAO.insertCustomer(sqlSession, mem, c);
	}
}
