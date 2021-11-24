package com.tavant.aayushc.assignment2.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tavant.aayushc.assignment2.Bean.User;
import com.tavant.aayushc.assignment2.repo.UserRepository;

@Service

public class UserService {

	@Autowired
	UserRepository repo;


	public void getCountOfUsers() {
		int c=repo.getCountOfUsers();
		System.out.println(c);

	}
	public List<User> getAllUsers() {
		return repo.getAllUsers();
		}
//
//	public User getUserById(@PathVariable int id) {
//		return repo.getUserById(id);
//	}
//
	public void addNewUser(@RequestBody User theUser) {
		repo.addNewUser(theUser);
	}
//
	public void updateUserDetails(@PathVariable int id, @RequestBody User theUser){
			repo.updateUserDetails(id, theUser);	
		}
//
	public void deleteUserDetails(@PathVariable int id) {
	repo.deleteUserDetails(id);

	}
}
