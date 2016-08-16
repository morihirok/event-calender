package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	@ModelAttribute
	public UserForm setUpUser(){
		return new UserForm();
	}
	@RequestMapping("")
	public String login() {
		return "login";
	}

	@RequestMapping("/confirm")
	public String confirm(User getUser) {

		System.out.println(getUser.getName());

		return "update";
	}
}
