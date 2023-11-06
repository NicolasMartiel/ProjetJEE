package com.nm.projetjee.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nm.projetjee.models.Post;
import com.nm.projetjee.models.User;
import com.nm.projetjee.repositories.PostRepository;

@Service
public class PostService {

	private UserService _userservice;
	private PostRepository postrepository;

	public PostService(PostRepository postrepository, UserService _userservice) {

		this._userservice = _userservice;
		this.postrepository = postrepository;
	}

	// ----------------POST---------------------------------

	public Post addPost(Post post) {

		post.setCreationDate(new Date());

		User author = post.getAuthor();

		if (author == null) {

			return null;

		} else if (this._userservice.getUserById(author.getId()) == null) {

			return null;
		}
		post.setAuthor(this._userservice.getUserById(author.getId()));
		return this.postrepository.save(post);
	}

	// ------------------GET---------------------------------

	public Post getPost(int id) {

		return this.postrepository.findById(id).orElse(null);

	}

	public List<Post> getPosts() {

		return this.postrepository.findAll();

	}

	// -------------------DELETE--------------------------------

	public String deletePost(int id) {
		
		if (getPost(id)==null) {
			
			return "Post with id " + id + " does not exist.";
			
		} else {
			
			int displayPostid=getPost(id).getAuthor().getId();
			this.postrepository.deleteById(id);
			return "Post " + id + " of User " + displayPostid + " successfully deleted.";
		}
		
	}
	
	//---------------------------UPDATE-----------------------------
	
	public Post updatePost(Post post) {
		
		Post postToUpdate = this.postrepository.findById(post.getId()).orElse(null);
		if (postToUpdate!=null) {
			
			postToUpdate.setTitle(post.getTitle());
			postToUpdate.setDescription(post.getDescription());
			postToUpdate.setImgUrl(post.getImgUrl());
			this.postrepository.save(postToUpdate);
			
		} else {
			
			return null;
			
		}
		
		return postToUpdate;
		
	}
}
