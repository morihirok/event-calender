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

	public String create(Event createEvent) {

		System.out.println("in create()");

		return "update";
	}
}
