package com.sj.shoppingMall.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sj.shoppingMall.common.model.service.CommonService;

@Controller
@SessionAttributes("loginUser")
public class CommonController {
	
	@Autowired
	private CommonService coService;
	
	// 시작시 메인페이지 이동
	@RequestMapping("main.co")
	public String main() {
		return "main";
	}

	// 로그인 페이지 이동
	@RequestMapping("signIn.co")
	public String signIn() {
		return "signIn";
	}
	
	// 회원가입 들어왔을때, 회원가입 완료 후
	@RequestMapping("signUp.co")
	public String signUp(@RequestParam(value = "success", required = false) String s, @RequestParam(value = "fail", required = false) String f, Model m) {
		if(s != null) {
			m.addAttribute("status", s);			
		} else {
			m.addAttribute("status", f);						
		}
		return "signUp";
	}
	
	// 아이디 유효성 검사
	@RequestMapping("idCheck.co")
	@ResponseBody
	public String idCheck(@RequestParam String id) {
		int result = coService.idCheck(id);
		String check = "";
		if(result > 0) {
			check = "exist";
		} else {
			check = "none";
		}
		return check;
	}
	
	// 이메일 유효성 검사
	@RequestMapping("emailCheck.co")
	@ResponseBody
	public String emailCheck(@RequestParam String email) {
		int result = coService.emailCheck(email);
		String check = "";
		if(result > 0) {
			check = "exist";
		} else {
			check = "none";
		}
		return check;
	}
	
	// customer 로그인
	@RequestMapping("customerSignIn.co")
	public String customerSignIn() {
		
		return "";
	}
	
	// business 로그인
	@RequestMapping("businessSignIn.co")
	public String businessSignIn() {
		
		return "";
	}
}
