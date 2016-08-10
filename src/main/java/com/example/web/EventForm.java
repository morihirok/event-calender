package com.example.web;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class EventForm {
	private Integer id;
	private LocalDate date;
	private String place;
	private String placeUrl;
	private LocalTime openTime;
	private LocalTime startTime;
	private Integer price;
	private String other;
}
