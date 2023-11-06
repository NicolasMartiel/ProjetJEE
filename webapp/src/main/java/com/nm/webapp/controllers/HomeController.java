package com.nm.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nm.webapp.models.Post;
import com.nm.webapp.models.User;
import com.nm.webapp.services.PostService;
import com.nm.webapp.services.UserService;

@Controller
public class HomeController {

	// For now, we are User 1,2 or 3 , since login and register are not
	// implemented yet.
	int usertoUse = 1;
	
	UserService _userservice;
	PostService _postservice;

	public HomeController(UserService _userservice, PostService _postservice) {

		this._userservice = _userservice;
		this._postservice = _postservice;

	}

	@GetMapping(path = "/")
	public String loadData(Model model) {

		List<Post> posts = this._postservice.getPosts();
		List<User> users = this._userservice.getUsers();

		List<String> formatteddates = new ArrayList<String>();

		posts.forEach((Post post) -> formatteddates.add(this._postservice.toCreateFormattedDate(post)));

		model.addAttribute("fdates", formatteddates);
		model.addAttribute("posts", posts);
		model.addAttribute("users", users);
		model.addAttribute("usertoUse",this.usertoUse);
		model.addAttribute("currentUser",this._userservice.getUser(this.usertoUse));

		return "index";
	}

}
