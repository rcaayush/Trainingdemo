package com.tavant.dao;

import java.beans.JavaBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tavant.user.User;


@Repository

public class DatabaseOperations {
	 static ArrayList<String> list=new ArrayList<String>();

	//@Autowired
//	UserMapper mapper;
	String qry;
	
	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	int getCountOfUsers() {
		return jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
	}
	

	
	public int createUser(String name,int balance)
	{
		int account_Number=(int) Math.random();
		return jdbcTemplate.update("insert into users(Account_number, Name, balance) values(?, ?, ?)",new Object[] {account_Number,name,balance} );
		
	}
	
	public String showbalance(String name) {
		return jdbcTemplate.queryForObject("select balance from users where Name=?",new Object[] {name},String.class );

	}

	public int Deposit(String name, int bal) {
		int q1= jdbcTemplate.queryForObject("select balance from users where Name=?",new Object[] {name},Integer.class );
		int sum=q1+bal;
		return jdbcTemplate.update("update users set balance=? where name=?",new Object[]{sum,name});
		
	}
	public int Withdraw(String name, int bal) {
		int q1= jdbcTemplate.queryForObject("select balance from users where Name=?",new Object[] {name},Integer.class );
		int sum=q1-bal;
		return jdbcTemplate.update("update users set balance=? where name=?",new Object[]{sum,name});
		
	}

	public int FundTransfer(String name1, String name2, int bal) {
		int q1= jdbcTemplate.queryForObject("select balance from users where Name=?",new Object[] {name1},Integer.class );
		int sum=q1-bal;
		 jdbcTemplate.update("update users set balance=? where name=?",new Object[]{sum,name1});
		 int q2= jdbcTemplate.queryForObject("select balance from users where Name=?",new Object[] {name2},Integer.class );
			int sum2=q2+bal;
			return jdbcTemplate.update("update users set balance=? where name=?",new Object[]{sum2,name2});
			
	}
	
	public int deleteRow(String name) {
		return jdbcTemplate.update("delete from users where Name=?",new Object[] {name});
		
	}
	

	public List<User>getAllUserDetails() {
		
//		return jdbcTemplate.query("select * from users",new RowMapper<User>() {
//       
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException{
//                User theUser=new User();
//                //  Map the fields of User to the columns of the table:userdetails
//                    theUser.setName(rs.getString("Name"));
//            
//                    
//                    return theUser;
//                }
//        
//		
//		});
		
		return jdbcTemplate.query("select * from users",(ResultSet rs, int rowNum)->{
            User theUser=new User();
            //  Map the fields of User to the columns of the table:userdetails
                theUser.setName(rs.getString("Name"));
        
                
                return theUser;
		});
    
		
	}

	public void TransactionHistory() {
		// TODO Auto-generated method stub
		System.out.println("Transaction history is as follows :");

        for(String name:list) {

        System.out.println(name);
		
	}
	}
}
	


//	@Component
//	//@Scope("prototype")
//	class UserMapper implements RowMapper<User>{
//		@Autowired
//		User theuser;
//		public User mapRow(ResultSet rs,int rowNum) throws SQLException {
//			
//			theuser.setName(rs.getString("Name"));
//			return theuser;
//		}
//	
//		}
//	


// class UserMapper implements RowMapper{
//	@Autowired
//	User theuser;
//
//public User mapRow(ResultSet rs,int rowNum) throws SQLException {
//	theuser.setName(rs.getString("Name"));
//	return theuser;
//}


 

