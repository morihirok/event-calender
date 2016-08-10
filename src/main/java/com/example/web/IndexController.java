package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Event;
import com.example.domain.User;

@Controller
@RequestMapping("/")
public class IndexController {

	@ModelAttribute
	public UserForm setUpUser(){
		return new UserForm();
	}
	
	@ModelAttribute
	public EventForm setUpEvent(){
		return new EventForm();
	}

	@RequestMapping("/")
	public String index(Model model){

		return "index";
	}
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("login");
		return "login";
	}
	
	@RequestMapping("/confirm")
	public String confirm(User getUser){
		
		System.out.println(getUser.getName());
		
		return "update";
	}
	
	public String create(Event createEvent){
		
		System.out.println("in create()");
		
		return "update";
	}
}
