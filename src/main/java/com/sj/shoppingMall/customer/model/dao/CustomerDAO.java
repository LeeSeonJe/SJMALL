package com.sj.shoppingMall.customer.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.BucketProduct;
import com.sj.shoppingMall.customer.model.vo.Customer;

@Repository("cuDAO")
public class CustomerDAO {

	// customer 회원가입
	public int insertCustomer(SqlSessionTemplate sqlSession, Member mem, Customer c) {
		int result = sqlSession.insert("commonMapper.memberInsert", mem);
		if (result > 0) {
			result += sqlSession.insert("customerMapper.customerInsert", c);
		}
		return result;
	}

	// customer 장바구니 추가
	public int addBucket(SqlSessionTemplate sqlSession, ArrayList<BucketProduct> bpList) {
		int result = 0;
		int result2 = 0;
		for (BucketProduct bp : bpList) {
			// 사이즈별로 장바구니에 있는지 없는지 확인
			result = sqlSession.selectOne("customerMapper.checkBucket", bp);
			if (result == 1) {
				// 있으면 개수랑 가격을 더한다.
				result2 += sqlSession.update("customerMapper.updateBucket", bp);
			} else if (result == 0 && bp.getProductCount() != 0) {
				// 없으면 추가한다.
				result2 += sqlSession.insert("customerMapper.insertBucket", bp);
			}
		}
		return result2;
	}

	// customer 장바구니 가져오기
	public ArrayList<BucketProduct> getBucketList(SqlSessionTemplate sqlSession, int customerNo) {
		return (ArrayList) sqlSession.selectList("customerMapper.getBucketList", customerNo);
	}

	// customer 장바구니 삭제하기
	public ArrayList<BucketProduct> delectBasket(SqlSessionTemplate sqlSession, Integer bucketNo, int customerNo) {
		int result = sqlSession.delete("customerMapper.delectBasket", bucketNo);
		if (result > 0) {
			return (ArrayList) sqlSession.selectList("customerMapper.getBucketList", customerNo);
		}
		return null;
	}

	// 장바구니 제품 개수 증가
	public BucketProduct pCountAdd(SqlSessionTemplate sqlSession, Integer bucketNo, Integer productPrice) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("bucketNo", bucketNo);
		m.put("productPrice", productPrice);
		sqlSession.update("customerMapper.pCountAdd", m);
		return sqlSession.selectOne("customerMapper.getBasket", bucketNo);
	}

	// 장바구니 제품 개수 감소
	public BucketProduct pCountSub(SqlSessionTemplate sqlSession, Integer bucketNo, Integer productPrice) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("bucketNo", bucketNo);
		m.put("productPrice", productPrice);
		sqlSession.update("customerMapper.pCountSub", m);
		return sqlSession.selectOne("customerMapper.getBasket", bucketNo);
	}

	// 장바구니 제품 개수 확인
	public int basketCount(SqlSessionTemplate sqlSession, Integer bucketNo) {
		return sqlSession.selectOne("customerMapper.basketCount", bucketNo);
	}

	public int stockCount(SqlSessionTemplate sqlSession, Integer productNo, String productSize) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("productNo", productNo);
		m.put("productSize", productSize);
		Object result = sqlSession.selectOne("customerMapper.stockCount", m);
		if (result == null) {
			return 0;
		} else {
			return sqlSession.selectOne("customerMapper.stockCount", m);
		}
	}

	public BucketProduct getBucketProduct(SqlSessionTemplate sqlSession, Integer bucketNo, int stockCount, Integer productPrice) {
		Map<String, Object> m = new HashMap<String, Object>();
		productPrice = stockCount * productPrice;
		m.put("bucketNo", bucketNo);
		m.put("stockCount", stockCount);
		m.put("productPrice", productPrice);		
		sqlSession.update("customerMapper.countUpdate", m);
		return sqlSession.selectOne("customerMapper.getBasket", bucketNo);
	}
}
