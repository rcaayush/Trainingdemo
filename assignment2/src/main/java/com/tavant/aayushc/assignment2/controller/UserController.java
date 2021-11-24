package com.tavant.aayushc.assignment2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.aayushc.assignment2.Bean.User;
import com.tavant.aayushc.assignment2.repo.UserRepository;
import com.tavant.aayushc.assignment2.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService theService;
	

	@GetMapping("count")
	void getCountOfUsers() {
		theService.getCountOfUsers();
	}
	
	@GetMapping("/users")
	List<User> getAllLearners(){
		return  theService.getAllUsers();
	}
	
	@PostMapping("/create")
	void addNewUser(User theuser){
		  theService.addNewUser(theuser);
	}

	@PutMapping("update/{id}")
	void updateLearnerDetails(@PathVariable int id, @RequestBody User theLearner){
			theService.updateUserDetails(id, theLearner);
		
	}
		
	@DeleteMapping("delete/{id}")
	void deleteLearnerDetails(@PathVariable int id) {
		theService.deleteUserDetails(id);
	}


	
}
