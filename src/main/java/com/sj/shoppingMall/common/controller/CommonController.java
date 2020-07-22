package com.sj.shoppingMall.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.common.model.service.CommonService;
import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.Customer;

@Controller
@SessionAttributes("loginUser")
public class CommonController {

	@Autowired
	private CommonService coService;

	@Autowired
	private BCryptPasswordEncoder encoder;

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
	public String signUp(@RequestParam(value = "success", required = false) String s,
			@RequestParam(value = "fail", required = false) String f, Model m) {
		if (s != null) {
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
		if (result > 0) {
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
		if (result > 0) {
			check = "exist";
		} else {
			check = "none";
		}
		return check;
	}

	// customer 로그인
	@RequestMapping("customerSignIn.co")
	public void customerSignIn(Member mem, Model m, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Customer loginUser = coService.customerSignIn(mem);
		PrintWriter out = response.getWriter();
		if (loginUser != null && encoder.matches(mem.getPwd(), loginUser.getMember().getPwd()) && loginUser.getMember().getKind() == 'C') {
			m.addAttribute("loginUser", loginUser);
			out.write("<script>location.href='main.co'</script>");
		} else {
			out.write("<script>alert('로그인에 실패하였습니다.'); location.href='signIn.co'</script>");
		}
		out.flush();
		out.close();
	}

	// business 로그인
	@RequestMapping("businessSignIn.co")
	public void businessSignIn(Member mem, Model m, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Business loginUser = coService.businessSignIn(mem);
		PrintWriter out = response.getWriter();
		if (loginUser != null && encoder.matches(mem.getPwd(), loginUser.getMember().getPwd()) && loginUser.getMember().getKind() == 'B') {
			m.addAttribute("loginUser", loginUser);
			out.write("<script>location.href='main.co'</script>");
		} else if (loginUser != null && encoder.matches(mem.getPwd(), loginUser.getMember().getPwd()) && loginUser.getMember().getKind() == 'I') {
			out.write("<script>alert('가입인증 대기중입니다.'); location.href='signIn.co'</script>");
		} else {
			out.write("<script>alert('로그인에 실패하였습니다.'); location.href='signIn.co'</script>");
		}
		out.flush();
		out.close();
	}
	
	// 로그아웃
	@RequestMapping("logout.co")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:main.co";
	}
}
