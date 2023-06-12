package com.example.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestMappingController {

	/*
	 * 로그 레벨 TRACE < DEBUG < INFO < WARN < ERROR
	 */

	private final Logger logger = LoggerFactory.getLogger(getClass());

	// GET 방식
	@RequestMapping(value = "/requestGet", method = RequestMethod.GET) // 주소창에 쓰이는 값
	public String requestGet() {
//		System.out.println("requestGet 메소드 실행");
		logger.info("requestGet 메소드 실행");
//		logger.debug("requestGet 메소드 실행");
//		logger.error("requestGet 메소드 실행");
		return "request/requestMapping"; // 자바 내에 hmtl 파일 위치를 리턴해주는 값
	}

	// GET 방식
	@GetMapping(value = "/requestGetMapping") // 주소창에 쓰이는 값, '밸류' 생략 가능
	public String requestGetMapping() {
		logger.info("requestGetMapping 메소드 실행");
		return "request/requestMapping"; // 자바 내에 hmtl 파일(사이트)위치를 리턴해주는 값
	}

	// POST 방식
	@PostMapping("requestPost")
	public String requestPost() {
		logger.info("requestPost 메소드 실행");
		return "request/requestMapping";
	}

	// POST 방식
	@PostMapping(value = "/requestPostMapping")
	public String requestPostMapping() {
		logger.info("requestPostMapping 메소드 실행");
		return "request/requestMapping";
	}

	// GET, POST 방식
	@RequestMapping(value = "/requestAll", method = { RequestMethod.GET, RequestMethod.POST })
	public String requestAll() {
		logger.info("requestAll 메소드 실행");
		return "request/requestMapping";
	}
	
	// PathVariable (경로 변수)
	@GetMapping(value = "/members/{path}")
	public String requestPathVariable (@PathVariable("path") String id) {	
		// 밸류와 이름이 같으면 그대로 읽어오면 되고, 이름이 서로 다르면 괄호로 적어준다.
		logger.info("id : {}", id);		// 이렇게하면 중괄호 부분에 아이디가 출력된다.
		return "request/requestMapping";
	}
	
	// consumes 지정
	@ResponseBody
	@RequestMapping(value = "requestJson", consumes = "application/json")
	public String requestJson() {
		logger.info("requestJson 메소드 실행");
		return "OK";
	}
	

}
