package com.vishal.microservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.microservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
