package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Event;
import com.example.repository.EventRepository;

@Controller
@RequestMapping("/update")
public class UpdateController {

	@Autowired
	EventRepository repository;
	
	@ModelAttribute
	public EventForm setUpEvent(Model model) {
		List<Event> eventList = repository.findAll();
		model.addAttribute("eventList", eventList);
		
		return new EventForm();
	}

	@RequestMapping("")
	public String updateForm() {

		return "update";
	}
	
	@RequestMapping("/create")
	public String create(EventForm postEvent){
		Event saveEvent = new Event();
		BeanUtils.copyProperties(postEvent, saveEvent);
		
		System.out.println(saveEvent.getDate() + " " + saveEvent.getOpenTime());
		repository.save(saveEvent);
		
		return "redirect:/update";
	}
}
