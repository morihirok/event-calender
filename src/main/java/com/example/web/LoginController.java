package com.example.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserRepository repository;
	
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

		User user = repository.findByName(getUser.getName());
		
		if(user == null	){
			return login();
		}
		return "redirect:/update";
	}
	
	@RequestMapping("/createUserForm")
	public String createUserForm(){
		return "createUser";
	}
	
	@RequestMapping("/createUser")
	public String createUser(UserForm userForm){
		
		System.out.println(userForm.getName());
		
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		
		repository.save(user);
		
		return login();
	}
}
