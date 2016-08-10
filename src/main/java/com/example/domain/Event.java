package com.example.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	private Integer id;
	private LocalDate date;
	private String place;
	private String placeUrl;
	private LocalTime openTime;
	private LocalTime startTime;
	private Integer price;
	private String other;
}
