package com.laubang.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laubang.crawler.BaiduCrawler;
import com.laubang.test.TestJsoupBasic;

@RestController
public class WelcomeController {
	
	@Autowired
	TestJsoupBasic testJsoup;
	
	@Autowired
	BaiduCrawler baiduCrawler;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to my heroku-centre-base for Spring Boot!!!";
	}
	
	@GetMapping("/test/jsoup")
	public String testJsoup() throws IOException {
		return testJsoup.testJsoup();
	}
	
	@GetMapping("/test/selenium")
	public String testSelenium() throws IOException {
//		return testJsoup.testSelenium();
		return baiduCrawler.testSelenium();
	}
}
