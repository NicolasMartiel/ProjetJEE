package com.nm.projetjee;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nm.projetjee.models.Post;
import com.nm.projetjee.models.User;
import com.nm.projetjee.repositories.PostRepository;
import com.nm.projetjee.repositories.UserRepository;

@SpringBootApplication
public class ProjetjeeApplication implements CommandLineRunner {

	UserRepository userrepository;
	PostRepository postrepository;

	public ProjetjeeApplication(UserRepository userrepository, PostRepository postrepository) {

		this.userrepository = userrepository;
		this.postrepository = postrepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetjeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Creating few users and posts in database so the website doesn't look empty at first visit.
		
		User user1;
		User user2;
		User user3;
		Post post1_1;
		Post post2_1;
		Post post3_1;
		
		if (this.userrepository.findByEmail("johndoe@gmail.com") == null) {

			 user1 = new User("John", "Doe", "johndoe@gmail.com");
			 
			 post1_1 = new Post("post zéro", "premier post du site", user1,"https://cdn.pixabay.com/photo/2023/10/12/20/51/autumn-8311804_960_720.jpg");
			 post1_1.setCreationDate(new Date());
			 
			 userrepository.save(user1);
			 postrepository.save(post1_1);

		}

		if (this.userrepository.findByEmail("janedoe@orange.fr") == null) {

			user2 = new User("Jane", "Doe", "janedoe@orange.fr");
			
			post2_1 = new Post("post sympa", "petit post sympathique", user2,"https://cdn.pixabay.com/photo/2023/10/12/23/33/bird-8311908_960_720.jpg");
			post2_1.setCreationDate(new Date());
			
			userrepository.save(user2);
			postrepository.save(post2_1);

		}

		if (this.userrepository.findByEmail("paulm@outlook.fr") == null) {

			user3 = new User("Paul", "Martin", "paulm@outlook.fr");
			post3_1 = new Post("post intéressant", "post super intéressant", user3,"https://cdn.pixabay.com/photo/2023/10/12/16/57/flowers-8311282_960_720.jpg");
			post3_1.setCreationDate(new Date());
			
			userrepository.save(user3);
			postrepository.save(post3_1);
		}

		

		

		

		

	}

}
