package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	private Integer id;
	private String title;
	private String date;
	private String place;
	private String placeUrl;
	private String openTime;
	private String startTime;
	private Integer price;
	private String other;
	
}
