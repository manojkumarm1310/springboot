package com.wipro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
public Users findByUsername(String username);
}
