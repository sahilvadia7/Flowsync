package com.flowsync.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flowsync.auth.model.User;
import com.flowsync.auth.service.UserService;

@RestController
@RequestMapping("auth")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("greet")
	public String greet() {
		return "hello world";
	}
	
	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody User user){
		return userService.RegisterUser(user);
	}
}
