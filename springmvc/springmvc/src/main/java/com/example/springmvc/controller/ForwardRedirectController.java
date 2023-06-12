package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("url")
@Controller
public class ForwardRedirectController {

	@GetMapping("forward")
	public String forward(@RequestParam String param1) {
		log.info("forward param1: {}", param1);
		return "forward:/url/nexturl";

	}

	@GetMapping("redirect")
	public String redirect(@RequestParam(required = false) String param1) {
		log.info("redirect param1: {}", param1);
		return "redirect:/url/nexturl";
	}

	@GetMapping("nexturl")
	public String nexturl(@RequestParam(required = false) String param1, Model model) {
		log.info("nexturl 실행");
		log.info("nexturl param1 {}", param1);
		model.addAttribute("param1", param1);
		return "response/next";
	}

}
