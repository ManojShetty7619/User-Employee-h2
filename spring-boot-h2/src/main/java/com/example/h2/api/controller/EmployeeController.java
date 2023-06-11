package com.example.h2.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.api.dao.EmployeeRepository;
import com.example.h2.api.dao.UserRepository;
import com.example.h2.api.model.Employee;
import com.example.h2.api.model.UserDetails;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee, HttpServletRequest httpServletRequest) {
		String str = "";
		String userName = httpServletRequest.getHeader("userName");
		String password = httpServletRequest.getHeader("password");
		// UserDetails userDetails = userRepository.findByUserFirstname(userName);
		UserDetails userDetails = userRepository.findByUserLastName(userName);
		if (password.equals(userDetails.getPassword())) {
			repository.save(employee);
			str = "Employee Saved..";
		} else {
			str = "invalid user";
		}

		return str;

	}

//	@GetMapping("/getAllEmployees")
//	public List<Employee> getAll() {
//		return repository.findAll();
//	}

}
