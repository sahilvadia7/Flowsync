package com.flowsync.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowsync.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 Optional<User> findByName(String name);
	 Optional<User> findByEmail(String email);
}
