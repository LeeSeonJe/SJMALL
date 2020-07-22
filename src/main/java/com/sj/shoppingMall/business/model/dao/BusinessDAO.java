package com.sj.shoppingMall.business.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.business.model.vo.Product;
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

	public int productInsert(SqlSessionTemplate sqlSession, Product p) {
		int result = sqlSession.insert("businessMapper.productInsert", p);
		if(result > 0) {
			Map m = new HashMap();
			for(int i = 0; i < p.getProductSize().size(); i++) {
				m.put(p.getProductSize().get(i), p.getProductCount().get(i));
			}
			result += sqlSession.insert("businessMapper.productSizeInsert", m);
		}
		return result;
	}

}
