package com.nm.projetjee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nm.projetjee.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
