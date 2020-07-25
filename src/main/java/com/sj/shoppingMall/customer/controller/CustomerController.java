package com.sj.shoppingMall.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.sj.shoppingMall.common.model.vo.Member;
import com.sj.shoppingMall.customer.model.service.CustomerService;
import com.sj.shoppingMall.customer.model.vo.BucketProduct;
import com.sj.shoppingMall.customer.model.vo.Customer;
import com.sj.shoppingMall.customer.model.vo.TempBucket;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cuService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// customer 회원가입
	@RequestMapping("joinCustomer.cu")
	public String joinCustomer(Model m, Member mem, Customer c, @RequestParam String email_id,
			@RequestParam String domein, HttpServletResponse response) throws IOException {
		String email = email_id + "@" + domein;
		mem.setPwd(encoder.encode(mem.getPwd()));

		// email 넣어주기
		mem.setEmail(email);

		// 회원 분류
		mem.setKind('C');
		int result = cuService.insertCustomer(mem, c);

		if (result > 1) {
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

	// 장바구니 추가
	@RequestMapping("bucketAdd.cu")
	@ResponseBody
	public String bucketAdd(TempBucket tb, HttpSession session) {
		Customer loginUser = (Customer) session.getAttribute("loginUser");
		ArrayList<BucketProduct> bpList = new ArrayList<BucketProduct>();
		Iterator<String> iteratorK = tb.getpBuyList().keySet().iterator();
		while (iteratorK.hasNext()) {
			BucketProduct bp = new BucketProduct();
			String size = iteratorK.next();
			int count = Integer.parseInt((String) tb.getpBuyList().get(size));
			int price = Integer.parseInt((String) tb.getpPriceList().get(size));
			bp.setCustomerNo(loginUser.getMember().getMemberNo());
			bp.setProductNo(tb.getProductNo());
			bp.setProductSize(size);
			bp.setProductCount(count);
			bp.setProductPrice(price);
			bpList.add(bp);
		}
		int result = cuService.addBucket(bpList);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	// 장바구니 삭제
	@RequestMapping("delectBasket.cu")
	public void delectBasket(@RequestParam Integer bucketNo, HttpSession session, HttpServletResponse response) {
		Customer loginUser = (Customer) session.getAttribute("loginUser");
		ArrayList<BucketProduct> bpList = cuService.delectBasket(bucketNo, loginUser.getMember().getMemberNo());
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			gson.toJson(bpList, response.getWriter());
		} catch (JsonIOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 장바구니 페이지
	@RequestMapping("customerBasket.cu")
	public String customerBasket(HttpSession session, Model m) {
		Customer loginUser = (Customer) session.getAttribute("loginUser");
		ArrayList<BucketProduct> bpList = cuService.getBucketList(loginUser.getMember().getMemberNo());
		m.addAttribute("bpList", bpList);
		return "customerBasket";
	}

	// 장바구니 제품 개수 증가
	@RequestMapping("pCountAdd.cu")
	public void pCountAdd(@RequestParam Integer bucketNo, @RequestParam Integer productNo,
			@RequestParam String productSize, @RequestParam Integer productPrice, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BucketProduct bp = new BucketProduct();
		int basketCount = cuService.basketCount(bucketNo);
		int stockCount = cuService.stockCount(productNo, productSize);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			if (stockCount == 0) {
				Map<String, String> m = new HashMap<String, String>();
				m.put("no", "no");
				gson.toJson(m, response.getWriter());
			} else if (basketCount == stockCount) {
				Map<String, String> m = new HashMap<String, String>();
				m.put("max", "max");
				gson.toJson(m, response.getWriter());
			} else if (stockCount < basketCount) {
				bp = cuService.getBucketProduct(bucketNo, stockCount, productPrice);
				bp.setProductCount(stockCount);
				ArrayList<BucketProduct> bpl = new ArrayList<BucketProduct>();
				bpl.add(bp);
				gson.toJson(bp, response.getWriter());
			} else {
				ArrayList<BucketProduct> bpl = new ArrayList<BucketProduct>();
				bpl.add(bp);
				bp = cuService.pCountAdd(bucketNo, productPrice);
				gson.toJson(bp, response.getWriter());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 장바구니 제품 개수 감소
	@RequestMapping("pCountSub.cu")
	public void pCountSub(@RequestParam Integer bucketNo, @RequestParam Integer productNo,
			@RequestParam String productSize, @RequestParam Integer productPrice, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BucketProduct bp = new BucketProduct();
		int basketCount = cuService.basketCount(bucketNo);
		int stockCount = cuService.stockCount(productNo, productSize);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			if (stockCount == 0) {
				Map<String, String> m = new HashMap<String, String>();
				m.put("no", "no");
				gson.toJson(m, response.getWriter());
			} else if (basketCount == 1) {
				Map<String, String> m = new HashMap<String, String>();
				m.put("min", "min");
				gson.toJson(m, response.getWriter());
			} else if (stockCount < basketCount) {
				bp = cuService.getBucketProduct(bucketNo, stockCount, productPrice);
				bp.setProductCount(stockCount);
				ArrayList<BucketProduct> bpl = new ArrayList<BucketProduct>();
				bpl.add(bp);
				gson.toJson(bp, response.getWriter());
			} else {
				ArrayList<BucketProduct> bpl = new ArrayList<BucketProduct>();
				bpl.add(bp);
				bp = cuService.pCountSub(bucketNo, productPrice);
				gson.toJson(bp, response.getWriter());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping("customerBuyItem.cu")
	public String customerBuyItem(@re) {
		
		return "customerBuyItem";
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
