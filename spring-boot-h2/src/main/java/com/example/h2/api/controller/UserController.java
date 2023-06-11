package com.example.h2.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.api.model.UserDetails;
import com.example.h2.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/saveUsers")
	public UserDetails addUserDetails(@RequestBody UserDetails userDetails) {
		return userService.addUser(userDetails);

	}

	@GetMapping("/getAlluserdetails")
	public List<UserDetails> getAlluserDetail() {
		return userService.getUserDetails();

	}

	@RequestMapping("/userDetails/{userId}")
	public UserDetails getUserById(@PathVariable("userId") int userId) {
		return userService.getuserDetailsById(userId);
	}

	@DeleteMapping("/userDetails/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return userService.deleteUserById(userId);

	}

}
