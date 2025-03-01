package com.flowsync.auth.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flowsync.auth.model.User;
import com.flowsync.auth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public ResponseEntity<?> RegisterUser(User user){
		if(user == null || user.getName() == null || user.getPassword() == null) {
			return new ResponseEntity<>("Invalid Data",HttpStatus.BAD_REQUEST);
		}
		
        Optional<User> existingUser = userRepo.findByName(user.getName());
        Optional<User> existingEmail = userRepo.findByEmail(user.getEmail());
        
        if(existingUser.isPresent() || existingEmail.isPresent()) {
        	return new ResponseEntity<>("User already registered",HttpStatus.CONFLICT);
        }
        
        user.setCreatedAt(new Date());
        try{
        	userRepo.save(user);
        	return new ResponseEntity<>("User registered successfully",HttpStatus.OK);
        }
        catch(Exception e) {
        	return new ResponseEntity<>("Error while registering user",HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	
	
	
}
