package com.nm.webapp.repositories;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.nm.webapp.models.Post;

@Repository
public class PostRepository {

	String baseApiUrl = "http://localhost:8081/apipost";

	public List<Post> getPosts() {

		String url = baseApiUrl + "/posts";

		RestTemplate resttemplate = new RestTemplate();
		// Do an http request to the api
		ResponseEntity<List<Post>> response = resttemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Post>>() {
				});

		return response.getBody();
	}

	public Post getPost(int postid) {

		String url = baseApiUrl + "/post/" + postid;

		RestTemplate resttemplate = new RestTemplate();
		// Do an http request to the api
		ResponseEntity<Post> response = resttemplate.exchange(url, HttpMethod.GET, null, Post.class);

		return response.getBody();
	}

	public Post addPost(Post post) {

		String url = baseApiUrl + "/addPost";

		RestTemplate resttemplate = new RestTemplate();

		HttpEntity<Post> request = new HttpEntity<Post>(post);

		ResponseEntity<Post> response = resttemplate.exchange(url, HttpMethod.POST, request, Post.class);

		return response.getBody();
	}

	public void deletePost(int postid) {

		String url = baseApiUrl + "/post/" + postid;

		RestTemplate resttemplate = new RestTemplate();

		resttemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

	}

	public Post updatePost(Post post) {

		String url = baseApiUrl + "/updatePost";

		RestTemplate resttemplate = new RestTemplate();

		HttpEntity<Post> request = new HttpEntity<Post>(post);

		ResponseEntity<Post> response = resttemplate.exchange(url, HttpMethod.PUT, request, Post.class);

		return response.getBody();
	}

}
