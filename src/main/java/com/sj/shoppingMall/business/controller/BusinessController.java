package com.sj.shoppingMall.business.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sj.shoppingMall.business.model.service.BusinessService;
import com.sj.shoppingMall.business.model.vo.Business;
import com.sj.shoppingMall.business.model.vo.Product;
import com.sj.shoppingMall.common.model.vo.Member;

@Controller
public class BusinessController {

	@Autowired
	private BusinessService buService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// business 회원가입
	@RequestMapping("joinBusiness.bu")
	public String joinCustomer(Model m, Member mem, Business b, @RequestParam String email_id,
			@RequestParam String domein, HttpServletResponse response) throws IOException {
		String email = email_id + "@" + domein;
		mem.setPwd(encoder.encode(mem.getPwd()));
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
	
	// business 회원정보 페이지
	@RequestMapping("businessProfile.bu")
	public String businessMyPage() {
		return "businessProfile";
	}
	
	// business 제품관리 페이지
	@RequestMapping("businessProductList.bu")
	public String businessProductList(Model m, HttpSession session) {
		Business loginUser = (Business) session.getAttribute("loginUser"); 
		ArrayList<Product> pList = buService.myProductList(loginUser.getMember().getMemberNo());
		m.addAttribute("pList", pList);
		return "businessProductList";
	}
	
	// business 제품등록 페이지
	@RequestMapping("businessProductAdd.bu")
	public String businessProductAdd() {
		return "businessProductAdd";
	}
	
	// 제품등록 
	@RequestMapping("productInsert.bu")
	public String productInsert(Product p, @RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request, HttpSession session) {
		Business b = (Business) session.getAttribute("loginUser");
		if (uploadFile != null && !uploadFile.isEmpty()) {
			String productThumbNail = thumbNailSaveFile(uploadFile, request);
			if (productThumbNail != null) {
				p.setProductThumbNail(productThumbNail);
			}
		}
		p.setBusinessNo(b.getMember().getMemberNo());
		int result = buService.productInsert(p);
		if(result > 1) {
			return "redirect:businessProductList.bu";			
		} else {
			return "redirect:businessProductList.bu";						
		}
	}

	// 제품 대표이미지 이름변경을 위한 함수
	private String thumbNailSaveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\business\\images";

		File folder = new File(savePath);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);
		String renamePath = folder + "//" + renameFileName;

		try {
			file.transferTo(new File(renamePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return renameFileName;
	}
	
	// 제품 수정 페이지
	@RequestMapping("businessProductUpdate.bu")
	public String businessProductUpdate(@RequestParam Integer productNo, Model m) {
		Product p = buService.getProduct(productNo);
		
		// 제품 사이즈 가져오기
		ArrayList<Map<String, Integer>> pSizeList = buService.getProductSize(productNo);
		
		m.addAttribute("p", p).addAttribute("pSizeList", pSizeList);
		return "businessProductUpdate";
	}
	
	// 제품 수정하기
	@RequestMapping("productUpdate.bu")
	public String productUpdate(Product p, @RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
		if (uploadFile != null && !uploadFile.isEmpty()) {
			String productThumbNail = thumbNailSaveFile(uploadFile, request);
			if (productThumbNail != null) {
				p.setProductThumbNail(productThumbNail);
			}
		}
		int resut = buService.productUpdate(p);
		return "redirect:businessProductList.bu";
	}
}
