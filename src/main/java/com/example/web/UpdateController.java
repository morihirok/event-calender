package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Event;

@Controller
@RequestMapping("/update")
public class UpdateController {

	@ModelAttribute
	public EventForm setUpEvent() {
		return new EventForm();
	}

	@RequestMapping("")
	public String updateForm() {

		return "update";
	}
	
	@RequestMapping("/create")
	public String create(EventForm event){
		
		
		return updateForm();
	}
}
