package com.sj.shoppingMall.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BusinessController {

	@RequestMapping("joinBusiness.bu")
	public String joinBusiness() {
		return "redirect:main.co";
	}
}
