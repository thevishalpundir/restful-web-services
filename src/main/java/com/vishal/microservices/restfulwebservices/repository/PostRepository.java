package com.vishal.microservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.microservices.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
