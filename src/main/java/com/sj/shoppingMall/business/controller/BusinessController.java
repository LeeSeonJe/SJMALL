package com.sj.shoppingMall.business.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sj.shoppingMall.business.model.service.BusinessService;
import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.common.model.vo.Member;

@Controller
public class BusinessController {

	@Autowired
	private BusinessService buService;

	// business 회원가입
	@RequestMapping("joinBusiness.bu")
	public String joinCustomer(Model m, Member mem, Business b, @RequestParam String email_id,
			@RequestParam String domein, HttpServletResponse response) throws IOException {
		String email = email_id + "@" + domein;

		// email 넣어주기
		mem.setEmail(email);

		// 회원 분류
		mem.setKind('I');
		int result = buService.insertBusiness(mem, b);

		if (result > 1) {
			return "redirect:signUp.co?success=success";
		} else {
			return "redirect:signUp.co?fail=fail";
		}
	}
}
