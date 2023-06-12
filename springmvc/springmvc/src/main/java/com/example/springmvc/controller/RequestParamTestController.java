package com.example.springmvc.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamTestController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
//	@GetMapping(value = "/request/paramtest")
//	public String paramTest(HttpServletRequest request) {
////		logger.info("id : {} ", request.getParameter("id"));
////		logger.info("name  : {}", request.getParameter("name"));
////		logger.info("age  : {}", request.getParameter("age"));
//		return "request/requestParam";
//		// 리턴값 html 파일 경로 맨 앞에는 / 를 붙이면 안된다.
//	}
	
	
	// 요청 파라미터 받기
	// 요청 파라미터의 이름과 @RequestParam 의 변수명은 같아야 한다.
	// @RequestParam 에 지정된 값은 반드시 요청 정보에 포함되어야 한다.
	@GetMapping(value = "/request/paramTest")
	public String paramTest(@RequestParam("id") String userId, @RequestParam String name) {
		logger.info("id : {}", userId);
		logger.info("name : {}", name);
		return "request/requestParam";
	}
	
	
	// 요청 파라미터 받기
	// 요청 파라미터가 없을 경우 @RequestParam 의 required 속성 값을
	//	false로 설정하여 필수 항목에서 제외할 수 있다.
	@GetMapping(value = "request/paramTestNull")
	public String paramTestNull (@RequestParam(required = false) String id,
									@RequestParam Optional<String> name) {
		logger.info("id : {}", id);
//		logger.info("name : {}", name);
		if (name.isPresent()) logger.info("name : {}", name.get());
		return "request/requestParam";
	}
	
	// 요청 파라미터 받기
	// 무엇이 넘어올지 모를 때.
	// 파라미터 값을 특정할 수 없을 경우 Map 타입으로 받을 수 있다.
	@GetMapping(value = "request/paramTestMap")
	public String paramTestMap (@RequestParam Map<String, String> paramMap) {
		logger.info("paramMap : {}", paramMap);
		return "request/requestParam";
	}
	
	// 파라미터 받기
	// @RequestParam 어노테이션을 붙이지 않으면 null 체크를 하지 않는다.
	// PostMapping 방식은 어노테이션을 @PostMapping 으로만 바꾸면 된다.
	// String, int, long 방식 모두 지원한다.
	@GetMapping(value = "request/paramTestNoAnno")
	public String paramTestNoAnno (String id, String name) {
		logger.info("id: {}", id);
		logger.info("name: {}", name);
		return "request/requestParam";
	}
	
	
}
