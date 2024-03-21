package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	// http://localhost:8080 -> /(root)
	@RequestMapping("/")
	public String home() {
		//return "/WEB-INF/views/home.jsp";   // home.jsp
		return "home";
				
	}

}
