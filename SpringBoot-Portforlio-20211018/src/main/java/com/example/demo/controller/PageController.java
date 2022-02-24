package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@RequestMapping("/classify")
	public String getClassifyPage() {
		return"classify.html";
	}
	
	@RequestMapping("/tstock")
	public String getTStockPage() {
		return"TStock.html";
	}
	
	@RequestMapping("/home")
	public String getHomePage() {
		return"home.html";
	}

}
