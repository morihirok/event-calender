package com.example.web;


import lombok.Data;

@Data
public class EventForm {
	private String title;
	private String date;
	private String place;
	private String placeUrl;
	private String openTime;
	private String startTime;
	private Integer price;
	private String other;
}
