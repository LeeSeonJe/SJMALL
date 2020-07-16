package com.sj.shoppingMall.customer.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.Customer;

@Repository("cuDAO")
public class CustomerDAO {
	
	public int insertCustomer(SqlSessionTemplate sqlSession, Member mem, Customer c) {
		int result = sqlSession.insert("commonMapper.memberInsert", mem);
		if(result > 0) {
			result += sqlSession.insert("customerMapper.customerInsert", c);
		}
		return result;
	}
}
