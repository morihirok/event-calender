package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/")
	public String index(){
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("login");
		return "login";
	}
}
