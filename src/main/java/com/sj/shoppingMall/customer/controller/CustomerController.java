package com.sj.shoppingMall.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.service.CustomerService;
import com.sj.shoppingMall.customer.model.vo.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cuService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// customer 회원가입
	@RequestMapping("joinCustomer.cu")
	public String joinCustomer(Model m, Member mem, Customer c, @RequestParam String email_id, @RequestParam String domein, HttpServletResponse response) throws IOException {
		String email = email_id + "@" + domein;
		mem.setPwd(encoder.encode(mem.getPwd()));
		
		// email 넣어주기
		mem.setEmail(email);
		
		// 회원 분류
		mem.setKind('C');		
		int result = cuService.insertCustomer(mem, c);
		
		if(result > 1) {
			return "redirect:signUp.co?success=success";			
		} else {
			return "redirect:signUp.co?fail=fail";			
		}
	}	
	
	// 회원정보 페이지
	@RequestMapping("customerProfile.cu")
	public String customerProfile() {
		return "customerProfile";
	}
	
	// 장바구니 페이지
	@RequestMapping("customerBasket.cu")
	public String customerBasket() {
		return "customerBasket";
	}
	
	// 주문/배송 페이지
	@RequestMapping("customerDelivery.cu")
	public String customerDelivery() {
		return "customerDelivery";
	}
	
	// 내가 쓴 리뷰 페이지
	@RequestMapping("customerReview.cu")
	public String customerReview() {
		return "customerReview";
	}
	
	// 판매자 문의 페이지
	@RequestMapping("customerSellerQnA.cu")
	public String customerSellerQnA() {
		return "customerSellerQnA";
	}
	
	// 관리자 문의 페이지
	@RequestMapping("customerAdminQnA.cu")
	public String customerAdminQnA() {
		return "customerAdminQnA";
	}
}
