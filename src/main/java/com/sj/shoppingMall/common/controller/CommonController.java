package com.sj.shoppingMall.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.Customer;

@Controller
@SessionAttributes("loginUser")
public class CommonController {
	@RequestMapping("main.co")
	public String main() {
		return "main";
	}

	@RequestMapping("signIn.co")
	public String signIn(@RequestParam String id, @RequestParam String pwd) {
		
		return "signIn";
	}

	@RequestMapping("signUp.co")
	public String signUp(@RequestParam(value = "success", required = false) String s, @RequestParam(value = "fail", required = false) String f, Model m) {
		if(s != null) {
			m.addAttribute("status", s);			
		} else {
			m.addAttribute("status", f);						
		}
		return "signUp";
	}
}
