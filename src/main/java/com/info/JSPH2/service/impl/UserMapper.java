package com.info.JSPH2.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.info.JSPH2.domain.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		User user = new User();
		user.setId(resultSet.getLong("id"));
		user.setEmail(resultSet.getString("email"));
		user.setName(resultSet.getString("name"));
		return user;
	}

}
