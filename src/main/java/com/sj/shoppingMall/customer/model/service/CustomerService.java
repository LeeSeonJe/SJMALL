package com.sj.shoppingMall.customer.model.service;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.Customer;

public interface CustomerService {

	int insertCustomer(Member mem, Customer c);
	
}
