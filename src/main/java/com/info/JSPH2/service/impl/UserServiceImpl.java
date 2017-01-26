package com.info.JSPH2.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.JSPH2.domain.User;
import com.info.JSPH2.service.UserService;

@Service("userService")
@Transactional
@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	

	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		
		String sql = "Select * from users";
		
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users;
		
	}

}
