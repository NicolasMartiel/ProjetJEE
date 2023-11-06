package com.nm.projetjee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nm.projetjee.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
		
		User findByEmail(String email);
		
}
