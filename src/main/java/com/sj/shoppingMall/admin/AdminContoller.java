package com.sj.shoppingMall.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminContoller {
	@RequestMapping("admin.ad")
	public String test() {
		return "admin";
	}
}
