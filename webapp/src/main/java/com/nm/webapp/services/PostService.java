package com.nm.webapp.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nm.webapp.models.Post;
import com.nm.webapp.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postrepository;
	
	public PostService(PostRepository postrepository) {
		
		this.postrepository=postrepository;
	}
	
	public List<Post> getPosts() {
		
		return this.postrepository.getPosts();
	}
	
	public Post getPostById(int postid) {
		
		return this.postrepository.getPost(postid);
		
	}
	
	public String toCreateFormattedDate(Post post) {
		
		SimpleDateFormat pattern = new SimpleDateFormat("MM/dd/YYYY HH:mm");
		Date postdate= post.getCreationDate();
		return pattern.format(postdate);
		
	}
	
	public Post  addPost(Post post) {
		
		return this.postrepository.addPost(post);
		
	}
	
	public void deletePost(int id) {
		
		this.postrepository.deletePost(id);
		
	}
	
	public Post updatePost(Post post) {
		
		return this.postrepository.updatePost(post);
		
	}
}
