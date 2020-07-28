package com.sj.shoppingMall.customer.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.dao.CustomerDAO;
import com.sj.shoppingMall.customer.model.vo.BucketProduct;
import com.sj.shoppingMall.customer.model.vo.BuyProduct;
import com.sj.shoppingMall.customer.model.vo.Customer;

import oracle.net.aso.b;

@Service("cuService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO cuDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;

	// customer 회원가입
	@Override
	public int insertCustomer(Member mem, Customer c) {
		return cuDAO.insertCustomer(sqlSession, mem, c);
	}

	// customer 장바구니 추가
	@Override
	public int addBucket(ArrayList<BucketProduct> bpList) {
		return cuDAO.addBucket(sqlSession, bpList);
	}

	// customer 장바구니 가져오기
	@Override
	public ArrayList<BucketProduct> getBucketList(int customerNo) {
		return cuDAO.getBucketList(sqlSession, customerNo);
	}

	// customer 장바구니 삭제
	@Override
	public ArrayList<BucketProduct> delectBasket(Integer bucketNo, int customerNo) {
		return cuDAO.delectBasket(sqlSession, bucketNo, customerNo);
	}

	// 장바구니 제품 개수 증가
	@Override
	public BucketProduct pCountAdd(Integer bucketNo, Integer productPrice) {
		return cuDAO.pCountAdd(sqlSession, bucketNo, productPrice);
	}

	// 장바구니 제품 개수 감소
	@Override
	public BucketProduct pCountSub(Integer bucketNo, Integer productPrice) {
		return cuDAO.pCountSub(sqlSession, bucketNo, productPrice);
	}

	// 장바구니 제품 개수 확인
	@Override
	public int basketCount(Integer bucketNo) {
		return cuDAO.basketCount(sqlSession, bucketNo);
	}

	// 재고 수량 확인
	@Override
	public int stockCount(Integer productNo, String productSize) {
		return cuDAO.stockCount(sqlSession, productNo, productSize);
	}

	@Override
	public BucketProduct getBucketProduct(Integer bucketNo, int stockCount, Integer productPrice) {
		return cuDAO.getBucketProduct(sqlSession, bucketNo, stockCount, productPrice);
	}

	@Override
	public Map checkItem(BuyProduct[] bp) {
		return cuDAO.checkItem(sqlSession, bp);
	}

	
}
