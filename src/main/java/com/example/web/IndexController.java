package com.example.web;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Event;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		// FOR DEBUG
		Event event = new Event(1, "EVENT TITLE",LocalDate.of(2016, 8, 24),"Shinjuku","http://rakus.co.jp",LocalTime.of(18, 00),LocalTime.of(19, 00),2000,"Party");
		model.addAttribute("event", event);

		return "index";
	}

}
