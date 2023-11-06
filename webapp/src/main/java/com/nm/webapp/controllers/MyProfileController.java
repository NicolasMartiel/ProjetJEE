package com.nm.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.nm.webapp.models.Post;
import com.nm.webapp.models.User;
import com.nm.webapp.services.PostService;
import com.nm.webapp.services.UserService;

@Controller
public class MyProfileController {
	
	// For now, we are User 1,2 or 3, since login and register are not
	// implemented yet.
	int usertoUse = 1;
	
	UserService _userservice;
	PostService _postservice;

	public MyProfileController(UserService _userservice, PostService _postservice) {

		this._userservice = _userservice;
		this._postservice = _postservice;

	}

	@GetMapping(path = "/myprofile/{userid}")
	public String loadData(Model model, @PathVariable int userid) {

		// -----------------------------Posts-----------------------------------------

		
		
		userid = this.usertoUse;
		

		// solve line 45 problem
		final int id = userid;

		List<Post> userposts = new ArrayList<Post>();
		List<Post> allposts = this._postservice.getPosts();

		allposts.forEach((Post post) -> {
			if (post.getAuthor().getId() == id) {
				userposts.add(post);
			}
		});
		
		model.addAttribute("userposts", userposts);

		// -------------------------------Postsnumber---------------------------------

		int nbposts = userposts.size();
		model.addAttribute("nbposts", nbposts);

		// --------------------------------Dates--------------------------------------

		List<String> formatteddates = new ArrayList<String>();

		userposts.forEach((Post post) -> formatteddates.add(this._postservice.toCreateFormattedDate(post)));

		model.addAttribute("fdates", formatteddates);

		// --------------------------------User-----------------------------------------

		User user1 = this._userservice.getUser(userid);

		model.addAttribute("user1", user1);

		return "myprofile";

	}
	
	@GetMapping("/deletePost/{postid}")
	public ModelAndView deletePost(@PathVariable  int postid) {
		
		int userid = this._postservice.getPostById(postid).getAuthor().getId();
	    this._postservice.deletePost(postid);
	    
	    return new ModelAndView("redirect:/myprofile/"+userid);
	}
	
	
}
