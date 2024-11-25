package com.digitech.springsecurityjwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitech.springsecurityjwt.api.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUserName(String username);

}
