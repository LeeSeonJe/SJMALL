package com.sj.shoppingMall.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@RequestMapping("joinCustomer.cu")
	public String joinCustomer(Model m, Member mem, Customer c, @RequestParam String email_id, @RequestParam String domein, HttpServletResponse response) throws IOException {
		String email = email_id + "@" + domein;
		
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
}
