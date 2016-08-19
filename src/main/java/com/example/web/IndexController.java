package com.example.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Event;


@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		//DEBUG
		Event testEvent = new Event();
		model.addAttribute("event", testEvent);
		return "index";
	}

	@RequestMapping("/aboutus")
	public String aboutus(){
		
		return "aboutus";
	}
}
