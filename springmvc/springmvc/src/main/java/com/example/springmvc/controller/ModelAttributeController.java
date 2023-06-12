package com.example.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.springmvc.model.Member;

import lombok.extern.slf4j.Slf4j;

// ModelAttribute 는 클래스 타입으로 파라미터를 받을 수 있다.

@Slf4j
// member 라는 이름을 모델이 만들어 지면 세션에도 자동으로 저장한다.
@SessionAttributes("member")
@RequestMapping("model")
@Controller
// 클래스에 리퀘스트맵핑을 주면 하위 메소드들의 url 값에 다 붙는다. 앞에 model/을 안 붙여도 된다.
public class ModelAttributeController {

	// @ModelAttribute 가 메소드 레벨에 있으면 컨트롤러에서 실행되는
	// 모든 메소드 앞에 먼저 호출되어 실행된다.
	@ModelAttribute
	public void defaultModel(Model model) {
		log.info("defaultModel 호출");
		Member member = new Member("defaultId", "defaultName", 10);
		model.addAttribute("member", member);
	}

	@GetMapping(value = "memberModel")
	public String memberModel(String id) {
		log.info("memberModel 메소드 실행");
		log.info("id: {}", id);
		return "request/modelAttribute";
	}

	@GetMapping("memberModelV1")
	public String memberModelV1(@ModelAttribute Member member) {
		log.info("member: {}", member);
		return "request/modelAttribute";
	}

	@GetMapping("memberModelV2")
	public String memberModelV2(@ModelAttribute(name = "memberInfo") Member member, Model model) {
		// name 값을 지정해주면 name 값으로, 지정이 없으면 변수의 이름으로 지정된다.
		log.info("member: {}", member);
//		model.addAttribute("memberInfo", member);
		// Map 과 비슷하다
		// 모델에 넣고싶은 값이 있을 때 쓰는 것.
		log.info("model: {}", model.getAttribute("memberInfo"));

		return "request/modelAttribute";
	}

	@GetMapping("sessionRead")
	public String sessionRead(HttpServletRequest request) {
		log.info("sessionRead 실행");

		HttpSession session = request.getSession();
		session.setAttribute("sessionValue", "홍길동");

		return "request/modelAttribute";
	}

	@GetMapping("sessionClear")
	public String sessionComplete(// HttpServletRequest request
			SessionStatus status) {
		log.info("sessionComplete 실행");

//		HttpSession session = request.getSession();
//		session.setAttribute("sessionValue", null);
//		session.invalidate();		// 세션 다 지우기
		status.setComplete();		// 자동으로 저장된 세션 값 삭제

		return "request/modelAttribute";
	}

}
