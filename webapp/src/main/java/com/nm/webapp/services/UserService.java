package com.nm.webapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nm.webapp.models.User;
import com.nm.webapp.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userrepository;
	
	public UserService(UserRepository userrepository) {
		this.userrepository=userrepository;
	}
	
	public List<User> getUsers() {
		
		return this.userrepository.getUsers();
		
	}
	
	public User addUser(User user) {
		
		return this.userrepository.addUser(user);
		
	}
	
	public User getUser(int id) {
		
		return this.userrepository.getUser(id);
	}
}
