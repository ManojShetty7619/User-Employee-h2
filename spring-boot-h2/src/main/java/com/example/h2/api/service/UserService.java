package com.example.h2.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2.api.dao.UserRepository;
import com.example.h2.api.model.UserDetails;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails addUser(UserDetails userDetails) {

		return userRepository.save(userDetails);
	}

	public List<UserDetails> getUserDetails() {

		return userRepository.findAll();
	}

	public UserDetails getuserDetailsById(int userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public String deleteUserById(int userId) {

		userRepository.deleteById(userId);
		return " user deleted";
	}

}
