package com.sj.shoppingMall.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

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

import com.sj.shoppingMall.business.model.service.BusinessService;
import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.business.model.vo.Product;
import com.sj.shoppingMall.common.model.service.CommonService;
import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.vo.Customer;

@Controller
@SessionAttributes("loginUser")
public class CommonController {

	@Autowired
	private CommonService coService;
	
	@Autowired
	private BusinessService buService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// 시작시 메인페이지 이동
	@RequestMapping("main.co")
	public String main(Model m, HttpSession session) {
		int number = 0;
		String Top = "Top";
		String Pants = "Pants";
		String Skirt = "Skirt";
		String OnePiece = "OnePiece";
		String Shoes = "Shoes";
		ArrayList<Product> pTopList = coService.getPList(Top, number);
		ArrayList<Product> pPantsList = coService.getPList(Pants, number);
		ArrayList<Product> pSkirtList = coService.getPList(Skirt, number);
		ArrayList<Product> pOnePieceList = coService.getPList(OnePiece, number);
		ArrayList<Product> pShoesList = coService.getPList(Shoes, number);
		m.addAttribute("pTopList", pTopList)
		.addAttribute("pPantsList", pPantsList)
		.addAttribute("pSkirtList", pSkirtList)
		.addAttribute("pOnePieceList", pOnePieceList)
		.addAttribute("pShoesList", pShoesList);
		session.setAttribute("bpList", null);
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
	
	// topPage이동
	@RequestMapping("topPage.co")
	public String topPage(Model m) {
		int number = 1;
		String Top = "Top";
		ArrayList<Product> pTopList = coService.getPList(Top, number);
		m.addAttribute("pTopList", pTopList);
		return "topPage";
	}


	// pantsPage이동
	@RequestMapping("pantsPage.co")
	public String pantsPage(Model m) {
		int number = 1;
		String Pants = "Pants";
		ArrayList<Product> pPantsList = coService.getPList(Pants, number);
		m.addAttribute("pPantsList", pPantsList);	
		return "pantsPage";
	}
	
	// skirtPage이동
	@RequestMapping("skirtPage.co")
	public String skirtPage(Model m) {
		int number = 1;
		String Skirt = "Skirt";
		ArrayList<Product> pSkirtList = coService.getPList(Skirt, number);
		m.addAttribute("pSkirtList", pSkirtList);
		return "skirtPage";
	}
	
	// onePiecePage이동
	@RequestMapping("onePiecePage.co")
	public String onePiecePage(Model m) {
		int number = 1;
		String OnePiece = "OnePiece";
		ArrayList<Product> pOnePieceList = coService.getPList(OnePiece, number);
		m.addAttribute("pOnePieceList", pOnePieceList);
		return "onePiecePage";
	}
	
	// shoesPage이동
	@RequestMapping("shoesPage.co")
	public String shoesPage(Model m) {
		int number = 1;	
		String Shoes = "Shoes";
		ArrayList<Product> pShoesList = coService.getPList(Shoes, number);
		m.addAttribute("pShoesList", pShoesList);
		return "shoesPage";
	}
	
	// 제품 상세보기 페이지 이동
	@RequestMapping("pDetailPage.co")
	public String pDetailPage(@RequestParam Integer productNo, Model m) {
		Product p = buService.getProduct(productNo);
		ArrayList<Map<String, Integer>> pSizeList = buService.getProductSize(productNo);
		m.addAttribute("p", p).addAttribute("pSizeList", pSizeList);
		return "pDetailPage";
	}
	

}
