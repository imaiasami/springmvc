package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springmvc.model.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("requestBody")
@Controller
public class RequestBodyController {
	
	@ResponseBody	// HTTP 응답을 뷰 템플릿이 아니라 메시지 바디에 직접 담아서 전달해준다.
	@GetMapping("handleModel")
	public void handleModel(@RequestBody Member member) {
		log.info("handleModel 실행");
		log.info("member: {}", member);
	}

}
