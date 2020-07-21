package com.sj.shoppingMall.business.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.common.model.vo.Member;

@Repository("buDAO")
public class BusinessDAO {

	public int insertBusiness(SqlSessionTemplate sqlSession, Member mem, Business b) {
		int result = sqlSession.insert("commonMapper.memberInsert", mem);
		if(result > 0) {
			result += sqlSession.insert("businessMapper.businessInsert", b);
		}
		return result;
	}

}
