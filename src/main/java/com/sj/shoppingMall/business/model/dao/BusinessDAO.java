package com.sj.shoppingMall.business.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.business.model.vo.Product;
import com.sj.shoppingMall.business.model.vo.ProductSize;
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

	// 제품등록
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

	// 등록한 제품 불러오기
	public ArrayList<Product> myProductList(SqlSessionTemplate sqlSession, int memberNo) {
		return (ArrayList) sqlSession.selectList("businessMapper.myProductList", memberNo);
	}

	// 제품 수정을 위한 하나의 제품 가져오기
	public Product getProduct(SqlSessionTemplate sqlSession, Integer productNo) {
		return sqlSession.selectOne("businessMapper.getProduct", productNo);
	}

	// 제품 사이즈 가져오기
	public ArrayList<Map<String, Integer>> getProductSize(SqlSessionTemplate sqlSession, Integer productNo) {
		return (ArrayList) sqlSession.selectList("businessMapper.getProductSize", productNo);
	}
	
	// 제품 수정하기
	public int productUpdate(SqlSessionTemplate sqlSession, Product p) {
		int result =  sqlSession.update("businessMapper.productUpdate", p);
		if(result > 0) {
			result += sqlSession.delete("businessMapper.productSizeDelete", p);
			if(result > 1) {
				for(int i = 0; i < p.getProductSize().size(); i++) {
					ProductSize ps = new ProductSize();
					ps.setProductNo(p.getProductNo());
					ps.setProductSize(p.getProductSize().get(i));
					ps.setProductCount(p.getProductCount().get(i));
					result += sqlSession.insert("businessMapper.productSizeUpdate", ps);
				}
			}
		}
		return result;
	}

}
