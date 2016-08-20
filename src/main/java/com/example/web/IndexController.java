package com.example.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Event;
import com.example.repository.EventRepository;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	EventRepository repository;

	@RequestMapping("/")
	public String index(Model model) {
		List<Event> indexEventList = repository.findByToday();
		
		// DEBUG
//		for(Event testEvent : indexEventList){
//			System.out.println(testEvent.getDate());
//		}
		model.addAttribute("event", new Event());
		model.addAttribute("eventList", indexEventList);
		return "index";
	}

	@RequestMapping("/aboutus")
	public String aboutus(){
		
		return "aboutus";
	}
}
