package com.nm.projetjee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nm.projetjee.models.User;
import com.nm.projetjee.repositories.UserRepository;

@Service
public class UserService {

	
	private UserRepository userrepository;

	public UserService(UserRepository userrepository) {
		
		this.userrepository = userrepository;
	}

	//--------------------- POST---------------------
	
	public User createUser(User user) {
		//Here we consider email as unique
		User existinguser=this.userrepository.findByEmail(user.getEmail());
		if (existinguser==null) {
			
			this.userrepository.save(user);
			return user;
			
		} else {
			
			return null;
		}
		
	}

	public List<User> createUsers(List<User> user) {

		return this.userrepository.saveAll(user);
	}

	//------------------------GET----------------------
	
	public User getUserById(int id) {

		return this.userrepository.findById(id).orElse(null);
	}

	public List<User> getUsers() {

		return this.userrepository.findAll();
	}

	//------------------------ UPDATE------------------
	
	public User updateUser(User user) {

		User usertoupdate = this.userrepository.findById(user.getId()).orElse(null);

		if (usertoupdate != null) {

			usertoupdate.setEmail(user.getEmail());
			this.userrepository.save(usertoupdate);

		} else {

			return new User(user.getFirstname(),user.getLastname(),user.getEmail());
		}

		return usertoupdate;
	}
	
	//---------------------------DELETE-------------------
	
	public String deleteUserById(int id) {
		this.userrepository.deleteById(id);
		return "User " + id + " successfully deleted.";
	}
	
	//----------------------------------------------------

}