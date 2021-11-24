package com.tavant.aayushc.assignment2.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tavant.aayushc.assignment2.Bean.User;


@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getCountOfUsers() {
		return jdbcTemplate.queryForObject(
				"select count(*) from user_details", 
				Integer.class);
	}
	
	public List<User> getAllUsers() {
		return jdbcTemplate.query("select * from user_details",new RowMapper<User>() {
    
	            @Override
	            public User mapRow(ResultSet rs, int rowNum) throws SQLException{
	                User theUser=new User();
	                    theUser.setUserName(rs.getString("username"));
	                    theUser.setTourPack(rs.getString("tourpack"));
	                    theUser.setUserId(rs.getInt("userid"));
	                    return theUser;
	                }
	        
			
			});
		
		
	}


	public void deleteUserDetails(@PathVariable int id) {
		 jdbcTemplate.update(
				"delete from user_details where userid=?",id);
	}

	public void updateUserDetails(@PathVariable int id,  User theUser) {
		jdbcTemplate.update(
				"update user_details set username=?,userid=?,tourpack=? where userid=?",theUser.getUserName(),theUser.getUserId(),theUser.getTourPack(),id);
		
	}

	public void addNewUser(User theUser) {
	jdbcTemplate.update("insert into user_details(username, userid, tourpack) values(?, ?, ?)" ,theUser.getUserName(),theUser.getUserId(),theUser.getTourPack() );
		
	}
}

//	public void getUserById(@PathVariable int id) {
//	}

