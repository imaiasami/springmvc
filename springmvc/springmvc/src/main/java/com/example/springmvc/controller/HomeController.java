package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")		// value 가 루트 ("/"), (path = "/") 같은 말이다.
	public String main() {
		return "index";
	}
	
	// HTML 로 받을 떄는 void, String 으로 받아야 한다.
	@RequestMapping(value = "/requestMapping")		// url 요청
	public String requestMapping () {
		return "request/requestMapping";		// return " 경로 명 / html 명
	}
	
	@GetMapping(value = "/requestParam")
	public String requestParam() {
		return "request/requestParam";
	}
	
	@GetMapping(value = "/modelAttribute")
	public String modelAttribute() {
		return "request/modelAttribute";
	}
	
}
