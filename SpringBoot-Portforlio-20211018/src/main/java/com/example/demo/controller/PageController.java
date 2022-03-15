package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@RequestMapping("/watchlist")
	public String getWatchListPage() {
		return"watchlist.html";
	}
	
	@RequestMapping("/watch")
	public String getWatchPage() {
		return"watch.html";
	}
	
	@RequestMapping("/investor")
	public String getInvestorPage() {
		return"investor.html";
	}
	
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
