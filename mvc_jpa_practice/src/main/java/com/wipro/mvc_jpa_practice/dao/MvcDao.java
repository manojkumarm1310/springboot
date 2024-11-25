package com.wipro.mvc_jpa_practice.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mvc_jpa_practice.model.Users;

@Repository
public interface MvcDao extends JpaRepository<Users, Integer> {

	Users getUsersById(Integer id);
	@Query("select name from users u")
	<List> getUsername();
	
}
