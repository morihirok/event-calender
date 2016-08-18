package com.example.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserRepository {

	@Autowired
	NamedParameterJdbcTemplate template;

	private static final RowMapper<User> userRowMapper = (rs, i) -> {
		String name = rs.getString("name");
		String password = rs.getString("password");

		return new User(name, password);
	};

	public User findByName(String name) {
		String sql = "SELECT name, password FROM users WHERE name = :name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);

		User user = new User();
		try {
			user = template.queryForObject(sql, param, userRowMapper);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public void save(User user) {
		String sql = "INSERT INTO users (name, password) VALUES (:name, :password)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);

		template.update(sql, param);
	}
}
