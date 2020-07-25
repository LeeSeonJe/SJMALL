package com.sj.shoppingMall.customer.model.service;

import java.util.ArrayList;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.BucketProduct;
import com.sj.shoppingMall.customer.model.vo.Customer;

public interface CustomerService {

	// customer 회원가입
	int insertCustomer(Member mem, Customer c);

	// customer 장바구니 추가
	int addBucket(ArrayList<BucketProduct> bpList);

	// customer 장바구니 가져오기
	ArrayList<BucketProduct> getBucketList(int customerNo);

	// customer 장바구니 삭제하기
	ArrayList<BucketProduct> delectBasket(Integer bucketNo, int customerNo);

	// 장바구니 제품 개수 확인
	int basketCount(Integer bucketNo);

	// 장바구니 제품 개수 증가
	BucketProduct pCountAdd(Integer bucketNo, Integer productPrice);

	// 장바구니 제품 개수 감소
	BucketProduct pCountSub(Integer bucketNo, Integer productPrice);

	// 재고 수량 확인
	int stockCount(Integer productNo, String productSize);

	// 장바구니 제품 가져오기
	BucketProduct getBucketProduct(Integer bucketNo, int stockCount, Integer productPrice);

	

}
