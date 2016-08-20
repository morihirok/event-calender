package com.example.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Event;


@Repository
public class EventRepository {

	@Autowired
	NamedParameterJdbcTemplate template;

	private static final RowMapper<Event> eventRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String title = rs.getString("title");
		String date = rs.getString("date");
		String place = rs.getString("place");
		String placeUrl = rs.getString("place_url");
		String openTime = rs.getString("open_time");
		String startTime = rs.getString("start_time");
		Integer price = rs.getInt("price");
		String other = rs.getString("other");

		return new Event(id, title, date, place, placeUrl, openTime, startTime, price, other);
	};

	public List<Event> findAll() {
		String sql = "SELECT id, title, date, place, place_url, open_time, start_time,price, other FROM events ORDER BY date";
		List<Event> retEventList = template.query(sql, eventRowMapper);
		
		return retEventList;
	}
	
	public List<Event> findByToday(){
		String sql = "SELECT id, title, date, place, place_url, open_time, start_time,price, other FROM events WHERE date >= :today ORDER BY date";
		
		return findByDate(sql);
	}

	public List<Event> findByPast(){
		String sql = "SELECT id, title, date, place, place_url, open_time, start_time,price, other FROM events WHERE date < :today ORDER BY date";
		
		return findByDate(sql);
	}

	private List<Event> findByDate(String sql) {
		LocalDate localToday = LocalDate.now();
		Date today = java.sql.Date.valueOf(localToday);
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("today", today);
		
		List<Event> retEventList = template.query(sql, param, eventRowMapper);
		
		return retEventList;
	}
	
	public void save(Event updateEvent){
		if(updateEvent.getId() == null){
			String sql = "INSERT INTO events (title, date, place, place_url, open_time, start_time, price, other) "
					+ "VALUES (:title, to_date(:date, 'YY-MM-DD'), :place, :placeUrl, to_timestamp(:openTime, 'HH24:MI'), to_timestamp(:startTime, 'HH24:MI'), :price, :other)";
			SqlParameterSource param = new BeanPropertySqlParameterSource(updateEvent);
			
			template.update(sql, param);
		} else {
			String sql = "UPDATE events SET id = :id, title = :title, date = to_date(:date, 'YY-MM-DD'), "
					+ "place = :place, place_url = :placeUrl, open_time = :openTime,"
					+ "start_time = :startTime, price = :price WHERE id = :id";
			SqlParameterSource param = new BeanPropertySqlParameterSource(updateEvent);
			
			template.update(sql, param);
		}
	}
}
