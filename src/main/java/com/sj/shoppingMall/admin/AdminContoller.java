package com.sj.shoppingMall.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminContoller {
	
	@RequestMapping("adminPage.ad")
	public String adminPage() {
		return "adminPage";
	}
}
