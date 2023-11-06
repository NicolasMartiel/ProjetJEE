package com.nm.projetjee.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nm.projetjee.models.User;
import com.nm.projetjee.services.UserService;

@RestController
@RequestMapping(path = "apiuser")
public class UserController {
	
	private UserService _userservice;
	
	
	
	public UserController(UserService _userservice) {
		
		this._userservice = _userservice;
	}

	//------------------POST--------------------------
	
	@ResponseStatus(value= HttpStatus.CREATED)
	@PostMapping(consumes = "application/json",path = "/addUser")
	public User addUser(@RequestBody User user) {
		return this._userservice.createUser(user);
	}
	
	@ResponseStatus(value= HttpStatus.CREATED)
	@PostMapping(consumes = "application/json",path = "/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return this._userservice.createUsers(users);
	}
	
	//-----------------GET-----------------------------
	
	@ResponseStatus(value= HttpStatus.OK)
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return this._userservice.getUserById(id);
	}
	
	@ResponseStatus(value= HttpStatus.OK)
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this._userservice.getUsers();
	}
	
	//---------------UPDATE------------------------------
	
	@ResponseStatus(value= HttpStatus.OK)
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {
		return this._userservice.updateUser(user);
	}
	
	//---------------DELETE-------------------------------
	
	@ResponseStatus(value= HttpStatus.OK)
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return this._userservice.deleteUserById(id);
	}
	
}
